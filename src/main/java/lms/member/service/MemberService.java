package lms.member.service;

import java.util.List;

import lms.model.MemberVO;

public interface MemberService {
    // 공통
    int joinMember(MemberVO memberVO);

    MemberVO loginMember(MemberVO memberVO);

    int modifyMember(MemberVO memberVO); // 정보 수정

    int modifyPassword(MemberVO memberVO); // 비밀번호 변경

    int removeMember(int memberId); // 탈퇴 (Status 0 처리)

    // 관리자
    List<MemberVO> getMemberList(); // 전체 목록

    MemberVO getMemberDetail(int memberId); // 회원 상세

    int modifyStatus(MemberVO memberVO); // 상태 강제 변경
}
