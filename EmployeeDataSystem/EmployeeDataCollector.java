package EmployeeDataSystem;


import java.util.*;

public class EmployeeDataCollector extends Employee {

     //detail of Employee
     private String name;
     private String designation;
     private int joiningYear;
     private int experiance;
     private double salary;
     private double incrementedSalary;

     //Classes And Objects
     Scanner collector = new Scanner(System.in);


     public EmployeeDataCollector(){
        name();
        designation();
        joiningYear();
        experience();
        salary();
        incrementedSalary();
        Employee e = new Employee(name , designation , joiningYear , experiance , salary , incrementedSalary);
        employee.add(e);
     }



    //Data Collecting Methods

    public void name(){
        do {
            System.out.print("Enter Name: ");
            name = collector.nextLine();
        } while (!verifyName(name));
    }

    public void designation(){
        do {
            System.out.print("Enter designation:\n1. Junior\n2. Executive\n3. Manager\n-->");            
            designation = collector.nextLine();
        } while (!verifyDesignation(designation));
    }


    public void joiningYear(){
            System.out.print("Enter Joining Year");
            joiningYear = collector.nextInt();
            collector.nextLine();
    }

    public void experience(){
        experiance = 2025 - joiningYear;
    }


    public void salary(){
            System.out.print("Enter Salary");
            salary = collector.nextDouble();
    }

    public void incrementedSalary(){
        if(designation.equalsIgnoreCase("junior"))
        {
            if(experiance<=2)
            {
                incrementedSalary = salary+ (salary/10);
            }
            else
            {
                incrementedSalary = salary+((salary/100)*20);
            }
        }

        if(designation.equalsIgnoreCase("executive"))
        {
            if(experiance<=1)
            {
                incrementedSalary = salary+ (salary/10)+500;
            }
            else
            {   
                incrementedSalary = salary+((salary/100)*15)+1000;
            }
        }

        if(designation.equalsIgnoreCase("manager"))
        {
            if(experiance<=10)
            {
                 incrementedSalary = salary+ ((salary/100)*5)+500;
            }
            else
            {
                incrementedSalary = salary+((salary/100)*15)+1000;
            }

        }
    }



     //Verifying Method's

     public boolean verifyName(String Name){
        for(int i=0;i<employee.size();i++){
            if (name.equals(employee.get(i).getEmployeeName())) {
                System.out.println("Employee Already Exist");
                return false;
            }
        }
        return true;
     }

     public boolean verifyDesignation(String Designation){
        if (designation.equalsIgnoreCase("junior") || designation.equalsIgnoreCase("executive") || designation.equalsIgnoreCase("manager")) {
            return true;
        }
        else{
            return false;
        }
     }
}