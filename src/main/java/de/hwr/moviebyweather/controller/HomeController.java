package de.hwr.moviebyweather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectFromHome() {
        return "redirect:/suggestion";
    }

    @GetMapping("/index.html")
    public String redirectFromIndex() {
        return "redirect:/suggestion";
    }
}
