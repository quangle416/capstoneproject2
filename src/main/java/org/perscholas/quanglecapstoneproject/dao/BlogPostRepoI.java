package org.perscholas.quanglecapstoneproject.dao;

import org.perscholas.quanglecapstoneproject.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepoI extends JpaRepository<BlogPost, Integer> {


}
