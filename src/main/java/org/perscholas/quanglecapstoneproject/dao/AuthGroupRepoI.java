package org.perscholas.quanglecapstoneproject.dao;
import org.perscholas.quanglecapstoneproject.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthGroupRepoI extends JpaRepository<AuthGroup,Integer> {
}
