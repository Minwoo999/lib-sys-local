package lms.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoanVO {
    int loanId;
    int memberId;
    int bookId;
    LocalDateTime loanDate;
    LocalDateTime dueDate;
    LocalDateTime returnDate;
    String status;

    MemberVO member;
}
