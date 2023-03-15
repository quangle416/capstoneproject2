package org.perscholas.quanglecapstoneproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.NewsLetter;
import org.perscholas.quanglecapstoneproject.service.NewsLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/newsletter")
@Slf4j
public class NewsLetterController {

    NewsLetterService newsLetterService;

    @Autowired
    public NewsLetterController(NewsLetterService newsLetterService) {
        this.newsLetterService = newsLetterService;
    }


    @GetMapping("/newsletter")
    public String newsLetterPage(Model model) {
        model.addAttribute("newsletter", new NewsLetter());
        log.warn("NewsLetter email form method");
        return "newsletter";
    }

    @PostMapping("/newsletteradded")
    public String signUpNewsLetter(@ModelAttribute("newsletter") NewsLetter newsLetter, RedirectAttributes redirectAttributes) {
        log.warn("new email processed");
        newsLetterService.addNewsLetter(newsLetter);
        redirectAttributes.addFlashAttribute("message", "Thank you for joining the Email List!");
        return "redirect:/newsletterall";
    }

    @GetMapping("/newsletterall")
    public String allNewsList(Model model) {
        List<NewsLetter> allList = newsLetterService.getAllNewsLetters();
        model.addAttribute("allList", allList);
        log.warn("newsletter listing for email and name");
        return "newsletterall";
    }

    @GetMapping("/newsletter/edit/{id}")
    public String getNewsLetter(@PathVariable Integer id, Model model) throws MyException {
        model.addAttribute("newsletter", newsLetterService.getNewsLetterId(id));
       log.warn("editing a Newsletter account");
        return "newsletteredit";
    }
    @PostMapping("/newsletter/{id}")
    public String updatedNewsLetter(@PathVariable Integer id, @ModelAttribute("newsletter") NewsLetter newsLetter, Model model,RedirectAttributes redirectAttributes) throws MyException {

        NewsLetter oldNewsAccount = newsLetterService.getNewsLetterId(id);
        oldNewsAccount.setId(id);
        oldNewsAccount.setAcctName(newsLetter.getAcctName());
        oldNewsAccount.setEmail(newsLetter.getEmail());

        newsLetterService.updateNewsLetter(oldNewsAccount);
        log.warn("updated newsletter account");
        redirectAttributes.addFlashAttribute("message", "Account is updated");

        return "redirect:/newsletterall";
    }

    @GetMapping("/newsletter/{id}")
    public String deleteNews(@PathVariable Integer id) {
    newsLetterService.deleteNewsLetter(id);
    return "redirect:/newsletterall";
    }
}
