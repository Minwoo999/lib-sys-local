package lms.member.service.impl;

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

import lms.member.service.OAuthService;
import lms.model.MemberVO;

@Service("naverOAuthService")
public class NaverOAuthService implements OAuthService {

    @Value("${naver.client.id}")
    private String clientId;

    @Value("${naver.client.secret}")
    private String clientSecret;

    @Value("${naver.redirect.uri}")
    private String redirectUri;

    // 1. 인증요청
    @Override
    public String getAuthorizationUrl(HttpSession session) {
        String state = UUID.randomUUID().toString();

        session.setAttribute("naver_state", state);

        StringBuilder url = new StringBuilder();
        url.append("https://nid.naver.com/oauth2.0/authorize");   // 1. 입구
        url.append("?response_type=code");   // 2. 응답 데이터 형식
        url.append("&client_id=" + clientId);   // 3. 내 ID(호출자) 
        url.append("&redirect_uri=" + redirectUri);  // 4. 회신 주소
        url.append("&state=" + state);   // 5. 요청 시작 해시값

        return url.toString();
    }

    // 콜백으로 받음

    // 2. 토큰발급
    @Override
    public String getAccessToken(HttpSession session, String code, String state) throws Exception {

        String sessionState = (String) session.getAttribute("naver_state");
        if (sessionState == null || !sessionState.equals(state)) {
            throw new Exception("보안 인증 값이 일치하지 않습니다.");
        }

        StringBuilder apiURL = new StringBuilder();
        apiURL.append("https://nid.naver.com/oauth2.0/token");   // 1. 입구
        apiURL.append("?grant_type=authorization_code");   // 2. 승인 코드 형식: 인증코드 
        apiURL.append("&client_id=" + clientId);   
        apiURL.append("&client_secret=" + clientSecret);   // 4. 비밀번호
        apiURL.append("&code=" + code);   // 5. 받은 코드 다시 주기
        apiURL.append("&state=" + state);   // 6. 해시 (한 번 더 검증)

        URL url = new URL(apiURL.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader br;
        if (responseCode == 200) {
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            br = new BufferedReader((new InputStreamReader(con.getErrorStream())));
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
        JsonNode node = rootNode.get("access_token");

        return node.asText();
    }


    // 3. 프로필 가져오기
    @Override
    public MemberVO getUserProfile(String accessToken) throws Exception {
        String apiURL = "https://openapi.naver.com/v1/nid/me";

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
        JsonNode responseNode = rootNode.get("response");

  
        MemberVO vo = mapper.treeToValue(responseNode, MemberVO.class);

        vo.setLoginType(1);
        

        return vo;
    }
}

