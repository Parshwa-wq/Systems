package ShoppingListTracker;
import java.util.*;
class store
{
    int size=0;
    int product;
    String name;
    int quantity;
    double price;
    String exp_date;
    store[] arr=new store[100];
    Scanner input=new Scanner(System.in);

    void getDetails()
    {
        
        if(size>=100)
        {
             System.out.print("cannot store more than 100 product.");
        }
        else
        {
        arr[size]=new store();
        System.out.print("Product name: ");
        arr[size].name=input.next();
        System.out.print("Quantity: ");
        arr[size].quantity=input.nextInt();
        System.out.print("Price: ");
        arr[size].price=input.nextDouble();

        while(true)
        {
            if(arr[size].price<0)
            {
                System.out.print("pls enter valid price: ");
                arr[size].price=input.nextDouble();
            }
            else
            break;
        }
            
        System.out.print("expiration date(DD/MM/YYYY): ");
        arr[size].exp_date=input.next();
        String[] darr=arr[size].exp_date.split("/",3);
        int d=Integer.parseInt(darr[0]);
        int m=Integer.parseInt(darr[1]);
        int y=Integer.parseInt(darr[2]);
        for(int i=0;;i++)
        {
            darr=arr[size].exp_date.split("/",3);
            d=Integer.parseInt(darr[0]);
            m=Integer.parseInt(darr[1]);
            y=Integer.parseInt(darr[2]);
            if(arr[size].exp_date.length()!=10 || arr[size].exp_date.charAt(2)!='/' || arr[size].exp_date.charAt(5)!='/')
            {
            System.out.println("follow this format(DD/MM/YYYY)\npls... try again!!");
            System.out.print("expiration date(DD/MM/YYYY): ");
            arr[size].exp_date=input.next();
            }

            else if((y%400==0 || (y%100!=0 && y%4==0)) && m==2 && (d<1 || d>29))
            {
                System.out.println("pls enter a valid date.");
                System.out.print("expiration date(DD/MM/YYYY): ");
                arr[size].exp_date=input.next();
            }

            else if((y%400!=0 || (y%100==0 && y%4!=0)) && m==2 && (d<1 || d>28))
            {
                System.out.println("pls enter a valid date.");
                System.out.print("expiration date(DD/MM/YYYY): ");
                arr[size].exp_date=input.next();
            }

            else if((m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)  && (d>31 || d<1))
            {
                System.out.println("plss enter valid date.");
                System.out.print("expiration date(DD/MM/YYYY): ");
                arr[size].exp_date=input.next();
            }

            else if((m==4 || m==6 || m==9 || m==11)  && (d>30 || d<1))
            {
                System.out.println("plss enter valid date.");
                System.out.print("expiration date(DD/MM/YYYY): ");
                arr[size].exp_date=input.next();
            }

            else if(m>12 || m<0)
            {
                System.out.println("pls enter a valid month.");
            }
        
            else
                break;
        }
        size++;
        }
    }

    void totalBill()
    {
        double bill=0;
        for(int i=0;i<size;i++)
        {
            bill+=arr[i].price*arr[i].quantity;
        }
        System.out.println("Total bill: "+bill);
    }

    void displayItemAbovePrice(double threshold_price)
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(arr[i].price>threshold_price)
            {
                System.out.println("product: "+arr[i].name);
                System.out.println("quantity: "+arr[i].quantity);
                System.out.println("expiration date: "+arr[i].exp_date);
                count++;
            }
        }
        if(count==0)
        System.out.println("No items found above this price.");
    }

    void serachByName(String Name)
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(arr[i].name.equals(Name))
            {
                System.out.println("");
                System.out.println("Product found!!");
                System.out.println("product: "+arr[i].name);
                System.out.println("price: "+arr[i].price);
                System.out.println("quantity: "+arr[i].quantity);
                System.out.println("expiration date: "+arr[i].exp_date);
                count++;
                break;
            }
        }
        if(count==0)
        {
            System.out.print("Sorry.. but product is not available");
        }
    }

    void updateValue(String Name)
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(arr[i].name.equals(Name))
            {
                System.out.println("");
                System.out.println("Product found!!");
                System.out.print("Updated quantity: ");
                arr[i].quantity=input.nextInt();
                System.out.print("Updated price: ");
                arr[i].price=input.nextDouble();
                count++;
                break;
            }
        }
        if(count==0)
        {
            System.out.println("Sorry.. but product is not available");
        }
    }

    void displayAll()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println("Product "+(i+1)+": ");
            System.out.println("Name: "+arr[i].name+" ");
            System.out.println("Quantity: "+arr[i].quantity+" ");
            System.out.println("Price: "+arr[i].price+" ");
            System.out.println("Expiration Date: "+arr[i].exp_date+" ");
            System.out.println("");
        }
    }

    void sortByPrice()
    {
        Arrays.sort(arr, 0, size, Comparator.comparingDouble(p -> p.price));
        displayAll();
        System.out.println("Product sorted by price.");
    }

    void sortByQuantity()
    {
        Arrays.sort(arr,0,size, Comparator.comparingInt(a ->a.quantity));
        displayAll();
        System.out.print("Product sorted by quantity.");
    }

    void expSoon()
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            String[] darr=arr[i].exp_date.split("/",3);
            int d=Integer.parseInt(darr[0]);
            int m=Integer.parseInt(darr[1]);
            int y=Integer.parseInt(darr[2]);
            if(y==2025 && m<6)
            {
                System.out.println("Product "+(i+1)+": ");
                System.out.println("Name: "+arr[i].name);
                System.out.println("Quantity: "+arr[i].quantity);
                System.out.println("Price: "+arr[i].price);
                System.out.println("");
                count++;
            }
        }
        if(count!=0)
        System.out.println("These products will be expire within six months.");
        else
        System.out.println("No items found ");
    }

    void expiredItems()
    {
        int count=0;
        for(int i=0;i<size;i++)
        {
            String[] darr=arr[i].exp_date.split("/",3);
            int d=Integer.parseInt(darr[0]);
            int m=Integer.parseInt(darr[1]);
            int y=Integer.parseInt(darr[2]);
            if(y<2025 || d<5)
            {
                System.out.println("Product "+(i+1)+": ");
                System.out.println("Name: "+arr[i].name);
                System.out.println("Quantity: "+arr[i].quantity);
                System.out.println("Price: "+arr[i].price);
                System.out.println("");
                count++;
            }
        }
        if(count!=0)
        System.out.println("These products were expired.");
        else
        System.out.println("No items found ");
    }

    void totalQuantity()
    {
        int totalquantitys=0;
        for(int i=0;i<size;i++)
        {
            totalquantitys+=arr[i].quantity;
        }
        System.out.println("Total quantities: "+totalquantitys);
    }
}
class Shopping_List_Tracker
{
    public static void main(String s[])
    {
        /*----------------------------------Coded by Binary Brains----------------------------------*/
        store obj=new store();
        Scanner input = new Scanner(System.in);

        while(true)
        {
        System.out.print("\nEnter your choice:\n1. ADD PRODUCT\n2. CALCULATE TOTALBILL\n3. DISPLAY ITEMS ABOVE A PRICE\n4. SEEARCH ITEMS BY NAME\n5. UPDATE ITEM'S QUANTITY AND PRICE\n6. SHOW ALL PRODUCTS\n7. SORT ITEMS BY PRICE AND QUANTITY\n8. DISPLAY ITEM EXPIRING SOON\n9. DISPLAY EXPIRED ITEMS\n10. DISPLAY TOTAL QUANTITIES OF ALL ITEMS\n11. EXIT\n-->");
        int choice=input.nextInt();

            switch(choice)
            {
                case 1:
                {
                    obj.getDetails();
                    break;
                }
                case 2:
                {
                    obj.totalBill();
                    break;
                }
                case 3:
                {
                    System.out.print("Enter a threshold price: ");
                    double threshold_price=input.nextDouble();
                    obj.displayItemAbovePrice(threshold_price);
                    break;
                }
                case 4:
                {
                    System.out.print("Enter product name: ");
                    String name=input.next();
                    obj.serachByName(name);
                    break;
                }
                case 5:
                {
                    System.out.print("Enter product name");
                    String name=input.next();
                    obj.updateValue(name);
                }
                case 6:
                {
                    obj.displayAll();
                    break;
                }
                case 7:
                {
                    System.out.print("1. Sort items by price\n2. Sort items by quantity\n-->");
                    int select=input.nextInt();
                    switch(select)
                    {
                        case 1:
                        {
                           obj.sortByPrice();
                           break;
                        }
    
                        case 2:
                        {
                            obj.sortByQuantity();
                            break;
                        }
                        default:
                        {
                        System.out.print("pls.. select option from '1' and '2'.");
                        break;
                        }
                    }
                    break;
                }
                case 8:
                {
                    obj.expSoon();
                    break;
                }
                case 9:
                {
                    obj.expiredItems();
                    break;
                }
                case 10:
                {
                    obj.totalQuantity();
                    break;
                }
                case 11:
                {
                    System.out.println("Exits....");
                    return;
                }
                default:
                System.out.print("Plss... enter a right choice.");
                break;
            }
        }
    }
}
