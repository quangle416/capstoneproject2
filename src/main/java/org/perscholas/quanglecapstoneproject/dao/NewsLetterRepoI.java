package org.perscholas.quanglecapstoneproject.dao;

import org.perscholas.quanglecapstoneproject.model.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsLetterRepoI extends JpaRepository<NewsLetter, Integer> {
}
