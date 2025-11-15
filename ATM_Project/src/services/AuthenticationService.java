package services;

import database.BankDatabase;
import models.Customer;

public class AuthenticationService {

    public Customer login(String cardNumber, String pin){
        Customer customer = BankDatabase.getCustomer(cardNumber);

        if(customer != null && customer.getPin().equals(pin)){
            return customer;
        }else{
            return null;
        }
    }

}
