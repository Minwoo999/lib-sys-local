package lms.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:/index.do";
    }

    @GetMapping("/index.do")
    public String mainPage() {
        return "main/index";
    }
}