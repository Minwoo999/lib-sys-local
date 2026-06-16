package lms.category.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lms.category.dao.CategoryDAO;
import lms.category.service.CategoryService;
import lms.model.CategoryVO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl extends EgovAbstractServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Override
    public List<CategoryVO> getAll() {
        return categoryDAO.selectAllCategories();
    }

    @Override
    public CategoryVO getById(int categoryId) {
        return categoryDAO.selectById(categoryId);
    }

    @Override
    @Transactional
    public int register(CategoryVO vo) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 카테고리 코드 중복 체크, 순서 고려 등 결정 필요
        return categoryDAO.insertCategory(vo);
    }

    @Override
    @Transactional
    public int modify(CategoryVO vo) {
        return categoryDAO.updateCategory(vo);
    }

    @Override
    @Transactional
    public int remove(int categoryId) {
        return categoryDAO.deleteCategory(categoryId);
    }
}
