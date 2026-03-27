package lms.member.service;

import lms.model.MemberVO;

public interface MemberService {
    int joinMember(MemberVO memberVO);

    MemberVO loginMember(MemberVO memberVO);
}
