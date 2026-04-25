package lms.member.service;

import lms.model.MemberVO;

public interface MemberService {
    // 1. 가입 및 로그인
    int join(MemberVO vo);

    MemberVO login(MemberVO vo);

    // 2. 본인 정보 관리
    int modifyMyInfo(MemberVO vo); // 내 정보 수정

    int modifyPassword(MemberVO vo); // 비밀번호 변경

    int withdraw(int memberId); // 회원 탈퇴

    // 3. 회원 상세 조회
    MemberVO getMemberDetail(int memberId);

    // 4. 소셜 로그인
    MemberVO loginBySns(MemberVO snsUser) throws Exception;
}