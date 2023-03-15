package org.perscholas.quanglecapstoneproject.service;

import jakarta.transaction.Transactional;
import org.perscholas.quanglecapstoneproject.dao.AccountRepoI;
import org.perscholas.quanglecapstoneproject.exception.MyException;
import org.perscholas.quanglecapstoneproject.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class AccountService {
    AccountRepoI accountRepoI;
    @Autowired
    public AccountService(AccountRepoI accountRepoI) {
        this.accountRepoI = accountRepoI;
    }

    public Account addAccount(Account account) {
        return accountRepoI.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepoI.findAll();
    }

    public Account getAccountId(Integer id) throws MyException {
        if (accountRepoI.findById(id).isPresent()) {
            return accountRepoI.findById(id).get();
        } else {
            throw new MyException("No Account found with " +id);
        }

    }

    public Account updateAccount(Account account) throws MyException {
        if (accountRepoI.findById(account.getId()).isPresent()) {
            return accountRepoI.save(account);
        } else {
            throw new MyException("Could not update Account");
        }

    }

    public void deleteAnAccount(Integer id) {
        accountRepoI.deleteById(id);
    }
}
