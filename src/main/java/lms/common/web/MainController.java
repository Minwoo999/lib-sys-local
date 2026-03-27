package lms.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index.do")
    public String mainPage() {
        return "main/index";
    }
}
