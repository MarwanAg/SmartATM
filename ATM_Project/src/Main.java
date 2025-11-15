import controllers.AccountController;
import controllers.AuthController;
import models.Customer;
import services.TransactionService;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        AuthController auth = new AuthController();
        AccountController account = new AccountController();
        TransactionService transaction = new TransactionService();

        System.out.println("===== Welcome to SmartATM =====");

        System.out.println("Enter your Card Number: ");
        String cardNumber = input.nextLine();

        System.out.println("Enter your PIN: ");
        String pin = input.nextLine();

        Customer customer = auth.login(cardNumber, pin);

        if(customer == null){
            System.out.println("Invalid Card Number!");
            return;
        }else{
            System.out.println("Welcome "+customer.getFullName());
        }

        while(true){
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction Log");
            System.out.println("5. Exit");
            System.out.println("Choose: ");

            int choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Balance: " + account.getBalance(customer.getAccount()));
                    break;
                case 2:
                    System.out.println("Amount: ");
                    double deposit = input.nextDouble();
                    account.deposit(customer.getAccount(), deposit);
                    System.out.println("Deposited!");
                    break;
                case 3:
                    System.out.println("Amount: ");
                    double withdraw = input.nextDouble();
                    if(account.withdraw(customer.getAccount(), withdraw)){
                        System.out.println("Withdrawn!");
                    }else{
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("=== Transaction Log ===");
                    for(var t : transaction.getTransactionHistory(customer.getAccount())){
                        System.out.println(t);
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using SmartATM");
                    return; // we used "return" to exit from the "while" loop and terminate the app
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }

    }

}