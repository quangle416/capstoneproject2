package org.perscholas.capstoneproject2.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.AccountRepoI;
import org.perscholas.capstoneproject2.model.Account;
import org.perscholas.capstoneproject2.model.NewsLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/signup")
@Slf4j
public class SignUpController {

    AccountRepoI accountRepoI;
    @Autowired
    public SignUpController(AccountRepoI accountRepoI) {
        this.accountRepoI = accountRepoI;
    }

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("account", new Account());
        log.warn("signup form method");
        return "signup";
    }

    @PostMapping("/signupcomplete")
    public String signUpNewAccount(@ModelAttribute("account") Account acct) {
        log.warn("account processing, adding user input");
        accountRepoI.save(acct);
        return "redirect:/login";
    }

    @GetMapping("/signupall")
    public String allAccountList(Model model){
        List<Account> allAcount = accountRepoI.findAll();
        model.addAttribute("allAccount", allAcount);
        log.warn("All accounts in database");
        return "signupall";
    }
}
