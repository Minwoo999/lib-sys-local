package lms.book.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lms.book.service.BookUserService;
import lms.book.service.BookUserDTO.BookDetailUserResponse;
import lms.book.service.BookUserDTO.BookSearchRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor

public class BookUserController {
    private final BookUserService userService;

    // 1. 상세 조회
    @GetMapping("/detail.do")
    public String detail(@RequestParam("Id") int bookId, Model model) {
        BookDetailUserResponse detail = userService.findDetail(bookId);
        model.addAttribute("detail", detail);
        return "book/detail";
    }

    // 2. 도서 목록
    @GetMapping("/list.do")
    public String list(BookSearchRequest searchRequest, Model model) {
        Map<String, Object> resultMap = userService.findList(searchRequest);

        model.addAttribute("resultList", resultMap.get("resultList"));
        model.addAttribute("totlaCount", resultMap.get("totlaCount"));

        return "book/list";
    }
}
