package lms.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {

    private int reviewId;
    private int memberId;
    private int bookId;

    @Min(1)
    @Max(5)
    private int rating;

    private String content;
    private LocalDateTime reviewRegDate;
}
