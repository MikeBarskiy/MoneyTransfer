package com.revolut.transfer.exception;

import com.revolut.transfer.model.Account;

public class AccountDoesntHaveEnoughMoney extends Exception {
    public AccountDoesntHaveEnoughMoney(Account account) {
        super("Account with id: " + account.getId() + " doesn't have enough money");
    }
}