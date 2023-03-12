package org.perscholas.capstoneproject2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    String acctName;
    @NonNull
    String email;

    public NewsLetter(@NonNull String acctName, @NonNull String email) {
        this.acctName = acctName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsLetter that = (NewsLetter) o;
        return acctName.equals(that.acctName) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctName, email);
    }
}

