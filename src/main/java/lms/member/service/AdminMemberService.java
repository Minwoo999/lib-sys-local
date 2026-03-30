package lms.member.service;

import java.util.List;
import lms.model.MemberVO;

public interface AdminMemberService {
    
    // 1. 전체 회원 목록 조회
    List<MemberVO> getMemberList();

    // 2. 회원 상세 조회
    MemberVO getMemberDetail(int memberId);

    // 3. 회원 상태 강제 변경 
    int changeMemberStatus(MemberVO vo);

    // 4. 관리자 권한으로 정보 수정
    int updateMemberByAdmin(MemberVO vo);
}