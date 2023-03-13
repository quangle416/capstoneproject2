package org.perscholas.capstoneproject2.dao;
import org.perscholas.capstoneproject2.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthGroupRepoI extends JpaRepository<AuthGroup,Integer> {
}
