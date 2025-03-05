package PersonalBudgetTracker;

import java.util.*;
class Transaction 
{
    String description;
    double amount;
    String category;
    
    Transaction(String description1, double amount1, String category1) 
    {
        description = description1;
        amount = amount1;
        category = category1;
    }
}

class BudgetTracker 
{
    int incomeSize = 0;
    int expenseSize = 0;
    Transaction[] incomeArr = new Transaction[100];
    Transaction[] expenseArr = new Transaction[100];
    double monthlyBudget;
    Scanner sc = new Scanner(System.in);

    void addTransaction() 
    {
        System.out.println("Enter type (1 for Income, 2 for Expense): ");
        int type = sc.nextInt();
        sc.nextLine();  // Consume newline
        
        System.out.println("Enter description:");
        String description = sc.nextLine();
        
        System.out.println("Enter amount:");
        double amount = sc.nextDouble();
        sc.nextLine();  // Consume newline
        
        System.out.println("Enter category (e.g., food, rent, transportation):");
        String category = sc.nextLine();

        if (type == 1) 
        {
            if (incomeSize < 100) 
            {
                incomeArr[incomeSize++] = new Transaction(description, amount, category);
            } 
            else 
            {
                System.out.println("Cannot add more than 100 income transactions.");
            }
        } 
        else if (type == 2) 
        {
            if (expenseSize < 100) 
            {
                expenseArr[expenseSize++] = new Transaction(description, amount, category);
            } 
            else 
            {
                System.out.println("Cannot add more than 100 expense transactions.");
            }
        } 
        else 
        {
            System.out.println("Invalid type! Please try again.");
        }
    }

    void viewTransactions() 
    {
        System.out.println("Income Transactions:");
        for (int i = 0; i < incomeSize; i++) 
        {
            System.out.println("Description: " + incomeArr[i].description + ", Amount: " + incomeArr[i].amount + ", Category: " + incomeArr[i].category);
        }

        System.out.println("Expense Transactions:");
        for (int i = 0; i < expenseSize; i++) 
        {
            System.out.println("Description: " + expenseArr[i].description + ", Amount: " + expenseArr[i].amount + ", Category: " + expenseArr[i].category);
        }
    }

    void calculateTotal() 
    {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (int i = 0; i < incomeSize; i++) 
        {
            totalIncome += incomeArr[i].amount;
        }
        
        for (int i = 0; i < expenseSize; i++) 
        {
            totalExpenses += expenseArr[i].amount;
        }

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
    }

    void setBudget() 
    {
        System.out.println("Enter your monthly budget limit:");
        monthlyBudget = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.println("Monthly budget has been set to: " + monthlyBudget);
    }

    void checkBudget() 
    {
        double totalExpenses = 0;

        for (int i = 0; i < expenseSize; i++) 
        {
            totalExpenses += expenseArr[i].amount;
        }

        System.out.println("Total Expenses: " + totalExpenses);
        if (totalExpenses <= monthlyBudget) 
        {
            System.out.println("You are within your budget!");
        } 
        else 
        {
            System.out.println("You have exceeded your budget!");
        }
    }

    void exitProgram() 
    {
        System.out.println("Exiting program...");
        System.exit(0);
    }
}

class TEST 
{
    public static void main(String[] args) 
    {
        BudgetTracker tracker = new BudgetTracker();
        Scanner sc = new Scanner(System.in);
        
        while (true) 
        {
            System.out.println("\nPersonal Budget Tracker");
            System.out.println("1. Add Income or Expense");
            System.out.println("2. View Income and Expenses");
            System.out.println("3. Calculate Total Income and Total Expenses");
            System.out.println("4. Set Monthly Budget");
            System.out.println("5. Check Budget Status");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline
            
            switch (choice) 
            {
                case 1:
                    tracker.addTransaction();
                    break;
                case 2:
                    tracker.viewTransactions();
                    break;
                case 3:
                    tracker.calculateTotal();
                    break;
                case 4:
                    tracker.setBudget();
                    break;
                case 5:
                    tracker.checkBudget();
                    break;
                case 6:
                    tracker.exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
