package lms.common.auth.oauth.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lms.common.auth.oauth.service.OAuthService;
import lms.member.service.MemberService;
import lms.model.MemberVO;

@Controller
@RequestMapping("/OAuth")
public class OAuthController {

    private final Map<String, OAuthService> oauthServiceMap;
    private final MemberService memberService;

    // 1. 수동 주입: 스프링 4.3에서 롬복이 가끔 찐빠낼 때가 있어서 수동으로 잡습니다.
    @Autowired
    public OAuthController(Map<String, OAuthService> oauthServiceMap, MemberService memberService) {
        this.oauthServiceMap = oauthServiceMap;
        this.memberService = memberService;
    }

    @GetMapping("/login/{type}.do")
    public String login(@PathVariable String type, HttpSession session) {
    
        System.out.println(">>> [STEP 1] 컨트롤러 진입 성공! 요청된 타입: " + type);
        System.out.println(">>> [STEP 2] 주머니(Map)에 있는 서비스들: " + oauthServiceMap.keySet());

        String serviceName = type + "OAuthService";
        OAuthService service = oauthServiceMap.get(serviceName);

        if (service == null) {
            System.out.println(">>> [ERROR] 서비스를 못 찾았습니다! 찾으려던 이름: " + serviceName);
            return "redirect:/member/login.do?error=serviceNotFound";
        }

        String authUrl = service.getAuthorizationUrl(session);
        System.out.println(">>> [STEP 3] 네이버/카카오로 보내줄 주소: " + authUrl);

        return "redirect:" + authUrl;
    }

        @GetMapping("/callback/{type}.do")
    public String callback(@PathVariable String type, @RequestParam String code, @RequestParam String state,
            HttpSession session) {
        try{
            OAuthService service = oauthServiceMap.get(type+"OAuthService");

            String accessToken = service.getAccessToken(session, code, state);

            MemberVO snsUser = service.getUserProfile(accessToken);

            MemberVO loginMember = memberService.loginBySns(snsUser);

            session.setAttribute("loginUser", loginMember);

            return "redirect:/lib-sys/index.do";
        }
        catch(Exception e){
            return "redirect:/member/login.do?error=true";
        }
    }
    // callback 메서   드는 일단 그대로 두셔도 됩니다.
}