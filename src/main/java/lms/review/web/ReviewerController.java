package lms.review.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lms.model.entity.Review;
import lms.review.service.ReviewService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewerController {

    private final ReviewService reviewService;

    // 도서별 리뷰 목록 조회
    @GetMapping("/list.do")
    public String list(@RequestParam("bookId") int bookId, Model model) {
        List<Review> reviews = reviewService.getByBookId(bookId);
        model.addAttribute("reviews", reviews);
        return "review/list";
    }

    // 리뷰 작성 폼
    @GetMapping("/write.do")
    public String writeForm(@RequestParam("bookId") int bookId, Model model) {
        model.addAttribute("bookId", bookId);
        return "review/write";
    }

    // 리뷰 등록 처리
    @PostMapping("/write.do")
    public String write(Review vo) {
        reviewService.write(vo);
        return "redirect:/review/list.do?bookId=" + vo.getBookId();
    }

    // 리뷰 삭제
    @PostMapping("/delete.do")
    public String delete(@RequestParam("reviewId") int reviewId,
                         @RequestParam("bookId") int bookId) {
        reviewService.delete(reviewId);
        return "redirect:/review/list.do?bookId=" + bookId;
    }
}
