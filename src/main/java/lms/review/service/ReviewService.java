package lms.review.service;

import java.util.List;
import java.util.Map;

import lms.model.entity.Review;

public interface ReviewService {
    int write(Review vo);

    List<Review> getByBookId(int bookId);

    Review getByMemberIdAndBookId(int memberId, int bookId);

    List<Review> getListWithPaging(Map<String, Object> params);

    int delete(int reviewId);
}
