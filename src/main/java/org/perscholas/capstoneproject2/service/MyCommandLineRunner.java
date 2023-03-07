package org.perscholas.capstoneproject2.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.perscholas.capstoneproject2.dao.BlogPostRepoI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {

    BlogPostRepoI postRepoI;

    @Override
    public void run(String... args) throws Exception {

    }
}
