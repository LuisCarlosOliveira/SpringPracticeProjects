package  com.example.thymeleaf.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from Spring MVC thymeleaf!");
        return "hello";
    }

    @RequestMapping("/myHello")
    public String myHello(Model model) {
        model.addAttribute("message", "Hello from Luis!");
        return "myHello";
    }
}
