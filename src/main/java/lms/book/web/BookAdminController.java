package lms.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lms.book.service.BookAdminService;
import lms.model.BookAdminDTO.BookDetailAdminResponse;
import lms.model.BookAdminDTO.BookModifyDetailRequest;
import lms.model.BookAdminDTO.BookRegisterRequest;
import lms.model.entity.Book;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book/admin")
@RequiredArgsConstructor
public class BookAdminController {
    
    private final BookAdminService bookAdminService;

    // 1. 도서 목록 조회
    @GetMapping("/list.do")
    public String list(Model model) {
        List<Book> books = bookAdminService.getBookList();
        model.addAttribute("books", books);
        return "book/adminList";
    }

    // 2. 도서 상세 조회
    @GetMapping("/detail.do")
    public String detail(@RequestParam("bookId") int bookId, Model model) {
        BookDetailAdminResponse detail = bookAdminService.getDetail(bookId);
        model.addAttribute("detail", detail);
        return "book/adminDetail";
    }

    // 3. 도서 등록 폼
    @GetMapping("/register.do")
    public String registerForm() {
        return "book/register";
    }

    // 4. 도서 등록 처리
    @PostMapping("/register.do")
    public String register(BookRegisterRequest request) {
        bookAdminService.registerBook(request);
        return "redirect:/book/admin/list.do";
    }

    // 5. 도서 수정 폼
    @GetMapping("/modify.do")
    public String modifyForm(@RequestParam("bookId") int bookId, Model model) {
        BookDetailAdminResponse detail = bookAdminService.getDetail(bookId);
        model.addAttribute("detail", detail);
        return "book/modify";
    }

    // 6. 도서 수정 처리
    @PostMapping("/modify.do")
    public String modify(BookModifyDetailRequest request) {
        bookAdminService.modifyDetail(request);
        return "redirect:/book/admin/detail.do?bookId=" + request.getBookId();
    }

    // 7. 도서 삭제
    @PostMapping("/remove.do")
    public String remove(@RequestParam("bookId") int bookId) {
        bookAdminService.removeBook(bookId);
        return "redirect:/book/admin/list.do";
    }
}
