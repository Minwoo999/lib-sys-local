package lms.category.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import lms.model.CategoryVO;

@Repository("categoryDAO")
public class CategoryDAO extends EgovAbstractMapper {

    public List<CategoryVO> selectAllCategories() {
        return selectList("CategoryDAO.selectAllCategories");
    }

    public CategoryVO selectById(int categoryId) {
        return selectOne("CategoryDAO.selectById", categoryId);
    }

    public int insertCategory(CategoryVO vo) {
        return insert("CategoryDAO.insertCategory", vo);
    }

    public int updateCategory(CategoryVO vo) {
        return update("CategoryDAO.updateCategory", vo);
    }

    public int deleteCategory(int categoryId) {
        return delete("CategoryDAO.deleteCategory", categoryId);
    }
}
