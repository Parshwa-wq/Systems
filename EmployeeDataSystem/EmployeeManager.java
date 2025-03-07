package EmployeeDataSystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManager {

    // Variables
    static String name;
    static String designation;

    /**
     * This Method is use to Update Name of A Person
     * Working Steps
     * 1)It takes/Fetch id of which employee you want to change name
     * 2)Then it takes Updated Name Until A valid name is given to the Employee
     * 2.1)To verify it Uses Same Algo Of EmployeeDataCollector class(verifyname LOC
     * --> 123 to 131)
     * 3)And finnaly it Updates Name of the Employee
     */

    // Update Name
    public static void updateName(int id) {

        // Classes And There Objects
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Name To Update : ");
            name = sc.nextLine();
        } while (!EmployeeDataCollector.verifyName(name));

        {
            Employee.employeeData.get(id).setEmployeeName(name);
        }
    }

    /**
     * This Method is use to Update Designation of A Person
     * Working Steps
     * 1)It takes/Fetch id of which employee you want to change Designation
     * 2)Then it takes Updated Designation Until A valid Designation is Chosen for
     * the Employee form this three(junior, executive or manager)
     * 2.1)To verify it Uses Same Algo Of EmployeeDataCollector
     * class(verifyDesignation LOC --> 137 to 144)
     * 3)And finnaly it Updates Designation of the Employee
     */
    // Update Designation
    public static void updateDesignation(int id) {

        // Classes And There Objects
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Designation To Update : ");
            designation = sc.nextLine();
        } while (!EmployeeDataCollector.verifyDesignation(designation));
        {
            Employee.employeeData.get(id).setEmployeeDesignation(designation);
        }
    }

    // Remove Employee
    public static void removeEmployee(int id) {

        String confirmation;

        // Classes And There Objects
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Are You Sure(Y/N) : ");
            confirmation = sc.next();

            if (confirmation.equalsIgnoreCase("Y")) {

                Employee.employeeData.remove(id);
                System.out.println("Employee Deleted SuccessFully");
                return;

            } else if (confirmation.equalsIgnoreCase("N")) {

                System.out.println("Terminated Employee Deletation");
                return;
            } else {
                System.out.println("Invalide KeyWord Press \"Y\" or \"N\"");
            }
        } while (!(confirmation.equalsIgnoreCase("Y") || confirmation.equalsIgnoreCase("N")));
    }

    /**
     * This Method advanceSearch is used to Search Employees in Bulk
     * Working Method(Algorithm)
     * 1) Fetches User choice either Designation or salary range or experience
     * 2) Basic Search Algorithm To Search For user with The defiened characteristic
     * 2.1) Search by Designation
     * 2.2) Search by Salary Range
     * 2.3) Search by experience
     * 3) After Searching It displays details of all Employee with the
     * characteristic
     * 
     * #Classes And There Object
     * 1) input --> Object of Class Scanner
     * --> used to take Different inputs
     * 
     * 
     * #Case Discription
     * 1) Designation
     * --> it takes designation has input and give out the employee details which
     * matches the designation ex. if selected designation in junior then all
     * employee with designation junior will be shown in line. it also validate is
     * there any typo in designation
     * 
     * #Variables
     * 1) designation Type --> String
     * Use --> To take input of required designation
     * 
     * 2) Salary
     * --> it takes range of salary the min salary and max salary and then prints
     * employee details who have salary in this range ex. range (10000 , 50000) then
     * it will print employee details who has salary in range 10000 to 50000
     * 
     * #Variables
     * 1) minSalary Type --> int
     * Use --> To Take Input of min salary in range
     * 
     * 1) maxSalary Type --> int
     * Use --> To Take Input of max salary in range
     * 
     * 3) Experience
     * --> it takes Min experience and then print details of employee who have
     * expereince greater than the input ex. min experience 5 year than it will
     * print employee details who have experience more than 5 year
     * 
     * #Variables
     * 1) minExperience Type --> int
     * Use --> To Take Input of min Experience required
     * 
     * 
     */
    public static void advanceSearch(int choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1: {

                do {
                    System.out.print("Enter designation:\n1. Junior\n2. Executive\n3. Manager\n-->");
                    designation = input.nextLine();
                } while (!EmployeeDataCollector.verifyDesignation(designation));

                System.out.println("All employee With Designation: " + designation); // Header of Design

                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (designation.equalsIgnoreCase(Employee.employeeData.get(i).getEmployeeDesignation())) {
                        System.out.println("\n" + Employee.employeeData.get(i).toString());
                    }
                }
            }
                break;
            case 2:

                System.out.print("Minimum Salary: ");
                int minSalary = input.nextInt(); // Minimum Salary in range
                input.nextLine();

                System.out.print("Maximum Salary: ");
                int maxSalary = input.nextInt(); // Maximum Salary in range
                input.nextLine();

                System.out.println("All employee With Salary Range: (" + minSalary + "," + maxSalary + " )"); // Header
                                                                                                              // Design

                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (Employee.employeeData.get(i).getEmployeeSalary() > minSalary
                            && Employee.employeeData.get(i).getEmployeeSalary() < maxSalary) {
                        System.out.println("\n" + Employee.employeeData.get(i).toString());
                    }
                }

                break;
            case 3:
                System.out.print("Minimum Experience in Years: ");
                int minExperience = input.nextInt();
                input.nextLine();

                System.out.println("All employee With Experience More Than: " + minExperience);

                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (Employee.employeeData.get(i).getEmployeeExperience() > minExperience) {
                        System.out.println("\n" + Employee.employeeData.get(i).toString());
                    }
                }
                break;

            default:
                System.out.println("Invalid Input Enter From (1 to 3)");
                break;
        }
    }

    /**
     * This Method sortEmployees is used to Sort Employees Based on User
     * Choice(Name, Salary or Experience)
     * Working Method
     * 1) Fetches User choice either name or salary or experience
     * 2) Uses Collection Library to sort
     * 2.1) Sort by name
     * 2.2) Sort by Salary (Low TO High)
     * 2.3)nSort by experience (Most to Least)
     * 3) After Sorting It displays details of all Employee
     */
    public static void sortEmployees(int choice) {
        switch (choice) {
            case 1: // Sort by Name
                Collections.sort(Employee.employeeData, Comparator.comparing(Employee::getEmployeeName));
                break;
            case 2: // Sort by Salary (Lowest to Highest)
                Collections.sort(Employee.employeeData, Comparator.comparing(Employee::getEmployeeSalary));
                break;
            case 3: // Sort by Experience (Most to Least)
                Collections.sort(Employee.employeeData,
                        Comparator.comparing(Employee::getEmployeeExperience).reversed());
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                return;
        }
        System.out.println("Sorting Complete! Displaying Sorted Employees:");
        for (Employee e : Employee.employeeData) {
            System.out.println("\n" + e.toString());
        }
    }
}
