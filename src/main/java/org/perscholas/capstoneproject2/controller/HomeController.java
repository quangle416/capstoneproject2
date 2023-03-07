package org.perscholas.capstoneproject2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/","index"})
    public String homePage(Model model){
        return "index";
    }
}
