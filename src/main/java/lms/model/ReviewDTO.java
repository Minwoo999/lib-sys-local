package lms.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class ReviewDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ReviewWriteRequest {
        private int memberId;
        private int bookId;
        private int rating;
        private String content;

        public lms.model.ReviewVO toVO() {
            return new ReviewVO(0, memberId, bookId, rating, content, null);
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ReviewListResponse {
        private int reviewId;
        private int memberId;
        private int bookId;
        private int rating;
        private String content;
        private LocalDateTime reviewRegDate;

        public static ReviewListResponse toVO(lms.model.ReviewVO vo) {
            return ReviewListResponse.builder()
                    .reviewId(vo.getReviewId())
                    .memberId(vo.getMemberId())
                    .bookId(vo.getBookId())
                    .rating(vo.getRating())
                    .content(vo.getContent())
                    .reviewRegDate(vo.getReviewRegDate())
                    .build();
        }
    }
}
