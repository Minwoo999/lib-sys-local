package lms.member.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lms.member.dao.MemberDAO;
import lms.member.service.MemberService;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PasswordEncoder passwordEncoder;

    // 1. 회원가입
    @Override
    public int join(MemberVO vo) {
        if (memberDAO.countLoginId(vo.getLoginId()) > 0) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return memberDAO.insertMember(vo);
    }

    // 2. 로그인
    @Override
    public MemberVO login(MemberVO vo) {
        MemberVO user = memberDAO.selectLoginId(vo.getLoginId());
        if (user != null && passwordEncoder.matches(vo.getPassword(), user.getPassword())) {
            return user;
        }
        throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    // 3. 내 정보 수정
    
    @Override
    public int modifyMyInfo(MemberVO vo) {
        return memberDAO.updateMember(vo);
    }

    // 4. 비밀번호 변경
    @Override
    public int modifyPassword(MemberVO vo) {
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return memberDAO.updatePassword(vo);
    }

    // 5. 탈퇴
    @Override
    public int withdraw(int memberId) {
        MemberVO vo = new MemberVO();
        vo.setMemberId(memberId);
        vo.setMemberStatus(0);

        return memberDAO.updateStatus(vo);
    }

    // 6. 상세 조회
    @Override
    public MemberVO getMemberDetail(int memberId) {
        return memberDAO.selectId(memberId);
    }

    // 7. 소셜 로그인
    @Override
    public MemberVO loginBySns(MemberVO snsUser) throws Exception {
        MemberVO snsMember = memberDAO.selectBySns(snsUser);

        if (snsMember != null) {
            return snsMember;
        }

        int emailCount = memberDAO.countEmail(snsUser.getEmail());

        if (emailCount > 0) {
            throw new Exception("이미 존재합니다. (자동 연동 구현하기 / 이메일 받기)");
        }

        snsUser.setLoginId(snsUser.getEmail());

        String tempPassword = java.util.UUID.randomUUID().toString();
        snsUser.setPassword(passwordEncoder.encode(tempPassword));

        memberDAO.insertMember(snsUser);

        return memberDAO.selectBySns(snsUser);
    }
}