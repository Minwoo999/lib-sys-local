package lms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class CategoryDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class CategoryRegisterRequest {
        private int categoryCode;
        private String categoryName;
        private String description;

        public lms.model.CategoryVO toVO() {
            return new CategoryVO(0, categoryCode, categoryName, description);
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class CategoryModifyRequest {
        private int categoryId;
        private String categoryName;
        private String description;

        public lms.model.CategoryVO toVO() {
            return new CategoryVO(categoryId, 0, categoryName, description);
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class CategoryListResponse {
        private int categoryId;
        private int categoryCode;
        private String categoryName;
        private String description;

        public static CategoryListResponse toVO(lms.model.CategoryVO vo) {
            return CategoryListResponse.builder()
                    .categoryId(vo.getCategoryId())
                    .categoryCode(vo.getCategoryCode())
                    .categoryName(vo.getCategoryName())
                    .description(vo.getDescription())
                    .build();
        }
    }
}
