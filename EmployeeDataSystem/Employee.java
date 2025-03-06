package EmployeeDataSystem;

import java.util.ArrayList;

public class Employee {

    // detail of Employee
    private String employeeName;
    private String employeeDesignation;
    private int employeeID;
    private int employeeJoiningYear;
    private int employeeExperience;
    private double employeeSalary;
    private double employeeIncrementedSalary;
    private static int employeeNumber = 1;

    // Some Important variables
    boolean verifier = false;

    // Array to store Employee Data
    public static ArrayList<Employee> employee = new ArrayList<>();

    public Employee() {
        // Default Constructor
    }

    public Employee(String employeeName, String employeeDesignation, int employeeJoiningYear, int employeeExperience,
            double employeeSalary, double employeeIncrementedSalary) {
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
        this.employeeID = employeeNumber;
        this.employeeJoiningYear = employeeJoiningYear;
        this.employeeExperience = employeeExperience;
        this.employeeSalary = employeeSalary;
        this.employeeIncrementedSalary = employeeIncrementedSalary;
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

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public double getEmployeeIncrementedSalary() {
        return employeeIncrementedSalary;
    }

    @Override
    public String toString() {
        return "Name: " + employeeName
                + "\nDesignation:" + employeeDesignation + "\nID: " + employeeID + "\nJoining Year: "
                + employeeJoiningYear + "\nExprience: " + employeeExperience + "\nSalary: " + employeeSalary + "\nIncrement in Salary: " + employeeIncrementedSalary;
    }
}
