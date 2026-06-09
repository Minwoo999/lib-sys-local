package lms.common.oauth.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lms.common.oauth.service.OAuthService;
import lms.model.MemberVO;

@Service("kakaoOAuthService")
public class KakaoOAuthService implements OAuthService {

    @Value("${kakao.client.id}")
    private String clientId;

    @Value("${kakao.client.secret}")
    private String clientSecret;

    @Value("${kakao.redirect.uri}")
    private String redirectUri;

    //
    @Override
    public String getAuthorizationUrl(HttpSession session) {
        String state = UUID.randomUUID().toString();
        session.setAttribute("kakao_state", state);

        StringBuilder url = new StringBuilder();
        url.append("https://kauth.kakao.com/oauth/authorize");
        url.append("?response_type=code");
        url.append("&client_id=" + clientId);
        url.append("&redirect_uri=" + redirectUri);
        url.append("&state=" + state);

        return url.toString();
    }

    //
    @Override
    public String getAccessToken(HttpSession session, String code, String state) throws Exception {

        String sessionState = (String) session.getAttribute("kakao_state");
        if (sessionState == null || !sessionState.equals(state)) {
            throw new Exception("보안 인증값이 일치하지 않습니다.");
        }

        //
        // POST 양식에 맞는지 검증하기
        //

        StringBuilder apiURL = new StringBuilder();
        apiURL.append("https://kauth.kakao.com/oauth/token");
        apiURL.append("?grant_type=authorization_code");
        apiURL.append("&client_id=" + clientId);
        apiURL.append("&client_secret=" + clientSecret);
        apiURL.append("&code=" + code);

        URL url = new URL(apiURL.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();

        BufferedReader br;

        if (responseCode == 200) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }

        String inputLine;
        StringBuilder res = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            res.append(inputLine);
        }
        br.close();

        return extractProperty(res.toString(), "access_token");
    }

    @Override
    public MemberVO getUserProfile(String accessToken) throws Exception {
        String apiURL = "https://kapi.kakao.com/v2/user/me";

        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);

        int responseCode = con.getResponseCode();

        BufferedReader br;
        if (responseCode == 200) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }

        String inputLine;
        StringBuilder res = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            res.append(inputLine);
        }
        br.close();

        String jsonResponse = res.toString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);
  
        MemberVO vo = new MemberVO();

        vo.setLoginId(rootNode.get("id").asText());

        JsonNode accountNode = rootNode.get("kakao_account");
        if (accountNode != null) {
            vo.setEmail(accountNode.path("email").asText()); 

    
            JsonNode profileNode = accountNode.get("profile");
            if (profileNode != null) {
                vo.setName(profileNode.path("nickname").asText()); 
            }
        }

        vo.setLoginType(2); 
        return vo;
    }
}
