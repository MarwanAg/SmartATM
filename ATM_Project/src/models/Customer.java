package models;

public class Customer {

    private String cardNumber;
    private String fullName;
    private String pin;
    private Account account;

    public Customer(String cardNumber, String fullName, String pin, Account account){
        this.cardNumber = cardNumber;
        this.fullName = fullName;
        this.pin = pin;
        this.account = account;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }
}
