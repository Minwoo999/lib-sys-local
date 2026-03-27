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
public class Loan {
    int loanId;
    int memberId;
    int bookId;
    LocalDateTime loanDate;
    LocalDateTime dueDate;
    LocalDateTime returnDate;
    String status;
}