package lms.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lms.admin.service.AdminService;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminMemberService;

    // 1. 회원 전체 목록 조회
    @GetMapping("/memberList.do")
    public String memberList(Model model) {
        model.addAttribute("list", adminMemberService.getMemberList());
        return "admin/memberList";
    }

    // 2. 회원 상세 조회
    @GetMapping("/memberDetail.do")
    public String memberDetail(int memberId, Model model) {
        model.addAttribute("member", adminMemberService.getMemberDetail(memberId));
        return "admin/memberDetail";
    }

    // 3. 회원 상태 변경 (강퇴, 정지 등)
    @PostMapping("/changeStatus.do")
    public String changeStatus(MemberVO vo) {
        adminMemberService.changeMemberStatus(vo);
        return "redirect:/admin/memberList.do";
    }

    // 4. 관리자 권한으로 회원 정보 수정
    @PostMapping("/updateMember.do")
    public String updateMember(MemberVO vo) {
        adminMemberService.updateMemberByAdmin(vo);
        return "redirect:/admin/memberDetail.do?memberId=" + vo.getMemberId();
    }
    
}