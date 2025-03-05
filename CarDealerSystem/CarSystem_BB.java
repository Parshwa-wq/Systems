package CarDealerSystem;

import java.util.*;
class car_system
{
    Scanner sc = new Scanner(System.in);
    car_system[] arr = new car_system[100];
    int currentindex=0;
    int noofcars;
    String RegistrationNo;
    String Model;
    double Mileage;
    double fuelcapacity;

    void AddCars()
    {
        System.out.print("Enter number of cars you want to add");
        noofcars = sc.nextInt();

        for(int i=currentindex ;i<currentindex + noofcars;i++)
        {
            arr[i] = new car_system();
            System.out.println("--------------------------------");
            System.out.println("Enter Details for Car no " + i);
            System.out.print("Enter Registration no for car: " + i);
            arr[i].RegistrationNo = sc.next();
            System.out.print("Enter Model no for car: " + i);
            arr[i].Model = sc.next();
            System.out.print("Enter Mileage for car: " + i);
            arr[i].Mileage = sc.nextDouble();
            System.out.print("Enter Fuel Capacity for car: " + i);
            arr[i].fuelcapacity = sc.nextDouble();
            System.out.println("---------------------------------");
        }
        currentindex = noofcars + currentindex;

    }

    void distanceinfulltank(String RegNo)
    {
        for(int i =0;i<currentindex;i++)
        {
            if(arr[i].RegistrationNo.equals(RegNo)) {
                System.out.println("Car Found in Database");
                System.out.println("This Car can run upto " + arr[i].Mileage * arr[i].fuelcapacity + "Kms");
            }
        }
    }

    void carwithhighmileage(double Milg)
    {
        for(int i =0;i<currentindex;i++)
        {
            if(arr[i].Mileage > Milg) {
                System.out.println("Car no " + i + "have Mileage" + arr[i].Mileage);
            }
        }
    }

    public static void main(String args[])
    {
        //your code goes here
        Scanner sc = new Scanner(System.in);
        car_system obj = new car_system();

        while(true)
        {
            System.out.println(" Select Your Purpose from Below :");
            System.out.print("1] Add cars \n" +
                    "2] check distance can be cover in full tank for any car\n"+
                    "3] Cars with high Mileage \n" +
                    "4] Exit" );
            int choice = sc.nextInt();

            if(choice==1){
                obj.AddCars();
            }
            if(choice==2){
                System.out.print("Enter Registration no of car: ");
                String regno = sc.next();
                obj.distanceinfulltank(regno);
            }
            if(choice==3){
                System.out.print("Enter your Expected Mileage: ");
                double milgg = sc.nextDouble();
                obj.carwithhighmileage(milgg);
            }
            if(choice==4){
                break;
            }

        }
        System.out.print("----------Program Ended----------");
    }
}
