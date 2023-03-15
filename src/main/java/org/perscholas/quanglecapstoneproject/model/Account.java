package org.perscholas.quanglecapstoneproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    String email;
    @NonNull
    String password;

    public Account(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, List<BlogPost> blogPosts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.blogPosts = blogPosts;
    }

    public Account(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Account(@NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull String password, List<BlogPost> blogPosts, Image image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.blogPosts = blogPosts;
        this.image = image;
    }


    @OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            orphanRemoval = true,
            fetch = FetchType.LAZY)

    private List<BlogPost> blogPosts = new ArrayList<>();

    public void addBlogPost(BlogPost blogPost){
    blogPosts.add(blogPost);
    blogPost.setAccount(this);
    }

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return firstName.equals(account.firstName) && lastName.equals(account.lastName) && email.equals(account.email) && password.equals(account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password);
    }
}
