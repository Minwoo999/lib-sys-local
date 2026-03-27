package lms.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    int reservationId;
    int memberId;
    int bookId;
    LocalDateTime reservationDate;
    String status;
}
