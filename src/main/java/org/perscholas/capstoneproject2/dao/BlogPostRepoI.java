package org.perscholas.capstoneproject2.dao;

import org.perscholas.capstoneproject2.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogPostRepoI extends JpaRepository<BlogPost, Integer> {
  Optional<BlogPost> findById(Integer id);

}
