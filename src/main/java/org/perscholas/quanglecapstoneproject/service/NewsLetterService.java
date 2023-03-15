package org.perscholas.quanglecapstoneproject.service;

import jakarta.transaction.Transactional;
import org.perscholas.quanglecapstoneproject.dao.NewsLetterRepoI;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.NewsLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class NewsLetterService {

    NewsLetterRepoI newsLetterRepoI;

    @Autowired
    public NewsLetterService(NewsLetterRepoI newsLetterRepoI) {
        this.newsLetterRepoI = newsLetterRepoI;
    }

    public List<NewsLetter> getAllNewsLetters() {
        return newsLetterRepoI.findAll();
    }

    public NewsLetter addNewsLetter(NewsLetter newsLetter) {
        return newsLetterRepoI.save(newsLetter);
    }
    public NewsLetter getNewsLetterId(Integer id) throws MyException {
        if (newsLetterRepoI.findById(id).isPresent()) {
            return newsLetterRepoI.findById(id).get();

        } else {
            throw new MyException("No users found with " + id);
        }

    }

    public NewsLetter updateNewsLetter(NewsLetter newsLetter) throws MyException {
        if (newsLetterRepoI.findById(newsLetter.getId()).isPresent()) {
            return newsLetterRepoI.save(newsLetter);

        } else {
            throw new MyException("Could not update NewsLetter information");
        }
    }

    public void deleteNewsLetter(Integer id) {
        newsLetterRepoI.deleteById(id);
    }
}

