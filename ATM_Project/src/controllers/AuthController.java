package controllers;

import models.Customer;
import services.AuthenticationService;

public class AuthController {

    private final AuthenticationService authenticationService = new AuthenticationService();

    public Customer login(String cardNumber, String pin){
        return authenticationService.login(cardNumber, pin);
    }

}
