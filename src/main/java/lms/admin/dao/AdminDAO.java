package lms.admin.dao;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.MemberVO;

public class AdminDAO extends EgovAbstractMapper {
    
    // 회원 목록
    public List<MemberVO> selectMemberList() {
        return selectList("MemberDAO.selectMemberList");
    }

}
