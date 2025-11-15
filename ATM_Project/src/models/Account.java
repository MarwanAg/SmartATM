package models;

import utils.TransactionFileManager;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;

    private List<Transaction> transactionsHistory = new ArrayList<>();

    public Account(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        addTransaction(new Transaction(TransactionType.CHECK_BALANCE, 0));
        TransactionFileManager.saveTransactionsToFile(transactionsHistory);
        return balance;
    }

    public List<Transaction> getTransactionsHistory(){
        return transactionsHistory;
    }

    public void addTransaction(Transaction transaction){
        transactionsHistory.add(transaction);
    }

    public void deposit(double amount){
        balance += amount;
        addTransaction(new Transaction(TransactionType.DEPOSIT, amount));
        TransactionFileManager.saveTransactionsToFile(transactionsHistory);
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            addTransaction(new Transaction(TransactionType.WITHDRAW, amount));
            TransactionFileManager.saveTransactionsToFile(transactionsHistory);
            return true;
        }else{
            return false;
        }
    }
}
