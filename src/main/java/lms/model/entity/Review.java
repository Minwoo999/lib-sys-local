package lms.model.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    int reviewId;
    int memberId;
    int bookId;
    int rating;
    @NotBlank(message = "Content cannot be empty.")
    String content;
    LocalDateTime reviewRegDate;
}
