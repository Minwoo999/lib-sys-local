package lms.member.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.member.dao.MemberDAO;
import lms.member.service.MemberService;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public int joinMember(MemberVO memberVO) {
        if (memberDAO.countLoginId(memberVO.getLoginId()) == 0) {

            memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
            return memberDAO.insertMember(memberVO);
        }
        throw new RuntimeException("중복된 아이디입니다.");
    }

    @Override
    public MemberVO loginMember(MemberVO memberVO) {
        MemberVO user = memberDAO.selectLoginId(memberVO.getLoginId());

        if (user != null && passwordEncoder.matches(memberVO.getPassword(), user.getPassword())) {
            return user; // 바로 반환
        }
        throw new RuntimeException("아이디 또는 비밀번호가 틀렸습니다.");
    }
}