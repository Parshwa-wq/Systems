import java.util.*;
class Student
{
    int class_size;
    int snum;
    String ID;
    String name;
    String sub1;
    String sub2;
    String sub3;
    int marks1;
    int marks2;
    int marks3;
    Student[] arr = new Student[100];
    Scanner input=new Scanner(System.in);

    void getDetails()
    {
        System.out.print("Enter number of student: ");
        snum=input.nextInt();
        System.out.println();
        class_size+=snum;

        if(class_size>100)
        {
            System.out.print("cannot add more than 100 students in one class.");
            return;
        }

        for(int i=0;i<snum;i++)
        {
            arr[i]=new Student();
            System.out.print("Enter Student ID: ");
            arr[i].ID=input.next();
            System.out.print("Enter Student Name: ");
            arr[i].name=input.next();

            System.out.print("Enter Subject1: ");
            arr[i].sub1=input.next();
            System.out.print("Enter marks: ");
            arr[i].marks1=input.nextInt();
            System.out.println();

            System.out.print("Enter Subject2: ");
            arr[i].sub2=input.next();
            System.out.print("Enter marks: ");
            arr[i].marks2=input.nextInt();
            System.out.println();

            System.out.print("Enter Subject3: ");
            arr[i].sub3=input.next();
            System.out.print("Enter marks: ");
            arr[i].marks3=input.nextInt();
            System.out.println();
            
        }
    }

    void displayStudent(String id)
    {
        int count=0;
        for(int i=0;i<snum;i++)
        {
            if(arr[i].ID.equals(id))
            {
                count++;
                System.out.println("Student found!!");
                System.out.println("");
                System.out.println("Name: "+arr[i].name);
                System.out.println(arr[i].sub1+": "+arr[i].marks1);
                System.out.println(arr[i].sub2+": "+arr[i].marks2);
                System.out.println(arr[i].sub3+": "+arr[i].marks3);
                System.out.println("");
            }
        }
        if(count==0)
        {
            System.out.println("Student id not found.");
        }
    }

    void average(String id)
    {
        int count=0;
        for(int i=0;i<snum;i++)
        {
            if(arr[i].ID.equals(id))
            {
                count++;
                System.out.println("Student found!!");
                 System.out.print("Average marks for "+arr[i].name+": "+(double)(arr[i].marks1+arr[i].marks2+arr[i].marks3)/3);
            }
        }
        if(count==0)
        {
            System.out.println("Student id not found.");
        }
    }
    void highestAverage(int ave)
    {
        int count=0;
        for(int i=0;i<snum;i++)
        {
            int Average=(arr[i].marks1+arr[i].marks2+arr[i].marks3)/3;
            if(Average>ave)
            {
                count++;
                System.out.print("ID: "+arr[i].ID);
                System.out.print("Name: "+arr[i].name);
                System.out.print("Average: "+(arr[i].marks1+arr[i].marks2+arr[i].marks3)/3);
                System.err.println();
            }
        }
        if(count==0)
        {
            System.out.print("No student average is grater than "+ave);
        }
    }

    
}
class grade_Tracker
    /*----------------------------------Coded by Binary Brains----------------------------------*/
{
    public static void main(String s[])
    {
        Student obj=new Student();
        Scanner input = new Scanner(System.in);
        while (true)  
        {
            System.out.print("\nEnter choice:\n1. ENTER STUDENT DETAILS\n2. VIEW STUDENT GRADES\n3. CALCULATE AVERAGE\n4. DISPLAY STUDENTS WITH HIGH AVERAGE\n5. EXIT\n-->");
            int choice = input.nextInt();

            switch(choice)
            {
                case 1:
                {
                    obj.getDetails();
                    break;
                }
                case 2: 
                {
                    System.out.print("Enter Student ID: ");
                    String id=input.next();
                    obj.displayStudent(id);
                    break;
                }
                case 3:
                {
                    System.out.print("Enter Student ID: ");
                    String id=input.next();
                    obj.average(id);
                    break;
                }
                case 4:
                {
                    System.out.print("Enter threshold average: ");
                    int ave=input.nextInt();
                    obj.highestAverage(ave);
                    break;
                }
                case 5:
                {
                    System.out.println("Exits...");
                    return;
                }
                default :
                System.out.println("pls.. enter valid choice.");
            }
        }
    }
}
