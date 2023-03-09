package org.perscholas.capstoneproject2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String name;
    @NonNull
    String url;

    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                        CascadeType.DETACH},
                        orphanRemoval = true,
                        fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id && name.equals(image.name) && url.equals(image.url) && Objects.equals(account, image.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, account);
    }
}
