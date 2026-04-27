package lms.member.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lms.member.service.MemberService;
import lms.member.service.OAuthService;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/OAuth")
@RequiredArgsConstructor

public class OAuthController {
    private final Map<String, OAuthService> oauthServiceMap;
    private final MemberService memberService;


    @GetMapping("/login/{type}.do")
    public String login(@PathVariable String type, HttpSession session) {
        OAuthService service = oauthServiceMap.get(type + "OAuthService");

        String authUrl = service.getAuthorizationUrl(session);

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

            return "redirect:/OAuth/index.do";
        }
        catch(Exception e){
            return "redirect:/member/login.do?error=true";
        }
    }

}
