package org.perscholas.capstoneproject2.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.perscholas.capstoneproject2.dao.AccountRepoI;
import org.perscholas.capstoneproject2.dao.AuthGroupRepoI;
import org.perscholas.capstoneproject2.dao.BlogPostRepoI;
import org.perscholas.capstoneproject2.dao.ImageRepoI;
import org.perscholas.capstoneproject2.model.Account;
import org.perscholas.capstoneproject2.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {


    AccountRepoI accountRepoI;
    BlogPostRepoI blogPostRepoI;
    ImageRepoI imageRepoI;
    AccountService accountService;
    BlogPostService blogPostService;
    ImageService imageService;

    @Autowired
    public MyCommandLineRunner(AccountRepoI accountRepoI, BlogPostRepoI blogPostRepoI, ImageRepoI imageRepoI, AccountService accountService, BlogPostService blogPostService, ImageService imageService) {
        this.accountRepoI = accountRepoI;
        this.blogPostRepoI = blogPostRepoI;
        this.imageRepoI = imageRepoI;
        this.accountService = accountService;
        this.blogPostService = blogPostService;
        this.imageService = imageService;
    }

    @Override
    public void run(String... args) throws Exception {

        Account publisher1 = new Account("Quang", "Le", "quangle@gmail.com", "password1");
        Account publisher2 = new Account("Mary", "Le", "maryle@gmail.com", "password2");
        Account publisher3 = new Account("Lillian", "Le", "Lillianle@gmail.com", "password3");

        accountRepoI.saveAndFlush(publisher1);
        accountRepoI.saveAndFlush(publisher2);
        accountRepoI.saveAndFlush(publisher3);

        BlogPost post1 = new BlogPost("Hello", "Lets talk about my interest", LocalDateTime.now());
        BlogPost post2 = new BlogPost("HelloWorld", "Lets talk about you", LocalDateTime.now());
        BlogPost post3 = new BlogPost("WhatsUp", "Baby on the move!", LocalDateTime.now());

        blogPostRepoI.saveAndFlush(post1);
        blogPostRepoI.saveAndFlush(post2);
        blogPostRepoI.saveAndFlush(post3);

    }

}