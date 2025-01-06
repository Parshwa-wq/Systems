import java.util.ArrayList;
import java.util.Scanner;

class Transaction 
{
    String description;
    double amount;
    String category;
    
    Transaction(String description, double amount, String category) 
    {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class BudgetTracker 
{
    private ArrayList<Transaction> incomeList = new ArrayList<>();
    private ArrayList<Transaction> expenseList = new ArrayList<>();
    private double monthlyBudget;
    private Scanner sc = new Scanner(System.in);

    // Method to add income or expense
    public void addTransaction() {
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
            incomeList.add(new Transaction(description, amount, category));
        } else if (type == 2) 
        {
            expenseList.add(new Transaction(description, amount, category));
        } else 
        {
            System.out.println("Invalid type! Please try again.");
        }
    }

    // Method to view all income and expenses
    public void viewTransactions() 
    {
        System.out.println("Income:");
        for (Transaction t : incomeList) 
        {
            System.out.println("Description: " + t.description + ", Amount: " + t.amount + ", Category: " + t.category);
        }

        System.out.println("Expenses:");
        for (Transaction t : expenseList) 
        {
            System.out.println("Description: " + t.description + ", Amount: " + t.amount + ", Category: " + t.category);
        }
    }

    // Method to calculate total income and total expenses
    public void calculateTotal() 
    {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (Transaction t : incomeList) 
        {
            totalIncome += t.amount;
        }
        
        for (Transaction t : expenseList) 
        {
            totalExpenses += t.amount;
        }

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
    }

    // Method to set monthly budget for categories
    public void setBudget() 
    {
        System.out.println("Enter your monthly budget limit:");
        monthlyBudget = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.println("Monthly budget has been set to: " + monthlyBudget);
    }

    // Method to check if expenses are within budget
    public void checkBudget() 
    {
        double totalExpenses = 0;

        for (Transaction t : expenseList) 
        {
            totalExpenses += t.amount;
        }

        System.out.println("Total Expenses: " + totalExpenses);
        if (totalExpenses <= monthlyBudget) 
        {
            System.out.println("You are within your budget!");
        } else {
            System.out.println("You have exceeded your budget!");
        }
    }
    
    // Method to exit the program
    public void exitProgram() 
    {
        System.out.println("Exiting program...");
        System.exit(0);
    }
}

public class Personal_Budget_Tracker 
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
