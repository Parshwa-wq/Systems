package EmployeeDataSystem;
import java.util.*;
class Employe
{
String emp_name;
int emp_id;
int no_emp;
int emp_joining_year;
double emp_salary;
int designation;
String emp_designation;
int emp_experience;
double emp_incremented_salary;

Employe[] arr;
Scanner sc = new Scanner(System.in);
//for taking input
void setdate()
{
    Employe ob = new Employe();
    System.out.print("Enter number of employ: ");
    no_emp = sc.nextInt();

    arr=new Employe[no_emp];
for(int i =0;i<no_emp;i++){
    arr[i]=new Employe();
    System.out.print("Enter name: ");

    arr[i].emp_name = sc.next();
    System.out.print("Enter id: ");

    arr[i].emp_id = sc.nextInt();
    System.out.print("Enter joining year: ");

    arr[i].emp_joining_year = sc.nextInt();

    while(true)
    {
        if(arr[i].emp_joining_year<2000  || arr[i].emp_joining_year>2025)
        {
            System.out.print("Enter valid year");
            arr[i].emp_joining_year = sc.nextInt();
        }
        else
        {
            break;
        }
    }

    System.out.print("Enter Employ salary: ");
    arr[i].emp_salary = sc.nextDouble();
    System.out.print("Enter designation:\n1. Junior\n2. Executive\n3. Manager\n-->");
    arr[i].designation = sc.nextInt();
    System.out.println("");
}
//for asigning designation
for(int i=0;i<no_emp;i++)
{
    if(arr[i].designation == 1)
    {
        arr[i].designation = 1;
        arr[i].emp_designation = "Junior";
    }
    if(arr[i].designation == 2)
    {
        arr[i].designation = 2;
        arr[i].emp_designation = "Executive";
    }
    if(arr[i].designation == 3)
    {
        arr[i].designation = 3;
        arr[i].emp_designation = "Manager";
    }
}
}
//calculate experiance
void experience()
{
    int a=2025;
    for(int i =0;i<no_emp;i++)
    {
       arr[i].emp_experience = a - arr[i].emp_joining_year;
    }

}
//for calculating increment for junior.
void appraisalJunior()
{
    for(int i=0;i<no_emp;i++)
    {
        if(arr[i].designation == 1)
        {
            if(arr[i].emp_experience<=2)
            {
                arr[i].emp_incremented_salary = arr[i].emp_salary+ (arr[i].emp_salary/10);
            }
            else
            {
                arr[i].emp_incremented_salary = arr[i].emp_salary+((arr[i].emp_salary/100)*20);
            }
        }
    }
}
//for calculating increment for executive
void appraisalexecutive()
{
    for(int i=0;i<no_emp;i++)
    {
        if(arr[i].designation == 2)
        {
            if(arr[i].emp_experience<=1)
            {
                arr[i].emp_incremented_salary = arr[i].emp_salary+ (arr[i].emp_salary/10)+500;
            }
            else
            {   
                arr[i].emp_incremented_salary = arr[i].emp_salary+((arr[i].emp_salary/100)*15)+1000;
            }
        }
    }
}
//for calculating increment for manager
void appraisalmanager()
{ 
    for(int i=0;i<no_emp;i++)
    {
        if(arr[i].designation == 3)
        {
            if(arr[i].emp_experience<=10)
            {
                 arr[i].emp_incremented_salary = arr[i].emp_salary+ ((arr[i].emp_salary/100)*5)+500;
            }
            else
            {
                arr[i].emp_incremented_salary = arr[i].emp_salary+((arr[i].emp_salary/100)*15)+1000;
            }

        }
    }
}
//printing details of employes
void printData()
{
    for(int i =0;i<no_emp;i++)
    {
        System.out.print("Employe "+(i+1)+"\n");
        System.out.println("NAME: "+arr[i].emp_name);
        System.out.println("ID: "+arr[i].emp_id);
        System.out.println("JOINING YEAR: "+arr[i].emp_joining_year);
                experience();
        System.out.println("EXPERIENCE: "+arr[i].emp_experience);  
        System.out.println("SALARY: "+arr[i].emp_salary);
        System.out.println("DESIGNATION: "+arr[i].emp_designation);
                appraisalJunior();
                appraisalexecutive();
                appraisalmanager();
        System.out.println("SALARY INCREAMENT: "+arr[i].emp_incremented_salary);
        System.out.println("");
    }
}
//sorting by increment salary
void sortBySalary()
{
    for(int i=0;i<no_emp;i++)
    {
        for(int j=0;j<no_emp;j++)
        {
            if(arr[i].emp_incremented_salary>arr[j].emp_incremented_salary)
            {
                Employe temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    printData();
}
}
//main class for calling methods
class EmployData
{
    /*----------------------------------Coded by Binary Brains----------------------------------*/
public static void main(String []args)
{
    Employe ob = new Employe();
    Scanner sc = new Scanner(System.in);

    while(true)
    {
    System.out.print("Enter Choice:\n1. ENTER EMPLOYEE DATA\n2. PRINT EMPLOYEEDATA\n3. SORT BY INCREAMENT SALARY\n4. EXIT\n-->");
    int choice = sc.nextInt();
  
        switch(choice)
        {
            case 1:
            {
                ob.setdate();
                break;
            }
            case 2:
            {
                ob.printData();
                break;
            }
            case 3:
            {
                ob.sortBySalary();
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

