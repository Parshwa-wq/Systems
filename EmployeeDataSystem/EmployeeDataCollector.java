package EmployeeDataSystem;

import java.time.LocalDate;
import java.util.*;

public class EmployeeDataCollector {

    // detail of Employee
    private static String name;
    private static String designation;
    private static int joiningYear;
    private static int experience;
    private static double salary;
    private static double incrementedSalary;

    // Classes And Objects
    Scanner collector = new Scanner(System.in);

    public EmployeeDataCollector() {
        name();
        designation();
        joiningYear();
        experience();
        salary();
        incrementedSalary();
        Employee e = new Employee(name, designation, joiningYear, experience, salary, incrementedSalary);
        Employee.employeeData.add(e);
    }

    // Data Collecting Methods

    /**
     * Method name is used to collect Name of Employee
     * It first verifies that An Employee with same name exist previously or not
     * and if no such employee is found then it allows/sets the name
     */
    public void name() {
        do {
            System.out.print("Enter Name: ");
            name = collector.nextLine();
        } while (!verifyName(name));
    }

    /**
     * Method 'designation' is used to collect/set the designation of employe out of
     * this three "junior", "executive" or "manager"
     * it also has basic validation of like we have entered correct entries(correct
     * spelling).
     */
    public void designation() {
        do {
            System.out.print("Enter designation:\n1. Junior\n2. Executive\n3. Manager\n-->");
            designation = collector.nextLine();
        } while (!verifyDesignation(designation));
    }

    /**
     * Method 'joiningYear' is used to collect/set the Joining Year of the employee
     */
    public void joiningYear() {
        System.out.print("Enter Joining Year");
        joiningYear = collector.nextInt();
        collector.nextLine();
    }

    /**
     * Method 'experience' is used to calc Experience of a employee
     */
    public void experience() {
        experience = LocalDate.now().getYear() - joiningYear;
    }

    /**
     * Method 'salary' is used to calc Salary of Employee
     */
    public void salary() {
        System.out.print("Enter Salary");
        salary = collector.nextDouble();
    }

    /**
     * Method 'incrementedSalary' is used to calc the Increment of a employee over
     * year's
     * the Algorithm consist Factors like "designation", "experience"
     * the Algorithm will evolve with time to give better and proper increment on
     * basis of employ talent and nature
     */
    public static void incrementedSalary() {
        if (designation.equalsIgnoreCase("junior")) {
            if (experience <= 2) {
                incrementedSalary = salary + (salary / 10);
            } else {
                incrementedSalary = salary + ((salary / 100) * 20);
            }
        }

        if (designation.equalsIgnoreCase("executive")) {
            if (experience <= 1) {
                incrementedSalary = salary + (salary / 10) + 500;
            } else {
                incrementedSalary = salary + ((salary / 100) * 15) + 1000;
            }
        }

        if (designation.equalsIgnoreCase("manager")) {
            if (experience <= 10) {
                incrementedSalary = salary + ((salary / 100) * 5) + 500;
            } else {
                incrementedSalary = salary + ((salary / 100) * 15) + 1000;
            }

        }
    }

    // Verifying Method's

    /**
     * Method 'verifyName' consist the Algorithm to Find whether the Employee
     * already exist in company or not
     * its a simple Search algorithm
     * Complexity time :- o(n) , space :- o(1)
     */
    public static boolean verifyName(String name) {
        for (int i = 0; i < Employee.employeeData.size(); i++) {
            if (name.equals(Employee.employeeData.get(i).getEmployeeName())) {
                System.out.println("Employee Already Exist");
                return false;
            }
        }
        return true;
    }

    /**
     * Method 'verifyDesignation' is a simple Algorithm to varidate Whether a
     * Designation given to a employe is correct or not
     * Is'nt there a typo etc...
     */
    public static boolean verifyDesignation(String designation) {
        if (designation.equalsIgnoreCase("junior") || designation.equalsIgnoreCase("executive")
                || designation.equalsIgnoreCase("manager")) {
            return true;
        } else {
            return false;
        }
    }
}