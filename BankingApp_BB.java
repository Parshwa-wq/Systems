import java.util.*;

class Bankdetails {
    String acc;
    String name;
    String acctype;
    long balance;
    Scanner sc = new Scanner(System.in);

    // this method is for opening new account
    void bankDetails() {
        System.out.print("Enter Account no ");
        acc = sc.nextLine();
        System.out.print("Enter Account Type  ");
        acctype = sc.nextLine();
        System.out.print("Enter Account Holder Name ");
        name = sc.nextLine();
        System.out.print("Enter Initial Balance ");
        balance = sc.nextLong();
        System.out.println();
    }

    // This method is for display the details of the accounts
    void displayacc() {
        System.out.println("Name of the account holder is " + name);
        System.out.println("Account no is " + acc);
        System.out.println("Account type is " + acctype);
        System.out.println("Initial balance in the account is " + balance);
    }

    // This method is for deposit money
    void deposit() {
        long amount;
        System.out.print("Enter the amount to be deposited ");
        amount = sc.nextLong();
        balance = balance + amount;
    }

    // This method is for withdraw money
    void withdraw() {
        long amount;
        System.out.println("Enter the amount to be withdrawn ");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Updated balance is " + balance);
        } else {
            System.out.println("Your balance is less than the " + amount + "\n" + "Transaction failed");
        }
    }

    boolean search(String acno) {
        if (acc.equals(acno)) {
            displayacc();
            return true;
        }
        return (false);
    }
}

class Bankingapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bankdetails arr[] = new Bankdetails[100];
        int count = 0;
        int choice;
        do {
            System.out.println("\n-------BANKING SYSTEM APPLICATION-------");
            System.out.println(
                    "1. Creat A Account\n2.Display all account deatils\n3.Search acc by Account type\n4.Deposit the amount\n5.Withdraw the amount\n6.Exit");
            choice = sc.nextInt();
            switch (choice) {

                case 1:
                    // to create a new account
                    for (int i = count; i <= count && i < 100; i++) {
                        arr[count] = new Bankdetails();
                        arr[count].bankDetails();
                    }
                    count++;

                    break;
                case 2:
                    for (int i = 0; i < count; i++) {
                        arr[i].displayacc();
                    }
                    break;

                case 3:
                    System.out.print("Enter the account No");
                    String acno = sc.next();
                    boolean b = false;
                    for (int i = 0; i < count; i++) {
                        b = arr[i].search(acno);
                        if (b) {
                            break;
                        }
                    }
                    if (!b) {
                        System.out.println("Account not found!!");

                    }
                    break;

                case 4:
                    System.out.println("Enter the Account No ");
                    acno = sc.next();
                    b = false;
                    for (int i = 0; i < arr.length; i++) {
                        b = arr[i].search(acno);
                        if (b) {
                            arr[i].deposit();
                            break;
                        }
                    }
                    if (!b) {
                        break;
                    }

                    if (!b) {
                        System.out.println("Account not found!!");

                    }
                    break;

                case 5:
                    System.out.println("Enter the account no ");
                    acno = sc.next();
                    b = false;
                    for (int i = 0; i < count; i++) {
                        b = arr[i].search(acno);
                        if (b) {
                            arr[i].withdraw();
                            break;
                        }
                    }
                    if (!b) {
                        System.out.println("Account not found!!");
                    }
                    break;

                case 6:
                    System.out.println("Thank You\n----SEE YOU SOON----");
                    break;
            }
        } while (choice != 6);
    }
}
