package View;
import java.util.*;
import Model.*;
import Controller.EmployeeController;
import Controller.UserController;

public class ManagerView 
{
    // static Scanner sc=new Scanner(System.in);
    public static void menu()
    {
        Scanner sc=new Scanner(System.in);
        boolean b=true;
        do
        {
            System.out.println("---------------------------------------");
            System.out.println("           WELCOME MANAGER             : ");
            System.out.println("---------------------------------------");
            System.out.println(" 1.View List of all Staff \n 2.Search a Staff with their ID \n 3.Add Staff \n 4.Remove Staff \n 5.Exit");
            System.out.println("---------------------------------------");
            System.out.print("Enter service : ");
            int a = sc.nextInt();
            sc.nextLine();
            switch(a)
            {
                case 1:
                    List<Employee> staffsList = EmployeeController.viewAllStaffs();;
                    if (!staffsList.isEmpty()) 
                    {
                        System.out.println("---------------------------------------");
                        System.out.println("        List of Staffs:");
                        System.out.println("---------------------------------------");
                        for (Employee ve : staffsList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Staffs found.");
                    break;
                case 2:
                    System.out.print("Enter the Staff ID: ");
                    int id =sc.nextInt();
                    try
                    {
                        Employee emp1 = EmployeeController.searchStaff(id);
                        System.out.println("---------------------------------------");
                        if (emp1 != null)
                        {
                            System.out.println("Staff Found: ");
                            System.out.println(emp1);
                        } 
                        else
                            System.out.println("No matching Staff found.");
                        // emp.searchStaff(id); 
                    }
                    catch(Exception e)
                    {
                        System.out.println("no data found");
                    }
                    break;
                case 3:
                    System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    // System.out.print("Enter designation: ");
                    // String designation = sc.next();
                    System.out.print("Enter your Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    try
                    {
                        boolean uc=UserController.addUser(email, password,"employee");
                        boolean bt=EmployeeController.addEmployee(email,name,age,"Staff");
                        if(bt&&uc)   System.out.println("A new staff has been inserted into the database.");
                        else System.out.println("Failed to insert staff into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert staff into the database.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the staff ID to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the staff email to delete: ");
                    String email1 = sc.next();
                    try
                    {
                        boolean ad=EmployeeController.removeStaff(idToDelete);
                        boolean uc=UserController.removeUser(email1);
                        if(ad&&uc)  System.out.println("staff has been removed from the database.");
                        else    
                        System.out.println("Failed to remove staff from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove staff from the database.");
                    }
                    break;
                case 5:
                    System.out.println("---------------------------------------");
                    System.out.println("  Thanks for using Theatre Services");
                    System.out.println("---------------------------------------");
                    b=false;
            }
        }
        while(b);
        sc.close();
    }
}
