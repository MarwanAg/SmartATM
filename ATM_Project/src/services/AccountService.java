package services;

import models.Account;

public class AccountService {

    public double checkBalance(Account account){
        return account.getBalance();
    }

    public void deposit(Account account, double amount){
        account.deposit(amount);
    }

    public boolean withdraw(Account account, double amount){
      return account.withdraw(amount);
    }

}
