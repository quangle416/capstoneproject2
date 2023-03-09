package org.perscholas.capstoneproject2.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.BlogPostRepoI;
import org.perscholas.capstoneproject2.model.Account;
import org.perscholas.capstoneproject2.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class BlogPostService {
   private BlogPostRepoI blogPostRepoI;
    @Autowired
    public BlogPostService(BlogPostRepoI blogPostRepoI) {
        this.blogPostRepoI = blogPostRepoI;
    }

public List<BlogPost> findAll() {
        return blogPostRepoI.findAll();
}

public void save(BlogPost blogPost, Integer account) {
        if(blogPost.getAccount() == null) {
            Account accountId = new Account();
            accountId.setId(account);
            blogPost.setAccount(accountId);

        }

        blogPostRepoI.save(blogPost);
}

}
