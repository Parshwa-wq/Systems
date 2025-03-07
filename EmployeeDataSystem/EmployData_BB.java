package EmployeeDataSystem;

import java.util.*;

//main class for calling methods
class EmployData {
    /*----------------------------------Coded by Binary Brains----------------------------------*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(
                    "Enter Choice:\n1. Add new Employee\n2. PRINT EMPLOYEEDATA\n3. Modify Detail of Employee\n4. Remove A Employee\n5. Sort Employee\n6. EXIT\n-->");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    EmployeeDataCollector newEmployee = new EmployeeDataCollector();
                    break;
                }
                case 2: {
                    int id = search();
                    System.out.println(Employee.employeeData.get(id).toString());
                    break;
                }
                case 3: {
                    modify();
                    break;
                }
                case 4: {
                    int id = search();
                    if (id == -1) {
                        continue;
                    } else {
                        EmployeeManager.removeEmployee(id);
                    }
                    break;
                }
                case 5:{
                    System.out.println("Sort By:\n1. Name\n2. Salary\n3. Experience");
                    int sortChoice = sc.nextInt();
                    EmployeeManager.sortEmployees(sortChoice);
                    break;
                }
                case 6: {
                    System.out.print("Exit");
                    return;
                }
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    /**
     * The Method 'Modifier is used to modify Name or Designation of a Employee'
     * #Working Steps
     * 1)first It calls Search Class of EmployeeData_BB class LOC -- >79
     * 2)After Searching It asks for What to Modify(Name or Designation);
     * 2.1)If We get an Invalide user then it returns with message of failure
     * 2.2)Else We move to next step
     * 3)Then it calls the respective methods of class EmployeeManger
     * 3.1) for name updateName Method LOC --> 21
     * 3.2) for Designation updateDesignation Method LOC --> 45
     * 
     * #Variables
     * 1)modifyWhat --> Type :- String
     * --> Use :- Select what to Modify (Name or Designation)
     * 
     * 2)id --> Type :- Int
     * --> Use :- To get id of Employee for which change are needed
     * 
     * 
     * #Object of Classes
     * 1)modifier --> object of class :- Scanner
     * --> Use of object :- to Take Input's
     */
    private static void modify() {

        // Variables
        String modifyWhat;
        int id;

        // Classes and there Object
        Scanner modifier = new Scanner(System.in);

        id = search();

        if (id == -1) {
            return;
        }

        do {
            System.out.println("What do you want to Modify \n1)Name \n2)Designation");
            modifyWhat = modifier.nextLine();

            if (modifyWhat.equals("1")) {
                EmployeeManager.updateName(id);
            } else if (modifyWhat.equals("2")) {
                EmployeeManager.updateDesignation(id);
            } else {
                System.out.println("Invalid Input Enter either 1 or 2");
            }

        } while (!(modifyWhat.equals("1") || modifyWhat.equals("2")));
    }

    /**
     * The Method 'Search is used to Search for a Employee on Bases of Name or
     * Designation of a Employee.
     * #Working Steps
     * 1)It asks for How to search By --> (Name or Designation).
     * 2)Then it calls the respective methods of class Employee To Search for
     * employee
     * 2.1)If We chose Name Then it calls Method searchByname of Class Employee LOC
     * --> 105
     * 2.2)if We chose ID then it calls Method searchByID of Class Employee LOC -->
     * 130
     * user also it validate if input is within valid range( Greater than 1 & Less
     * than Total Number of Employee count)
     * 3)Then it returns the ID if it finds the employee with that Name or ID
     * 3.1) if no such employee is found it returns -1
     * 
     * #Variables
     * 1)searchby --> Type :- String
     * --> Use :- Select how to Search By --> (Name or Designation)
     * 
     * 2)id --> Type :- Int
     * --> Use :- To get id of Employee for which change are needed
     * 
     * 
     * #Object of Classes
     * 1)searchEmployee --> object of class :- Scanner
     * --> Use of object :- to Take Input's
     */
    private static int search() {

        // Variables
        String searchBy;
        int id;

        // Classes and there Object
        Scanner searchEmployee = new Scanner(System.in);

        do {
            System.out.println("Search By \n1)Name \n2)ID");
            searchBy = searchEmployee.nextLine();

            if (searchBy.equals("1")) {
                System.out.print("Enter Name: ");
                String name = searchEmployee.nextLine();
                id = Employee.searchByname(name);
                return id;
            } else if (searchBy.equals("2")) {
                System.out.print("Enter ID: ");
                id = searchEmployee.nextInt();
                searchEmployee.nextLine(); // so next line is not skiped
                return Employee.searchByID(id);
            } else {
                System.out.println("Invalid Input Enter either 1 or 2");
            }

        } while (!(searchBy.equals("1") || searchBy.equals("2")));
        return -1;
    }
}
