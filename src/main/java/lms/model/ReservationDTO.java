package lms.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class ReservationDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ReservationRegisterRequest {
        private int memberId;
        private int bookId;

        public lms.model.ReservationVO toVO() {
            return new ReservationVO(0, memberId, bookId, null, "STANDING_BY");
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ReservationListResponse {
        private int reservationId;
        private int memberId;
        private int bookId;
        private String status;
        private LocalDateTime reservationDate;

        public static ReservationListResponse toVO(lms.model.ReservationVO vo) {
            return ReservationListResponse.builder()
                    .reservationId(vo.getReservationId())
                    .memberId(vo.getMemberId())
                    .bookId(vo.getBookId())
                    .status(vo.getStatus())
                    .reservationDate(vo.getReservationDate())
                    .build();
        }
    }
}
