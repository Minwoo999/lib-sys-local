package lms.member.service;

import javax.servlet.http.HttpSession;

public interface OAuthService {

    // 1. 요청 URL 생성
    String getAuthorizationUrl(HttpSession session);

    // 2. code를 token으로 바꾸기
    String getAccessTocken(HttpSession session, String code, String state) throws Exception;
}
