package lms.category.service;

import java.util.List;

import lms.model.CategoryVO;

public interface CategoryService {

    List<CategoryVO> getAll();

    CategoryVO getById(int categoryId);

    int register(CategoryVO vo);

    int modify(CategoryVO vo);

    int remove(int categoryId);
}
