package org.perscholas.quanglecapstoneproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.BlogPost;
import org.perscholas.quanglecapstoneproject.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/post")
@Slf4j
public class BlogPostController {

    BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/post")
    public String postPage(Model model) {
        List<BlogPost> allBlogPost = blogPostService.getAllBlogPost();
        model.addAttribute("allBlogPost", allBlogPost);
        log.warn("list of all BlogPost");
        return "post";
    }
    @GetMapping("/postadd")
    public String addPost(Model model) {
        return "postadd";
    }


    @GetMapping("/post/{id}")
    public String getBlogPost(@PathVariable Integer id, Model model) throws MyException {
        Optional<BlogPost> singleBlogPost = blogPostService.getBlogPostId(id);
        if (singleBlogPost.isPresent()) {
            model.addAttribute("blogPost", singleBlogPost);
            return "postsingle";
        } else {
            throw new MyException("Could not find blog posting");
        }

    }

}
