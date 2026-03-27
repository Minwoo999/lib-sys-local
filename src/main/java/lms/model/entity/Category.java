package lms.model.entity;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    int categoryId;
    int categoryCode;
    @NotBlank(message = "Category name is required.")
    String categoryName;
    String description;
}