package lms.member.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lms.member.service.OAuthService;

@Service
public class NaverOauthService implements OAuthService {

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

        session.setAttribute("oauth_state", state);

        StringBuilder apiURL = new StringBuilder();
        apiURL.append("https://nid.naver.com/oauth2.0/authorize");
        apiURL.append("?response_type=code");
        apiURL.append("&client_id=" + clientId);
        apiURL.append("&redirect_uri=" + redirectUri);
        apiURL.append("&state=" + state);

        return apiURL.toString();
    }

    // 2. 토큰발급
    @Override
    public String getAccessToken(HttpSession session, String code, String state) throws Exception {

        String sessionState = (String) session.getAttribute("oauth_state");
        if (sessionState == null || !sessionState.equals(state)) {
            throw new Exception("보안 인증 값이 일치하지 않습니다.");
        }

        StringBuilder apiURL = new StringBuilder();
        apiURL.append("https://nid.naver.com/oauth2.0/token");
        apiURL.append("?grant_type=authorization_code");
        apiURL.append("&client_id=" + clientId);
        apiURL.append("&client_secret=" + clientSecret);
        apiURL.append("&code=" + code);
        apiURL.append("&state=" + state);

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
        return extracProperty(jsonResponse, "access_token");
    }

    // 3. 프로필 가져오기
    @Override
    public String getUserProfile(String accessToken) throws Exception {
        String apiURL = ""

        return "a";
    }
}
