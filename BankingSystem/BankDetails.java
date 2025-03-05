package BankingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BankDetails {

    private String accountNumber;       // Account Number of Customer
    private String name;                // Name of Customer
    private String accountType;         //Account Type (Savings,Current)
    private long balance;               // Account Balance
    private ArrayList<DepositHistory> depositHistory = new ArrayList<>();
    private ArrayList<WithdrawHistory> withdrawHistory = new ArrayList<>();

    //Classes And Objects
    Scanner sc = new Scanner(System.in);

    BankDetails(){
        //Default Constructor
    }

    BankDetails(String accountNumber, String name, String accountType, long balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        
        do {
            this.balance = balance;
            if (balance<5000) {
                System.out.println("Minimum deposite Amount is 5000");
            }
        } while (balance<5000);
    }

    // This method is for display the details of the accounts
    protected void displayAccount() {
        System.out.println("Name of the account holder is:  " + this.name);
        System.out.println("Account no is:  " + this.accountNumber);
        System.out.println("Account type is:  " + this.accountType);
        System.out.println("Initial balance in the account is:  " + this.balance);
        sc.nextLine();
        System.out.println("Press Enter To Continue...");
        sc.nextLine();
    }
    
    // This method is for deposit money
    protected void deposit() {
        long amount;
        System.out.print("Enter the amount to be deposited ");
        amount = sc.nextLong();
        balance = balance + amount;

        DepositHistory dh = new DepositHistory(amount);
        depositHistory.add(dh);
    }

    // This method is for withdraw money
    protected void withdraw() {
        long amount;
        System.out.println("Enter the amount to be withdrawn ");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Updated balance is " + balance);
            WithdrawHistory wh = new WithdrawHistory(amount);
            withdrawHistory.add(wh);
        } else {
            System.out.println("Your balance is less than the " + amount + "\n" + "Transaction failed");
        }
    }

    protected void search(String accountNumber , int count , BankDetails[] users) {

        boolean flag = false;
        
        for (int i = 0; i < count; i++) {
            if (accountNumber.equals(users[i].accountNumber)) {
                users[i].displayAccount();
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Account Not Found!");
        }
    }

    protected void transaction(String accountNumber , int count , BankDetails[] users ,  String transactionType) {

        boolean flag = false;
        
        for (int i = 0; i < count; i++) {
            if (accountNumber.equals(users[i].accountNumber)) {
               
                if (transactionType.equals("deposit")) {
                    users[i].deposit();
                }
                if (transactionType.equals("withdraw")) {
                    users[i].withdraw();
                }
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Account Not Found!");
        }
    }   
    
    
    protected void displayDepositHistory() {
        System.out.println("Deposit History:");
        for (DepositHistory dh : depositHistory) {
            System.out.println(dh);
        }
    }

    protected void displayWithdrawHistory() {
        System.out.println("Withdraw History:");
        for (WithdrawHistory wh : withdrawHistory) {
            System.out.println(wh);
        }
    }
}
