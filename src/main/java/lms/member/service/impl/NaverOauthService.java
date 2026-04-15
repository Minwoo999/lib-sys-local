package lms.member.service.impl;

import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lms.member.service.OAuthService;

@Service
public class NaverOauthService implements OAuthService {
    private static final String CLIENT_ID = "B5n1p9KhSRITN5ISiahO";
    private static final String REDIRECT_URI = "http://localhost:8080/lib-sys/naverCallback.do";
    private static final String CLIENT_SECRET = "G_jNma7N89";

    @Override
    public String getAuthorizationUrl(HttpSession session) {
        String state = UUID.randomUUID().toString();

        session.setAttribute("oauth_state", state);

        StringBuilder url = new StringBuilder();
        url.append("https://nid.naver.com/oauth2.0/authorize");
        url.append("?response_type=code");
        url.append("&client_id=" + CLIENT_ID);
        url.append("&redirect_uri=" + REDIRECT_URI);
        url.append("&state=" + state);

        return url.toString();
    }

    @Override
    public String getAccessTocken(HttpSession session, String code, String state) throws Exception {

        String sessionState = (String) session.getAttribute("oauth_state");
        if (sessionState == null || !sessionState.equals(state)) {
            throw new Exception("보안 인증 값이 일치하지 않습니다.");
        }


        StringBuilder apiURL = new StringBuilder();
        apiURL.append("https://nid.naver.com/oauth2.0/token");
        apiURL.append("?grant_type=authorization_code");
        apiURL.append("&client_id=" + CLIENT_ID);
        apiURL.append("&client_secret=" +CLIENT_SECRET);
        apiURL.append("&code" + code);
        apiURL.append("&state=" + state);


URL url = new URL(apiURL)

        return "a";
    }
}
