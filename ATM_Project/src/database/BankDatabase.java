package database;

import models.Account;
import models.Customer;

//HashMap libraries
import java.util.HashMap;
import java.util.Map;

public class BankDatabase {

    private static final Map<String, Customer> customers = new HashMap<>();

    static{
        //Customer Data
        Account account = new Account("123123456", 2500);
        Customer customer = new Customer("1111","Marwan AbuGhazaleh", "1234", account);
        customers.put(customer.getCardNumber(), customer);
    }

    public static Customer getCustomer(String cardNumber){
        return customers.get(cardNumber);
    }

}
