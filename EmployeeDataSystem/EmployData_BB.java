package EmployeeDataSystem;
import java.util.*;
//main class for calling methods
class EmployData
{
    /*----------------------------------Coded by Binary Brains----------------------------------*/
public static void main(String []args)
{
    Scanner sc = new Scanner(System.in);

    while(true)
    {
    System.out.print("Enter Choice:\n1. ENTER EMPLOYEE DATA\n2. PRINT EMPLOYEEDATA\n3. SORT BY INCREAMENT SALARY\n4. EXIT\n-->");
    int choice = sc.nextInt();
  
        switch(choice)
        {
            case 1:
            {
                EmployeeDataCollector newEmployee = new EmployeeDataCollector();
                break;
            }
            case 2:
            {
                System.out.println("Enter Employee ID");
                int id = sc.nextInt();
                System.out.println(Employee.employee.get(id-1).toString());
                break;
            }
            case 3:
            {
                //ob.sortBySalary();
                break;
            }
            case 4:
            {
                System.out.print("Exit");
                return;
            }
            default:
            System.out.println("Invalid Choice");
        }
    }
}
}

