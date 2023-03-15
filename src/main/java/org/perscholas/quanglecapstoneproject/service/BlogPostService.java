package org.perscholas.quanglecapstoneproject.service;

import jakarta.transaction.Transactional;
import org.perscholas.quanglecapstoneproject.dao.BlogPostRepoI;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class BlogPostService {
   BlogPostRepoI blogPostRepoI;
    @Autowired
    public BlogPostService(BlogPostRepoI blogPostRepoI) {
        this.blogPostRepoI = blogPostRepoI;
    }

    public BlogPost addBlogPost(BlogPost blogPost) {
        if (blogPost.getId() == null) {
            blogPost.setCreatedDate(LocalDateTime.now());
        }
        return blogPostRepoI.save(blogPost);
    }

    public List<BlogPost> getAllBlogPost() {
        return blogPostRepoI.findAll();
    }

    public Optional<BlogPost> getBlogPostId(Integer id) {
        return blogPostRepoI.findById(id);
    }

    public BlogPost updateBlogPost(BlogPost blogPost) throws MyException {
        if (blogPostRepoI.findById(blogPost.getId()).isPresent()) {
            return blogPostRepoI.save(blogPost);
        } else {
            throw new MyException("Could not update Account");
        }
    }

    public void deleteABlogPost(Integer id) {
        blogPostRepoI.deleteById(id);
}

}
