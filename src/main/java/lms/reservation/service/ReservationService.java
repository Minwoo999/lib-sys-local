package lms.reservation.service;

import java.util.List;

import lms.model.ReservationVO;

public interface ReservationService {

    int register(ReservationVO vo);

    List<ReservationVO> getByMemberId(int memberId);

    List<ReservationVO> getByBookId(int bookId);

    List<ReservationVO> getListByStatus(String status);

    int cancel(int reservationId);
}
