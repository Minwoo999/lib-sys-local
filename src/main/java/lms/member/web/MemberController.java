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

    // 1. 로그인
    @GetMapping("/login.do")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/login.do")
    public String login(MemberVO vo, HttpSession session, RedirectAttributes ra) {
        try {
            MemberVO loginUser = memberService.login(vo);
            session.setAttribute("loginUser", loginUser);
            return "redirect:/index.do";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("msg", e.getMessage());
            return "redirect:/member/login.do";
        }
    }

    // 2. 회원가입
    @GetMapping("/join.do")
    public String joinForm() {
        return "member/join";
    }

    @PostMapping("/join.do")
    public String join(MemberVO vo, RedirectAttributes ra) {
        try {
            memberService.join(vo);
            ra.addFlashAttribute("msg", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/member/login.do";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("msg", e.getMessage());
            return "redirect:/member/join.do";
        }
    }

    @GetMapping("/myPage.do")
    public String myPage(HttpSession session, Model model) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/member/login.do";
        }
        System.out.println("사용자:  " + loginUser.getName());

        MemberVO userInfo = memberService.getMemberDetail(loginUser.getMemberId());
        model.addAttribute("userInfo", userInfo);
        return "member/mypage";
    }

    // 4. 내 정보 수정
    @PostMapping("/modify.do")
    public String modify(MemberVO vo, HttpSession session) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        vo.setMemberId(loginUser.getMemberId());
        memberService.modifyMyInfo(vo);

        return "redirect:/member/myPage.do";
    }

    // 5. 탈퇴 처리
    @PostMapping("/withdraw.do")
    public String withdraw(HttpSession session) {
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
        memberService.withdraw(loginUser.getMemberId());
        session.invalidate();
        return "redirect:/index.do";
    }

    // 6. 로그아웃
    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.do";
    }
}