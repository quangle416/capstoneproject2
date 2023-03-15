package org.perscholas.quanglecapstoneproject.service;

import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.quanglecapstoneproject.dao.*;
import org.perscholas.quanglecapstoneproject.model.Account;
import org.perscholas.quanglecapstoneproject.model.BlogPost;
import org.perscholas.quanglecapstoneproject.model.NewsLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {


    AccountRepoI accountRepoI;
    BlogPostRepoI blogPostRepoI;
    AccountService accountService;
    BlogPostService blogPostService;
    NewsLetterRepoI newsLetterRepoI;

    @Autowired
    public MyCommandLineRunner(AccountRepoI accountRepoI, BlogPostRepoI blogPostRepoI, AccountService accountService, BlogPostService blogPostService,
                               NewsLetterRepoI newsLetterRepoI) {
        this.accountRepoI = accountRepoI;
        this.blogPostRepoI = blogPostRepoI;
        this.accountService = accountService;
        this.blogPostService = blogPostService;
        this.newsLetterRepoI = newsLetterRepoI;
    }

    //@PostContruct annotation makes method execute immediately after injection
    @PostConstruct
    void commandStarted() {
        log.warn("--------------- My CommandLineRunner is now starting ---------------");

    }

    @Override
    public void run(String... args) throws Exception {

        //creating dummy data to check database connection for Account model

        Account account1 = new Account("Quang", "Le", "quangle@gmail.com", "password1");
        Account account2 = new Account("Mary", "Le", "maryle@gmail.com", "password2");
        Account account3 = new Account("Lillian", "Le", "Lillianle@gmail.com", "password3");

        accountRepoI.saveAndFlush(account1);
        accountRepoI.saveAndFlush(account2);
        accountRepoI.saveAndFlush(account3);

        //creating dummy data to check database connection for BlogPost model

        BlogPost post1 = new BlogPost("Hello", "Lets talk about your interest", LocalDateTime.now());
        BlogPost post2 = new BlogPost("HelloWorld", "What will be your first application written?", LocalDateTime.now());
        BlogPost post3 = new BlogPost("WhatsUp", "Baby on the move! Will she be running around soon?", LocalDateTime.now());
        BlogPost post4 = new BlogPost("UpUpAndAway", "Higher and higher we shall go!", LocalDateTime.now());

        blogPostRepoI.saveAndFlush(post1);
        blogPostRepoI.saveAndFlush(post2);
        blogPostRepoI.saveAndFlush(post3);
        blogPostRepoI.saveAndFlush(post4);

        post1.setAccount(account1);
        post2.setAccount(account2);
        post3.setAccount(account3);
        post4.setAccount(account3);

        blogPostRepoI.saveAndFlush(post1);
        blogPostRepoI.saveAndFlush(post2);
        blogPostRepoI.saveAndFlush(post3);
        blogPostRepoI.saveAndFlush(post4);

        //creating dummy data to check database connection for Network model
        NewsLetter email1 = new NewsLetter("le", "lequang@gmail");
        NewsLetter email2 = new NewsLetter("mary", "lemary@gmail");
        NewsLetter email3 = new NewsLetter("lilly","lillian@gmail");

        newsLetterRepoI.saveAndFlush(email1);
        newsLetterRepoI.saveAndFlush(email2);
        newsLetterRepoI.saveAndFlush(email3);

    }

}