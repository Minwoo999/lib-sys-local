package lms.category.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/category/admin")
@RequiredArgsConstructor
public class CategoryController {

    private final lms.category.service.CategoryService categoryService;

    /** 카테고리 목록 — book admin category select로 리다이렉트 */
    @GetMapping("")
    public String list(Model model) {
        return "redirect:/book/admin/category/select";
    }

    /** 등록 폼 */
    @GetMapping("/register")
    public String registerForm() {
        return "category/register";
    }

    /** 등록 처리 */
    @PostMapping("/register")
    public String registerSubmit(@Validated lms.model.CategoryVO vo, RedirectAttributes rt) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 검증 실패 시 에러 메시지 표시 등 결정 필요
        return "redirect:/book/admin/category/select";
    }

    /** 수정 폼 */
    @GetMapping("/modify")
    public String modifyForm(@RequestParam int categoryId, Model model) {
        // TODO: 카테고리 조회 후 모델에 담기
        return "category/modify";
    }

    /** 수정 처리 */
    @PostMapping("/modify")
    public String modifySubmit(@Validated lms.model.CategoryVO vo, RedirectAttributes rt) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 검증 실패 시 에러 메시지 표시 등 결정 필요
        return "redirect:/book/admin/category/select";
    }

    /** 삭제 */
    @PostMapping("/remove")
    public String remove(@RequestParam int categoryId, RedirectAttributes rt) {
        // TODO: 비즈니스 로직 직접 구현 필요 - 하위 카테고리/연관 데이터 체크 등 결정 필요
        categoryService.remove(categoryId);
        return "redirect:/book/admin/category/select";
    }

}
