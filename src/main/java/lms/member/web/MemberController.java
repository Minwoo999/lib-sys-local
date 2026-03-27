package lms.member.web;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lms.member.service.MemberService;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 1. 회원가입
    @GetMapping("/join.do")
    public String joinForm() {
        return "member/join";
    }

    @PostMapping("/join.do")
    public String join(MemberVO memberVO, Model model) {
        try {
            memberService.joinMember(memberVO);
            return "redirect:/member/login.do";
        } catch (Exception e) {
            model.addAttribute("msg", e.getMessage());
            return "member/join";
        }
    }

    // 2. 로그인
    @GetMapping("/login.do")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/login.do")
    public String login(MemberVO memberVO, HttpSession session, RedirectAttributes rttr) {
        try {
            MemberVO loginUser = memberService.loginMember(memberVO);
            session.setAttribute("loginUser", loginUser);
            return "redirect:/main.do";
        } catch (Exception e) {
            rttr.addFlashAttribute("msg", e.getMessage());
            return "redirect:/member/login.do";
        }
    }

    // 3. 로그아웃
    @GetMapping("/logout.do")
    public String logoutMember(HttpSession session) {
        session.invalidate();
        return "redirect:/main.do";
    }
}