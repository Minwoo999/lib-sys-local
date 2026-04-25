package lms.member.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lms.member.service.MemberService;
import lms.member.service.OAuthService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/OAuth")
@RequiredArgsConstructor

public class OAuthController {
    private final Map<String, OAuthService> OAuthServiceMap;
    private final MemberService memberService;

    // 1. 진입
    @GetMapping("/login/{type.do}")
    public String loginForm() {
        return "/OAuth/login"
    }
}
