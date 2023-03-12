package org.perscholas.capstoneproject2.dao;

import org.perscholas.capstoneproject2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepoI extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmailAllIgnoreCase(String email);


}
