package lms.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.admin.dao.AdminDAO;
import lms.admin.service.AdminService;
import lms.member.dao.MemberDAO;
import lms.model.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {

    private final MemberDAO memberDAO;
    private final AdminDAO adminDAO;

    // 전체 목록 조회
    @Override
    @Transactional(readOnly = true)
    public List<MemberVO> getMemberList() {
        return adminDAO.selectMemberList();
    }

    // 상태 변경
    @Override
    public int changeMemberStatus(MemberVO vo) {
        return memberDAO.updateStatus(vo);
    }

    // 정보 수정
    @Override
    public int updateMemberByAdmin(MemberVO vo) {
        return memberDAO.updateMember(vo);
    }

    // 상세 조회
    @Override
    @Transactional(readOnly = true)
    public MemberVO getMemberDetail(int memberId) {
        return memberDAO.selectId(memberId);
    }
}
