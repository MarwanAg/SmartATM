package services;

import models.Account;
import models.Transaction;

import java.util.List;

public class TransactionService {

    public List<Transaction> getTransactionHistory(Account account){
        return account.getTransactionsHistory();
    }

}
