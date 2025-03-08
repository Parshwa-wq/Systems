package EmployeeDataSystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManager {

    // Variables
    static String name;
    static String designation;

    /**
     * This method is used update Name of an Employee.
     * First it fetches ID of the Employee we have to change Name.
     * Then it takes Name as input and then it verifies whether a Employee with the
     * Same Name already exist in the organization.
     * If there is an existing Employee it just returns with a prompt "Employee
     * Already Exist" and then prompt to reenter other name.
     * Else it updates the Name of the Employee.
     */
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
     * This method is used to update Designation of an Employee.
     * First it fatches id of the Employee we have to change Designation.
     * Then it takes the input of new Designation.
     * It then validate is there any Typo in Designation.
     * If there is some invalid input the it return with message "Invalid
     * Designation" and then prompt to reenter the Designation.
     * Otherwise it updates the Designation of the Employee.
     */
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

    /**
     * This Method is used to delete a Employee Details
     * to do it first it fetch the ID of the Employee you want to delete
     * Then it prompts for Confirmation whether YES or NO (Y/N)
     * if we Press 'Y' then it delete the Employee from Software
     * if we Press 'N' then it return with Prompt "Terminated Employee Deletation"
     */
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

                System.out.println("Matching Employees:");
                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (designation.equalsIgnoreCase(Employee.employeeData.get(i).getEmployeeDesignation())) {

                        System.out.println("Name: " + Employee.employeeData.get(i).getEmployeeName()
                                + " | Designation: " + Employee.employeeData.get(i).getEmployeeDesignation()
                                + " | Salary: " + Employee.employeeData.get(i).getEmployeeCurrentSalary()
                                + " | Joining Year: " + Employee.employeeData.get(i).getEmployeeJoiningYear()
                                + " | Experience: " + Employee.employeeData.get(i).getEmployeeExperience() + " Years");
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

                System.out.println("Matching Employees:");

                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (Employee.employeeData.get(i).getEmployeeCurrentSalary() > minSalary
                            && Employee.employeeData.get(i).getEmployeeCurrentSalary() < maxSalary) {

                        System.out.println("Name: " + Employee.employeeData.get(i).getEmployeeName()
                                + " | Designation: " + Employee.employeeData.get(i).getEmployeeDesignation()
                                + " | Salary: " + Employee.employeeData.get(i).getEmployeeCurrentSalary()
                                + " | Joining Year: " + Employee.employeeData.get(i).getEmployeeJoiningYear()
                                + " | Experience: " + Employee.employeeData.get(i).getEmployeeExperience() + " Years");
                    }
                }

                break;
            case 3:
                System.out.print("Minimum Experience in Years: ");
                int minExperience = input.nextInt();
                input.nextLine();

                System.out.println("Matching Employees:");
                for (int i = 0; i < Employee.employeeData.size(); i++) {
                    if (Employee.employeeData.get(i).getEmployeeExperience() > minExperience) {

                        System.out.println("Name: " + Employee.employeeData.get(i).getEmployeeName()
                                + " | Designation: " + Employee.employeeData.get(i).getEmployeeDesignation()
                                + " | Salary: " + Employee.employeeData.get(i).getEmployeeCurrentSalary()
                                + " | Joining Year: " + Employee.employeeData.get(i).getEmployeeJoiningYear()
                                + " | Experience: " + Employee.employeeData.get(i).getEmployeeExperience() + " Years");
                    }
                }
                break;

            default:
                System.out.println("Invalid Input Enter From (1 to 3)");
                break;
        }
    }

    /**
     * This Method is used To Search employee By Name
     * Working Steps
     * 1)It fetches name of employee to search for
     * 2)then a loop is initialised till length of the employeeData to find employee
     * 3)if employee with that name is found then it returns id of that employee
     * else it returns -1
     */
    // Method To Search A Employee by Name
    public static int searchByname(String name) {
        for (int i = 0; i < Employee.employeeData.size(); i++) {
            if (name.equalsIgnoreCase(Employee.employeeData.get(i).getEmployeeName())) {
                return i;
            }
        }
        System.out.println("Employee not Found");
        return -1;
    }

    /**
     * This Method is used To Search employee By ID
     * Working Steps
     * 1)It fetches ID of employee to search for
     * 2)then a loop is initialised till length of the employeeData to find employee
     * 3)if employee with that nameID is found then it returns ID of that employee
     * else it returns -1
     */
    // Method To Search A Employee by ID
    public static int searchByID(int id) {
        for (int i = 0; i < Employee.employeeData.size(); i++) {
            if (id == Employee.employeeData.get(i).getEmployeeID()) {
                return i;
            }
        }
        System.out.println("Employee not Found");
        return -1;
    }

    /**
     * This Method sortEmployees is used to Sort Employees Based on User
     * Choice(Name, Salary or Experience)
     * Working Method
     * 1) Fetches User choice either name or salary or experience
     * 2) Uses Collection Library to sort
     * 2.1) Sort by name
     * 2.2) Sort by Salary (Low TO High)
     * 2.3) Sort by experience (Most to Least)
     * 3) After Sorting It displays details of all Employee
     */
    public static void sortEmployees(int choice) {
        switch (choice) {
            case 1: // Sort by Name
                Collections.sort(Employee.employeeData, Comparator.comparing(Employee::getEmployeeName));
                break;
            case 2: // Sort by Salary (Lowest to Highest)
                Collections.sort(Employee.employeeData, Comparator.comparing(Employee::getEmployeeCurrentSalary));
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
