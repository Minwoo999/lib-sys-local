package lms.model;

import java.time.LocalDateTime;

import lms.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class BookAdminDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookDetailAdminResponse {
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

        public static BookDetailAdminResponse toDTO(Book entity) {
            return BookDetailAdminResponse.builder()
                    .bookId(entity.getBookId())
                    .title(entity.getTitle())
                    .author(entity.getAuthor())
                    .publisher(entity.getPublisher())
                    .bookDesc(entity.getBookDesc())
                    .categoryCode(entity.getCategoryCode())
                    .totalCnt(entity.getTotalCnt())
                    .currentCnt(entity.getCurrentCnt())
                    .damagedCnt(entity.getDamagedCnt())
                    .bookRegDateTime(entity.getBookRegDateTime())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookRegisterRequest {
        private int bookId;
        private String title;
        private String author;
        private String publisher;
        private String bookDesc;
        private int categoryCode;
        private int totalCnt;

        public Book toEntity() {
            return Book.builder()
                    .bookId(this.bookId)
                    .title(this.title)
                    .author(this.author)
                    .publisher(this.publisher)
                    .bookDesc(this.bookDesc)
                    .categoryCode(this.categoryCode)
                    .totalCnt(this.totalCnt)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookModifyDetailRequest {
        private int bookId;
        private String title;
        private String author;
        private String publisher;
        private String bookDesc;
        private int categoryCode;

        public Book toEntity() {
            return Book.builder()
                    .bookId(this.bookId)
                    .title(this.title)
                    .author(this.author)
                    .publisher(this.publisher)
                    .bookDesc(this.bookDesc)
                    .categoryCode(this.categoryCode)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookModifyStatusRequest {
        private int bookId;
        private int totalCnt;
        private int currentCnt;
        private int damagedCnt;

        public Book toEntity() {
            return Book.builder()
                    .bookId(this.bookId)
                    .totalCnt(this.totalCnt)
                    .currentCnt(this.currentCnt)
                    .damagedCnt(this.damagedCnt)
                    .build();
        }
    }
}
