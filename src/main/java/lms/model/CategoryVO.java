package lms.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {

    private int categoryId;
    private int categoryCode;

    @NotBlank(message = "Category name is required.")
    private String categoryName;

    private String description;
}
