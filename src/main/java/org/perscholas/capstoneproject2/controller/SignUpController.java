package org.perscholas.capstoneproject2.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.model.Account;
import org.perscholas.capstoneproject2.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/signup")
@Slf4j
public class SignUpController {

    AccountService accountService;

//    @GetMapping("/signup")
//    public String signUpPage(Model model) {
//        model.addAttribute("account", new Account());
//        return "signup";
//    }

//    @PostMapping("/signup")
//    public String signUpNewAccount(@ModelAttribute Account account) {
//        accountService.save(account);
//        return "redirect:/";
//    }
}
