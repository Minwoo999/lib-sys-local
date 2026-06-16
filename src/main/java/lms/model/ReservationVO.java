package lms.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationVO {

    private int reservationId;
    private int memberId;
    private int bookId;
    private LocalDateTime reservationDate;
    private String status;
}
