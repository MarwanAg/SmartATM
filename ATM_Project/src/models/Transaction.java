package models;

import services.TransactionService;

import java.time.LocalDateTime;

public class Transaction {

    private TransactionType type;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(TransactionType type, double amount){
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString(){
        return "["+ dateTime +"]" + type + " - " + amount;
    }
}
