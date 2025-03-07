package EmployeeDataSystem;

import java.time.LocalDate;
import java.util.*;

public class EmployeeDataCollector {

    // detail of Employee
    private static String name;
    private static String designation;
    private static int joiningYear;
    private static int experience;
    private static double initialSalary;
    private static double currentSalary;
    private static double incrementedSalary;
    private static double performanceRating;

    // Classes And Objects
    Scanner collector = new Scanner(System.in);

    public EmployeeDataCollector() {
        name();
        designation();
        joiningYear();
        experience();
        salary();
        incrementedSalary();
        Employee e = new Employee(name, designation, joiningYear, experience, initialSalary, incrementedSalary,
                currentSalary, performanceRating);
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
        initialSalary = collector.nextDouble();
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
                incrementedSalary = initialSalary + (initialSalary / 10);
            } else {
                incrementedSalary = initialSalary + ((initialSalary / 100) * 20);
            }
        }

        if (designation.equalsIgnoreCase("executive")) {
            if (experience <= 1) {
                incrementedSalary = initialSalary + (initialSalary / 10) + 500;
            } else {
                incrementedSalary = initialSalary + ((initialSalary / 100) * 15) + 1000;
            }
        }

        if (designation.equalsIgnoreCase("manager")) {
            if (experience <= 10) {
                incrementedSalary = initialSalary + ((initialSalary / 100) * 5) + 500;
            } else {
                incrementedSalary = initialSalary + ((initialSalary / 100) * 15) + 1000;
            }

        }
        currentSalary = incrementedSalary * experience;
    }

    /**
     * Calculates the performance rating of an employee based on three key factors:
     * 1. Experience
     * 2. Salary Increase Over Time
     * 3. Designation
     * 
     * Performance Calculation Breakdown:
     * - The total performance score is based on **100 points**, which is then
     * scaled down to a **10-point rating.**
     * 
     * - **Experience Contribution (Max 30 points)**:
     * - Employees earn **6 points per 5 years** of experience.
     * - Capped at **30 points** for 25+ years of experience.
     * - Formula: {@code experienceScore = Math.min((experience / 5) * 6, 30);}
     * 
     * - **Salary Growth Contribution (Max 40 points)**:
     * - Salary increase percentage is calculated using the formula:
     * {@code salaryIncreasePercentage = ((currentSalary - initialSalary) / initialSalary) * 100;}
     * - Employees earn **10 points per 20% salary increase**, capped at **40
     * points**.
     * - Formula:
     * {@code salaryGrowthScore = Math.min((salaryIncreasePercentage / 20) * 10, 40);}
     * 
     * - **Designation Contribution (Max 30 points)**:
     * - Junior: **10 points**
     * - Executive: **20 points**
     * - Manager: **30 points**
     * - Formula:
     * {@code if (designation.equalsIgnoreCase("junior")) designationScore = 10;}
     * 
     * Final Rating:
     * - The total score (out of 100) is **scaled down to 10** for the final rating.
     * - Formula: {@code performanceRating = (totalScore / 100) * 10;}
     * 
     * Example Calculation:
     * - Experience: **10 years** → **12 points**
     * - Salary Growth: **50%** → **25 points**
     * - Designation: **Executive** → **20 points**
     * - **Total: 57 points / 100 = 5.7 rating**
     * 
     */
    public static void calculatePerformanceRating() {
        double experienceScore = Math.min((experience / 5) * 6, 30);

        double salaryIncreasePercentage = ((currentSalary - initialSalary) / initialSalary) * 100;

        double salaryGrowthScore = Math.min((salaryIncreasePercentage / 20) * 10, 40);

        double designationScore = 0;
        if (designation.equalsIgnoreCase("junior")) {
            designationScore = 10;
        } else if (designation.equalsIgnoreCase("executive")) {
            designationScore = 20;
        } else if (designation.equalsIgnoreCase("manager")) {
            designationScore = 30;
        }

        performanceRating = ((experienceScore) + (salaryGrowthScore) + (designationScore)) / 10;
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