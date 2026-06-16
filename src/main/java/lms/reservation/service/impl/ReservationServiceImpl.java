package lms.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lms.model.ReservationVO;
import lms.reservation.dao.ReservationDAO;
import lms.reservation.service.ReservationService;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends EgovAbstractServiceImpl implements ReservationService {

    private final ReservationDAO reservationDAO;

    @Override
    public int register(ReservationVO vo) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 같은 도서에 중복 예약 방지, 대기열 번호 부여 등 결정 필요
        return 0;
    }

    @Override
    public List<ReservationVO> getByMemberId(int memberId) {
        return reservationDAO.selectByMemberId(memberId);
    }

    @Override
    public List<ReservationVO> getByBookId(int bookId) {
        return reservationDAO.selectByBookId(bookId);
    }

    @Override
    public List<ReservationVO> getListByStatus(String status) {
        return reservationDAO.selectListByStatus(status);
    }

    @Override
    public int cancel(int reservationId) {
        return reservationDAO.deleteReservation(reservationId);
    }
}
