package lms.review.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import lms.model.entity.Review;

@Repository("reviewDAO")
public class ReviewDAO extends EgovAbstractMapper {

    public int insertReview(Review vo) {
        return insert("ReviewDAO.insertReview", vo);
    }

    public List<Review> selectByBookId(int bookId) {
        return selectList("ReviewDAO.selectByBookId", bookId);
    }

    public Review selectByMemberIdAndBookId(EgovMap params) {
        return selectOne("ReviewDAO.selectByMemberIdAndBookId", params);
    }

    public List<Review> selectListByBookIdWithPage(Map<String, Object> params) {
        return selectList("ReviewDAO.selectListByBookIdWithPage", params);
    }

    public int deleteReview(int reviewId) {
        return delete("ReviewDAO.deleteReview", reviewId);
    }
}
