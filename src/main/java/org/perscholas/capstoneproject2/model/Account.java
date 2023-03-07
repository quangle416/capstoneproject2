package org.perscholas.capstoneproject2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
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

    @ToString.Exclude
    @OneToMany(mappedBy ="account", cascade = {CascadeType.PERSIST,
                                                CascadeType.MERGE,
                                                CascadeType.REFRESH,
                                                CascadeType.DETACH},
                                                orphanRemoval = true,
                                                fetch=FetchType.EAGER)

    private Set<BlogPost> blogPosts= new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && firstName.equals(account.firstName) && lastName.equals(account.lastName) && email.equals(account.email) && password.equals(account.password) && Objects.equals(blogPosts, account.blogPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, blogPosts);
    }
}
