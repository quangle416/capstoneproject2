package org.perscholas.quanglecapstoneproject.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

