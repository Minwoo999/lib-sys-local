package lms.model;

import lms.model.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class BookUserDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookSearchRequest {
        private String title;
        private String author;
        private int categoryCode;

        @Builder.Default
        private int pageIndex = 1;
        @Builder.Default
        private int recordCount = 10;
        @Builder.Default
        private int firstIndex = 0;

        public void calculatePage() {
            this.firstIndex = (this.pageIndex - 1) * this.recordCount;
        }

        public Book toEntity() {
            return Book.builder()
                    .title(this.title)
                    .author(this.author)
                    .categoryCode(this.categoryCode)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookDetailUserResponse {
        private int bookId;
        private String title;
        private String author;
        private String publisher;
        private String bookDesc;
        private int categoryCode;
        private int currentCnt;

        public static BookDetailUserResponse toDTO(Book entity) {
            return BookDetailUserResponse.builder()
                    .bookId(entity.getBookId())
                    .title(entity.getTitle())
                    .author(entity.getAuthor())
                    .publisher(entity.getPublisher())
                    .bookDesc(entity.getBookDesc())
                    .categoryCode(entity.getCategoryCode())
                    .currentCnt(entity.getCurrentCnt())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class BookListResponse {
        private int bookId;
        private String title;
        private String author;
        private String publisher;
        private String bookDesc;
        private int categoryCode;

        public static BookListResponse toDTO(Book entity) {
            return BookListResponse.builder()
                    .bookId(entity.getBookId())
                    .title(entity.getTitle())
                    .author(entity.getAuthor())
                    .publisher(entity.getPublisher())
                    .bookDesc(entity.getBookDesc())
                    .categoryCode(entity.getCategoryCode())
                    .build();
        }
    }
}