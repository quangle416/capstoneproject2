package org.perscholas.capstoneproject2.dao;

import jakarta.transaction.Transactional;
import org.perscholas.capstoneproject2.model.BlogPost;
import org.perscholas.capstoneproject2.service.BlogPostService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogPostRepoI extends JpaRepository<BlogPost, Integer> {


}
