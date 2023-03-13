package org.perscholas.capstoneproject2.dao;

import org.perscholas.capstoneproject2.model.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsLetterRepoI extends JpaRepository<NewsLetter, Integer> {

}
