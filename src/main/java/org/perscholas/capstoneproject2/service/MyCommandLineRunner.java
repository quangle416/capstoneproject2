package org.perscholas.capstoneproject2.service;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.*;
import org.perscholas.capstoneproject2.model.Account;
import org.perscholas.capstoneproject2.model.BlogPost;
import org.perscholas.capstoneproject2.model.NewsLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {


    AccountRepoI accountRepoI;
    BlogPostRepoI blogPostRepoI;
    ImageRepoI imageRepoI;
    AccountService accountService;
    BlogPostService blogPostService;
    ImageService imageService;
    NewsLetterRepoI newsLetterRepoI;

    @Autowired
    public MyCommandLineRunner(AccountRepoI accountRepoI, BlogPostRepoI blogPostRepoI, ImageRepoI imageRepoI, AccountService accountService, BlogPostService blogPostService, ImageService imageService,
                               NewsLetterRepoI newsLetterRepoI) {
        this.accountRepoI = accountRepoI;
        this.blogPostRepoI = blogPostRepoI;
        this.imageRepoI = imageRepoI;
        this.accountService = accountService;
        this.blogPostService = blogPostService;
        this.imageService = imageService;
        this.newsLetterRepoI = newsLetterRepoI;
    }

    //@PostContruct makes method execute immediately after injection
    @PostConstruct
    void commandStarted() {
        log.warn("--------------- My CommandLineRunner is now starting ---------------");

    }

    @Override
    public void run(String... args) throws Exception {

        //creating dummy data to persist to database

        Account account1 = new Account("Quang", "Le", "quangle@gmail.com", "password1");
        Account account2 = new Account("Mary", "Le", "maryle@gmail.com", "password2");
        Account account3 = new Account("Lillian", "Le", "Lillianle@gmail.com", "password3");

        accountRepoI.saveAndFlush(account1);
        accountRepoI.saveAndFlush(account2);
        accountRepoI.saveAndFlush(account3);

//        BlogPost post1 = new BlogPost("Hello", "Lets talk about my interest", LocalDateTime.now(), account1);
//        BlogPost post2 = new BlogPost("HelloWorld", "Lets talk about you", LocalDateTime.now(), account2);
//        BlogPost post3 = new BlogPost("WhatsUp", "Baby on the move!", LocalDateTime.now(), account3);
//        BlogPost post4 = new BlogPost("Up", "Higher and Higher we Go!", LocalDateTime.now());
//
//        blogPostService.
//        blogPostRepoI.saveAndFlush(post1);
//        blogPostRepoI.saveAndFlush(post2);
//        blogPostRepoI.saveAndFlush(post3);
//        blogPostRepoI.saveAndFlush(post4);
//
//        post1.setAccount(account1);
//        post2.setAccount(account2);
//        post3.setAccount(account3);
//
//        blogPostRepoI.saveAndFlush(post1);
//        blogPostRepoI.saveAndFlush(post2);
//        blogPostRepoI.saveAndFlush(post3);

        NewsLetter email1 = new NewsLetter("le", "lequang@gmail");
        NewsLetter email2 = new NewsLetter("mary", "lemary@gmail");
        NewsLetter email3 = new NewsLetter("lilly","lillian@gmail");

        newsLetterRepoI.saveAndFlush(email1);
        newsLetterRepoI.saveAndFlush(email2);
        newsLetterRepoI.saveAndFlush(email3);

    }

}