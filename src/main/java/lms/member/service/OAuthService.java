package lms.member.service;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface OAuthService {

    // 1. 요청 URL 생성
    String getAuthorizationUrl(HttpSession session);

    // 2. code를 token으로 바꾸기
    String getAccessToken(HttpSession session, String code, String state) throws Exception;

    // 3. toekn을 이용해 프로필 정보 조회
    String getUserProfile(String accessToken) throws Exception;









    // JSON 파서
    default String extracProperty(String jsonResponse, String propertyName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonResponse);

        JsonNode node = rootNode.get(propertyName);
        if (node == null)
            return null;

        return node.asText();
    }
}
