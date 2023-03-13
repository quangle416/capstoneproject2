package org.perscholas.capstoneproject2.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.NewsLetterRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class NewsLetterServices {

    NewsLetterRepoI newsLetterRepoI;

    @Autowired

    public NewsLetterServices(NewsLetterRepoI newsLetterRepoI) {
        this.newsLetterRepoI = newsLetterRepoI;
    }
}
