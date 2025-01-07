import java.util.*;
class LJStudent{
    int rollno;
    String name;
    double javat1t2;
    static String lj="LJIET";
    Scanner sc=new Scanner(System.in);
    void set(){
        System.out.println("Enter the rollnumber of the student");
        rollno=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name of the student ");
        name=sc.nextLine();
        System.out.println("Enter the marks of the student in java");
        javat1t2=sc.nextDouble();

    }
    void get(){
        System.out.println("Rollno of the student is "+rollno);
        System.out.println("Name of the student is "+name);
        System.out.println("Marks of Java "+javat1t2);
        System.out.println("College name is "+lj);

    }
    void get(LJStudent arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i].get();

        }
    }
    void search(LJStudent arr[]){
        System.out.println("Enter the rollno ");
        int r=sc.nextInt();
        boolean s=true;
        for(int i=0;i<arr.length;i++){
            if(r==arr[i].rollno){
                s=false;
                arr[i].get();
                break;
            }
        }
        if(s){
            System.out.println("Rollno not found");
        }
    }


    void update(LJStudent arr[]){
        System.out.println("Enter the rollno ");
        int r=sc.nextInt();
        boolean a=true;
        for(int i=0;i<arr.length;i++){
            if(r==arr[i].rollno){
               
                System.out.println("Enter the new marks ");
                arr[i].javat1t2=sc.nextDouble();
                a=false;
                System.out.println("THE STUDENTS PROFILE IS UPDATED SUCCESSFULLY");
                break;
            }
            if(a){
                System.out.println("Rollno not found");
            }
        }
    }
    void sorting(LJStudent arr[])
    {
    LJStudent ob =new LJStudent(); ;
    
    for(int i = 0 ; i<arr.length ; i++){

    for(int j=i+1 ; j<arr.length ; j++){

    if(arr[i].rollno > arr[j].rollno){
    ob = arr[i] ;
    arr[i] = arr[j];
    arr[j] = ob ;
        }
    }
    }
    for(LJStudent x : arr){
    x.get();
    }
}

    void HomeVisit(LJStudent arr[]){
       for(int i = 0 ; i<arr.length ; i++){
          if(arr[i].javat1t2 < 18 ){
           System.out.println(arr[i].name);
        }
    }
}
    double highest(LJStudent arr[]){
    double max = arr[0].javat1t2;
    for(LJStudent x : arr){
        if( x.javat1t2 > max){
        max = x.javat1t2;
        } 
    }
    return max;
}
}


class Studentgradelj
{
    public static void main(String []args)
    {
        /*---------------------------------Coded by Binary Brains---------------------------------*/
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of student");
        int student=sc.nextInt();
        LJStudent arr[]=new LJStudent[student];
        for(int i=0;i<arr.length;i++){
            arr[i]=new LJStudent();
            arr[i].set();
        } 
        boolean a=true;
        do{
            System.out.println("1.To display Data of all students");
            System.out.println("2.To Search student by roll number");
            System.out.println("3.To Update Marks");
            System.out.println("4.To sort array in accending order");
            System.out.println("5.To Display Highest Marks in JAVAT1T2");
            System.out.println("6.To Display Home Visit Data");
            System.out.println("7.Exit");
            int choice = sc.nextInt();
            switch(choice)
            {
            case 1:arr[0].get(arr);break;
            case 2:arr[0].search(arr);break;
            case 3:arr[0].update(arr);break;
            case 4:arr[0].sorting(arr);break;
            case 5:System.out.println("Highest Total in JAVA T1 T2 "+arr[0].highest(arr));break;
            case 6:arr[0].HomeVisit(arr);break;
            case 7:System.out.println("Thank You");
            a= false; break;
            default: System.out.println("Invalid Input");
            }
        }while(a);
    }
}
