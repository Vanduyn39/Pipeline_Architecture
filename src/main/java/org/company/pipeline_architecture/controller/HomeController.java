package org.company.pipeline_architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Chào mừng đến với Spring Boot JSP!");
        return "home"; // Điều hướng đến home.jsp
    }
}
