package lms.admin.service;

import java.util.List;
import lms.model.MemberVO;

public interface AdminService {
    
    // 전체 회원 목록 조회
    List<MemberVO> getMemberList();

    //  회원 상태 강제 변경 
    int changeMemberStatus(MemberVO vo);

    // 관리자 권한으로 정보 수정
    int updateMemberByAdmin(MemberVO vo);

    //  회원 상세 조회
    MemberVO getMemberDetail(int memberId);
}