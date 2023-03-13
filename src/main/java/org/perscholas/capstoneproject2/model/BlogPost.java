package org.perscholas.capstoneproject2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    String title;
    @NonNull
    @Column (columnDefinition = "TEXT")
    String content;
    @NonNull
    LocalDateTime createdDate;

    public BlogPost(@NonNull String title, @NonNull String content, @NonNull LocalDateTime createdDate, Account account) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.account = account;
    }

    public BlogPost(@NonNull String title, @NonNull String content, @NonNull LocalDateTime createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.PERSIST,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.DETACH},
                            fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @NonNull
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return title.equals(blogPost.title) && content.equals(blogPost.content) && createdDate.equals(blogPost.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, createdDate);
    }
}
