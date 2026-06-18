package lms.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookVO {
    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private String bookDesc;
    private int categoryCode;
    private int totalCnt;
    private int currentCnt;
    private int damagedCnt;
    private LocalDateTime bookRegDateTime;

}

// @NotBlank(message = "Title must not be blank.")
// @NotBlank(message = "Author must not be blank.")