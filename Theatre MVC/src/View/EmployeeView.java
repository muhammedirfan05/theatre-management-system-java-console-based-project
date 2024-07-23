package View;
import java.util.*;
public class EmployeeView 
{
    static Scanner sc=new Scanner(System.in);
    public static void menu()
    {
        boolean b=true;
        do
        {
            System.out.println("---------------------------------------");
            System.out.println(" 1.Book tickets \n 2.Display show details \n 3.Show Available foods \n 4.Sell Items \n 5.Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            switch(a)
            {
                case 1:
                    // issueTicket();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("---------------------------------------");
                    System.out.println("  Thanks for using Theatre Services");
                    System.out.println("---------------------------------------");
                    b=false;
                    break;
            }
        }
        while(b);
    } 
}
