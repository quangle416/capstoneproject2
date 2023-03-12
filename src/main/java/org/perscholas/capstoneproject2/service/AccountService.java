package org.perscholas.capstoneproject2.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.capstoneproject2.dao.AccountRepoI;
import org.perscholas.capstoneproject2.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class AccountService {
    AccountRepoI accountRepoI;
    @Autowired
    public AccountService(AccountRepoI accountRepoI) {
        this.accountRepoI = accountRepoI;
    }



}
