package EmployeeDataSystem;

import java.util.ArrayList;

public class Employee {

    // detail of Employee
    private String employeeName;
    private String employeeDesignation;
    private int employeeID;
    private int employeeJoiningYear;
    private int employeeExperience;
    private double employeeInitialSalary;
    private double employeeCurrentSalary;
    private double employeeIncrementedSalary;
    private double employeePerformanceRating;
    protected static int employeeNumber = 1;

    // Some Important variables
    boolean verifier = false;


    //This ArrayList will store data of each employee working in the organization
    public static ArrayList<Employee> employeeData = new ArrayList<>();

    public Employee() {
        // Default Constructor
    }

    /**
     * this constructor is used to store the details of new employee of organization
     */
    public Employee(String employeeName, String employeeDesignation, int employeeJoiningYear, int employeeExperience,
            double employeeSalary, double employeeIncrementedSalary , double employeeCurrentSalary , double employeePerformanceRating) {

        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
        this.employeeID = employeeNumber;
        this.employeeJoiningYear = employeeJoiningYear;
        this.employeeExperience = employeeExperience;
        this.employeeInitialSalary = employeeSalary;
        this.employeeIncrementedSalary = employeeIncrementedSalary;
        this.employeeCurrentSalary = employeeCurrentSalary;
        this.employeePerformanceRating = employeePerformanceRating;
        employeeNumber++;
    }

    
    // Getter Method's
    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getEmployeeJoiningYear() {
        return employeeJoiningYear;
    }

    public int getEmployeeExperience() {
        return employeeExperience;
    }

    public double getEmployeeInitialSalary() {
        return employeeInitialSalary;
    }

    public double getEmployeeCurrentSalary() {
        return employeeCurrentSalary;
    }

    public double getEmployeeIncrementedSalary() {
        return employeeIncrementedSalary;
    }

    public double getEmployeePerformanceRating() {
        return employeePerformanceRating;
    }

    
    // Setter Method's
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }


    // Display the Details of a particular Employee in a good Format
    @Override
    public String toString() {
        return "Name: " + employeeName
                + "\nDesignation:" + employeeDesignation + "\nID: " + employeeID + "\nJoining Year: "
                + employeeJoiningYear + "\nExprience: " + employeeExperience + "\nInitial Salary: "
                + employeeInitialSalary + "\nCurrent Salary: " + employeeCurrentSalary
                + "\nIncrement in Salary: " + employeeIncrementedSalary;
    }
}
