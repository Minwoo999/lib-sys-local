package lms.member.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.MemberVO; // 기존 entity.Member에서 MemberVO로 변경

@Repository("memberDAO")
public class MemberDAO extends EgovAbstractMapper {

    // 회원가입
    public int insertMember(MemberVO memberVO) {
        return insert("MemberDAO.insertMember", memberVO);
    }

    // 로그인 체크 (VO 반환)
    public MemberVO selectLoginId(String loginId) {
        return selectOne("MemberDAO.selectLoginId", loginId);
    }

    // ID 중복 체크
    public int countLoginId(String loginId) {
        return selectOne("MemberDAO.countLoginId", loginId);
    }

    // 정보 보기 (VO 반환)
    public MemberVO selectId(int id) {
        return selectOne("MemberDAO.selectId", id);
    }

    // 비밀번호 변경
    public int updatePassword(MemberVO memberVO) {
        return update("MemberDAO.updatePassword", memberVO);
    }

    // 정보 수정
    public int updateMember(MemberVO memberVO) {
        return update("MemberDAO.updateMember", memberVO);
    }

    // 탈퇴 / 정지 (파라미터 불일치 해결)
    // XML에서 #{memberStatus}와 #{memberId} 두 개를 요구하므로 VO를 통째로 넘깁니다.
    public int updateStatus(MemberVO memberVO) {
        return update("MemberDAO.updateStatus", memberVO);
    }

    // 회원 목록
    public List<MemberVO> selectMemberList() {
        return selectList("MemberDAO.selectMemberList");
    }

    // 소셜ID 조회
    public MemberVO selectBySns(MemberVO memberVO) {
        return selectOne("MemberDAO.selectBySns", memberVO);
    }

    // 소셜 이메일 중복 체크
    public int countEmail(String email) {
        return selectOne("MemberDAO.countEmail", email);
    }

    // 대출 / 반납
    public int increaseCurrentLoanCnt(MemberVO memberVO) {
        return update("MemberDAO.increaseCurrentLoanCnt", memberVO);
    }

    public int decreaseCurrentLoanCnt(int memberId) {
        return update("MemberDAO.decreaseCurrentLoanCnt", memberId);
    }
}