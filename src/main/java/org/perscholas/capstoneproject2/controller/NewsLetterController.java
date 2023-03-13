package org.perscholas.capstoneproject2.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.NewsLetterRepoI;
import org.perscholas.capstoneproject2.model.NewsLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/newsletter")
@Slf4j
public class NewsLetterController {

    NewsLetterRepoI newsLetterRepoI;

    @Autowired
    public NewsLetterController(NewsLetterRepoI newsLetterRepoI) {
        this.newsLetterRepoI = newsLetterRepoI;
    }

    //    @GetMapping("all")
//    public String allEmail(Model model) {
//        model.addAttribute("newsletters", newsLetterRepoI.findAll());
//        return "newsletter/all";
//    }
//
//    @GetMapping("add")
//    public String addEmailForm(Model model) {
//        model.addAttribute("newsletters", new NewsLetter());
//        return "newsletter/add";
//    }
//
//    @PostMapping("/add")
//    public String addToListing(@ModelAttribute("newsletter") NewsLetter newsLetter) {
//        newsLetterRepoI.save(newsLetter);
//        return "redirect: /newsletter/";
//    }
//
//    @GetMapping("/delete")
//    public String deleteEmail(@RequestParam("id") Integer id) {
//        newsLetterRepoI.deleteById(id);
//        return "redirect: /newsletter";
//    }

    @GetMapping("/newsletter")
    public String newsLetterPage(Model model){
        model.addAttribute("newsletter", new NewsLetter());
        log.warn("NewsLetter email form method");
        return "newsletter";
    }

    @PostMapping("/newslettercomplete")
    public String signUpNewAccount(@ModelAttribute("newsletter") NewsLetter newsLetter) {
        log.warn("new email processed");
        newsLetterRepoI.save(newsLetter);
        return "redirect:/index";
    }
    @GetMapping("/newsletterall")
    public String allEmailList(Model model){
        List<NewsLetter> allEmail = newsLetterRepoI.findAll();
        model.addAttribute("allEmail", allEmail);
        log.warn("newsletter listing for email");
        return "newsletterall";
    }
}
