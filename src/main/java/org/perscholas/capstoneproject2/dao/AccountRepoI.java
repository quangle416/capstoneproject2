package org.perscholas.capstoneproject2.dao;

import jakarta.transaction.Transactional;
import org.perscholas.capstoneproject2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(rollbackOn = Exception.class)
public interface AccountRepoI extends JpaRepository<Account, Integer> {

}
