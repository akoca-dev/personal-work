package com.akoca.dev.springbootthymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("theDate", Instant.now());
        return "main-page";
    }
}
