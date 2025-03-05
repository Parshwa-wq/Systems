package BankingSystem;

import java.util.*;

class BankingApp {
    public static void main(String[] args) {

        // Variables
        int count = 0;

        // Classes and objects
        Scanner sc = new Scanner(System.in);
        BankDetails users[] = new BankDetails[100]; // array of users
        BankDetails tasks = new BankDetails(); // to perform tasks like deposite and withdraw

        int choice;
        do {
            System.out.println("\n-------BANKING SYSTEM APPLICATION-------");
            System.out.println(
                    "1.Creat A Account\n2.Display all account deatils\n3.Search acc by Account type\n4.Deposit the amount\n5.Withdraw the amount\n6.History\n7. Exit");
            System.out.print("Enter (1-6) : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1:
                    // to create a new account
                    System.out.print("Enter Account number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter Account Type (Saving | Current ):  ");
                    String accountType = sc.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance(MIN 5000): ");
                    long balance = sc.nextLong();
                    sc.nextLine();

                    users[count] = new BankDetails(accountNumber , accountType , name , balance);
                    count++;

                    break;
                case 2:
                    for (int i = 0; i < count; i++) {
                        users[i].displayAccount();
                    }
                    break;

                case 3:
                    System.out.print("Enter the account No");
                    String accountNumberToSearch = sc.next();

                    tasks.search(accountNumberToSearch, count, users);
                    break;

                case 4:
                    System.out.println("Enter the Account No ");
                    String accountNumberToDeposit = sc.next();

                    String transactionType = "deposit";
                    tasks.transaction(accountNumberToDeposit, count, users, transactionType);
                    break;

                case 5:
                    System.out.println("Enter the account no ");
                    String accountNumberToWithdraw = sc.next();

                    transactionType = "withdraw";
                    tasks.transaction(accountNumberToWithdraw, count, users, transactionType);
                    break;

                case 6:
                   System.out.print("Account Number: ");
                   int acnumber = sc.nextInt();
                   sc.nextLine();
                   users[acnumber].displayDepositHistory();
                   users[acnumber].displayWithdrawHistory();
                    break;
                case 7:
                    System.out.println("Thank You\n----SEE YOU SOON----");
                    break;
            }
        } while (choice != 7);
    }
}
