package org.perscholas.capstoneproject2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/login")
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String signUpPage(Model model) {
        return "login";
    }
}
