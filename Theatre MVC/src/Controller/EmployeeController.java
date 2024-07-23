package Controller;
// import java.io.EOFException;
import java.util.List;

import Model.*;
import View.*;

public class EmployeeController 
{
    public static void chooseDesignation(String email)
    {
        try
        {
            String des=EmployeeFunction.getDesignation(email);
            if(des.equals("Manager"))
                ManagerView.menu();
            else
                EmployeeView.menu();
        }
        catch(Exception e)
        {
            System.out.println("Erroe Occured");
        }
    }
    public static List<Employee> viewAllStaffs()
    {
        List<Employee> st =EmployeeFunction.viewAllStaffs();
        return st;
    }
    public static Employee searchStaff(int id) throws Exception
    {
        try
        {
            Employee em=EmployeeFunction.searchStaff(id);
            return em;
        }
        catch(Exception e)
        {
            throw new Exception("Error during searching");
        }
    } 
    public static boolean removeStaff(int id) throws Exception
    {
        boolean b=EmployeeFunction.removeStaff(id);
        return b;
    }
    public static boolean removeManager(int id) throws Exception
    {
        boolean b=EmployeeFunction.removeManager(id);
        return b;
    }
    // boolean bt=EmployeeController.addEmployee(id,email,name,age,designation);
    public static boolean addEmployee(String email,String name,int age,String designation) throws Exception
    {
        boolean b=EmployeeFunction.addStaff(email,name,age,designation);
        return b;
    }
}
