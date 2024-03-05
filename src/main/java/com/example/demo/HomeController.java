package com.example.demo;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/")
    public String registration(Model model) {
        LocalTime now = LocalTime.now();
        if (now.isBefore(LocalTime.of(12, 0))) {
            model.addAttribute("greeting", "Good morning,");
        } else {
            model.addAttribute("greeting", "Good afternoon,");
        }
        return "index";
    }
}