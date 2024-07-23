package View;

import java.util.List;
import java.util.Scanner;

import Controller.ShowController;
import Model.Show;
// import Model.ShowFunction;

public class CustomerView 
{
    
    public static void menu()
    {
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        do
        {
            System.out.println(" 1.Book Tickets \n 2.Buy Snacks \n 3.Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            switch(a)
            {
                case 1:
                    List<Show> sList = ShowController.viewAllShows();
                    if (!sList.isEmpty()) 
                    {
                        System.out.println("---------------------------------------");
                        System.out.println("        List of Shows:");
                        System.out.println("---------------------------------------");
                        for (Show ve : sList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Shows for today");
                    System.out.print("Enter show id: ");
                    int id=sc.nextInt();
                    System.out.print("Enter how many tickets do you need: ");
                    int n=sc.nextInt();
                    try
                    {
                        if(ShowController.updateAvailableSeats(n,id)) 
                        {
                            System.out.println("---------------------------------------");
                            System.out.println("-------------Ticket booked-------------");
                            System.out.println("---------------------------------------");
                        }
                        else    System.out.println("Error during booking");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error during booking1");
                    }
                    // TicketAgent.issueTicket();
                    break;
                case 2:
                //     FoodCourtAgent.displayFoods();
                //     FoodCourtAgent.sellFoods();
                    break;
                case 3:
                    System.out.println("---------------------------------------");
                    System.out.println("  Thanks for using Theatre Services");
                    System.out.println("---------------------------------------");
                    b=false;
                    break;
            }
        }
        while(b);
        sc.close();
    }
}
