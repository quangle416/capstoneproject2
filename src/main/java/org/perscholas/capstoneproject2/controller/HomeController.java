package org.perscholas.capstoneproject2.controller;

import org.perscholas.capstoneproject2.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "index",})
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @GetMapping("/post")
    public String postPage(Model model) {
        return "post";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        return "signup";
    }


    @GetMapping("/newsletter")
    public String contactPage(Model model) {
        return "newsletter";
    }
}
