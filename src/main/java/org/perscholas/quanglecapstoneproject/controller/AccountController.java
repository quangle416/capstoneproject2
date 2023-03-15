package org.perscholas.quanglecapstoneproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.Account;
import org.perscholas.quanglecapstoneproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/signup")
@Slf4j
public class AccountController {

    AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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
        accountService.addAccount(acct);
        return "redirect:/login";
    }

    @GetMapping("/signupall")
    public String allAccountList(Model model){
        List<Account> allAcount = accountService.getAllAccount();
        model.addAttribute("allAccount", allAcount);
        log.warn("All accounts in database");
        return "signupall";
    }

    @GetMapping("/signup/edit/{id}")
    public String getAccount(@PathVariable Integer id, Model model) throws MyException {
        model.addAttribute("account", accountService.getAccountId(id));
        log.warn("editing an account");
        return "signupedit";
    }

    @PostMapping("/signup/{id}")
    public String updateAccountListing(@PathVariable Integer id, @ModelAttribute("account") Account account, Model model, RedirectAttributes redirectAttributes) throws MyException {

        Account oldAccount = accountService.getAccountId(id);
        oldAccount.setId(id);
        oldAccount.setFirstName(account.getFirstName());
        oldAccount.setLastName(account.getLastName());
        oldAccount.setEmail(account.getEmail());
        oldAccount.setPassword(account.getPassword());

        accountService.updateAccount(oldAccount);
        log.warn("updated an account");
        redirectAttributes.addFlashAttribute("message", "Account is updated");

        return "redirect:/signupall";
    }

    @GetMapping("/signup/{id}")
public String deleting(@PathVariable Integer id) {
        accountService.deleteAnAccount(id);
        return "redirect:/signupall";
    }
}
