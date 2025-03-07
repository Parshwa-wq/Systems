package EmployeeDataSystem;

import java.util.Collection;
import java.util.Scanner;

public class EmployeeManager extends Employee {

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
            employeeData.get(id).setEmployeeName(name);
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
            employeeData.get(id).setEmployeeDesignation(designation);
        }
    }

    //Remove Employee
    public static void removeEmployee(int id){

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

            }else if (confirmation.equalsIgnoreCase("N")) {

                System.out.println("Terminated Employee Deletation");
                return;
            }
            else{
                System.out.println("Invalide KeyWord Press \"Y\" or \"N\"");
            }
        } while (!(confirmation.equalsIgnoreCase("Y") || confirmation.equalsIgnoreCase("N")));
    }
}
