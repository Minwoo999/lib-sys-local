package lms.review.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import lms.model.entity.Review;
import lms.review.dao.ReviewDAO;
import lms.review.service.ReviewService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDAO reviewDAO;

    @Override
    public int write(Review vo) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 해당 도서 대출 경험 있는 회원인지 검증, 중복 작성 방지 등 결정 필요
        return 0;
    }

    @Override
    public List<Review> getByBookId(int bookId) {
        return reviewDAO.selectByBookId(bookId);
    }

    @Override
    public Review getByMemberIdAndBookId(int memberId, int bookId) {
        EgovMap params = new EgovMap();
        params.put("memberId", memberId);
        params.put("bookId", bookId);
        return reviewDAO.selectByMemberIdAndBookId(params);
    }

    @Override
    public List<Review> getListWithPaging(Map<String, Object> params) {
        return reviewDAO.selectListByBookIdWithPage(params);
    }

    @Override
    public int delete(int reviewId) {
        return reviewDAO.deleteReview(reviewId);
    }
}
