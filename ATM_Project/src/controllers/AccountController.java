package controllers;

import models.Account;
import services.AccountService;

public class AccountController {

    private final AccountService accountService = new AccountService();

    public double getBalance(Account account){
        return accountService.checkBalance(account);
    }

    public void deposit(Account account, double amount){
        accountService.deposit(account, amount);
    }

    public boolean withdraw(Account account, double amount){
        return accountService.withdraw(account, amount);
    }

}
