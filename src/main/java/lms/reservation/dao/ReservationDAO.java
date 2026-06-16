package lms.reservation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.ReservationVO;

@Repository("reservationDAO")
public class ReservationDAO extends EgovAbstractMapper {

    public int insertReservation(ReservationVO vo) {
        return insert("ReservationDAO.insertReservation", vo);
    }

    public List<ReservationVO> selectByMemberId(int memberId) {
        return selectList("ReservationDAO.selectByMemberId", memberId);
    }

    public List<ReservationVO> selectByBookId(int bookId) {
        return selectList("ReservationDAO.selectByBookId", bookId);
    }

    public List<ReservationVO> selectListByStatus(String status) {
        return selectList("ReservationDAO.selectListByStatus", status);
    }

    public int deleteReservation(int reservationId) {
        return delete("ReservationDAO.deleteReservation", reservationId);
    }
}
