package Controller;

import java.util.List;

import Model.Employee;
import Model.EmployeeFunction;

public class AdminController 
{
    public static List<Employee> viewAllEmployees()
    {
        List<Employee> st =EmployeeFunction.viewAllEmployees();
        return st;
    }
    public static Employee searchEmployee(int id) throws Exception
    {
        try
        {
            Employee em=EmployeeFunction.searchEmployee(id);
            return em;
        }
        catch(Exception e)
        {
            throw new Exception("Error during Searching");
        }
    } 
}
