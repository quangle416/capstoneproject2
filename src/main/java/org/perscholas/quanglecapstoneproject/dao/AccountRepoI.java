package org.perscholas.quanglecapstoneproject.dao;

import org.perscholas.quanglecapstoneproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepoI extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmailAllIgnoreCase(String email);


}
