package org.perscholas.quanglecapstoneproject.controller;

import org.perscholas.quanglecapstoneproject.service.BlogPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    BlogPostService blogPostService;

    @GetMapping(value = {"/", "index",})
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }





}
