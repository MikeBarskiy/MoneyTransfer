package com.revolut.transfer.service.impl;

import com.google.inject.Inject;
import com.revolut.transfer.dao.AccountDao;
import com.revolut.transfer.model.Account;
import com.revolut.transfer.service.AccountService;

import java.sql.SQLException;
import java.util.Collection;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    @Inject
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Collection<Account> getAccounts() throws SQLException {
        return accountDao.queryForAll();
    }

    @Override
    public Account getAccount(long accountId) throws SQLException {
        return accountDao.queryForId(accountId);
    }

    @Override
    public void addAccounts(Collection<Account> accounts) throws SQLException {
        accountDao.create(accounts);
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        accountDao.create(account);
    }

    @Override
    public void updateAccounts(Collection<Account> accounts) throws SQLException {
        for (Account account : accounts)
            updateAccount(account);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        accountDao.update(account);
    }

    @Override
    public void deleteAccount(Account account) throws SQLException {
        accountDao.delete(account);
    }

    @Override
    public void deleteAccount(long id) throws SQLException {
        accountDao.deleteById(id);
    }
}
