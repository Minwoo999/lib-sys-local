package lms.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.MemberVO;

@Repository("adminDAO")
public class AdminDAO extends EgovAbstractMapper {

    // 회원 목록 조회 (Member_SQL.xml namespace 사용)
    public List<MemberVO> selectMemberList() {
        // Admin_SQL.xml namespace: lms.member.dao.AdminDAO (admin 패키지의 DAO가 member XML 사용)
        return selectList("selectMemberList");
    }

}
