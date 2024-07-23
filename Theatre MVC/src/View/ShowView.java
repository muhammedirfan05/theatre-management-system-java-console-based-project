package View;
import java.util.*;
import Controller.*;
import Model.Show;
// import Model.ShowFunction;
public class ShowView
{
    static Scanner sc=new Scanner("System.in");
    public static void modifyShow()
    {
        boolean b=true;
        do
        {
            System.out.println("---------------------------------------");
            System.out.println(" 1.Update Shows \n 2.Add Shows \n 3.Remove shows \n 4.View All Shows  \n 5.Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter choice : ");
            int a = sc.nextInt();
            switch (a) 
            {
                case 1:
                    updateShow();
                    break;
                case 2:
                    System.out.print("Enter Movie Name : ");
                    String name = sc.next();
                    System.out.print("Enter Timing  : ");
                    String time = sc.next();
                    try{
                        if(ShowController.addShow(name,time))
                            System.out.println("Show has been added");
                        else
                            System.out.println("Error during adding show");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error during adding show");
                    }
                    break;
                case 3:
                    System.out.print("Enter the show ID to delete: ");
                    int idToDelete = sc.nextInt();
                    try
                    {
                        if(ShowController.removeShow(idToDelete))  
                        System.out.println("show has been removed from the database.");
                        else    
                        System.out.println("Failed to remove show from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove showe from the database.");
                    }
                    break;
                case 4:
                    List<Show> sList = ShowController.viewAllShows();;
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
                    break;
                case 5:
                    b=false;
                    System.out.println("---------------------------------------");
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
        while(b);
    }
    public static void updateShow()
    {
        System.out.println("---------------------------------------");
        System.out.println("  What Do You Want to change   ");
        System.out.println(" 1.change Show Timing \n 2.change moviename ");
        System.out.println("---------------------------------------");
        System.out.print("Enter choice : ");
        int a=sc.nextInt();
        if(a==1)
            changeTiming();   
        else if(a==2)
            changeMovieName();
        else
            System.out.println("Enter a valid choice");
    }
     public static void changeTiming()
    {
        System.out.print("Enter the Show Id : ");
        int a=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the Show Timing you need to change [hr:min AM/PM] : ");
        String c=sc.nextLine();
        try
        {
            if(ShowController.changeTimings(a,c))
                System.out.println("Show has been updated");
            else    System.out.println("Error during updation");
        }
        catch(Exception e)
        {
            System.out.println("Error during updation");
        }
    }
    public static void changeMovieName()
    {
        System.out.print("Enter the Show Id : ");
        int a=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the movie name you need to change : ");
        String c=sc.nextLine();
        try
        {
            if(ShowController.changeMovieName(a,c))
                System.out.println("Show has been updated");
            else    System.out.println("Error during updation");
        }
        catch(Exception e)
        {
            System.out.println("Error during updation");
        }
    }
}