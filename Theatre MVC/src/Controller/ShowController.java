package Controller;

import java.util.List;

import Model.*;

public class ShowController
{
    public static boolean addShow(String name,String time) throws Exception
    {
        try
        {
            boolean b=ShowFunction.addShow(name,time);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }
    public static boolean removeShow(int idToDelete) throws Exception
    {
        try
        {
            boolean b=ShowFunction.removeShow(idToDelete);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }
    public static List<Show> viewAllShows()
    {
        List<Show> st =ShowFunction.viewAllShow();
        return st;
    }
    public static boolean changeTimings(int a,String c) throws Exception
    {
        try
        {
            boolean b=ShowFunction.changeTimings(a,c);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }
    public static boolean changeMovieName(int a,String c) throws Exception
    {
        try
        {
            boolean b=ShowFunction.changeMovieName(a,c);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Insertion");
        }
    }
    public static boolean updateAvailableSeats(int n,int id) throws Exception
    {
        try{
            if(ShowFunction.updateAvailableSeats(n,id)) return true;
            else    return false;
            }
            catch(Exception e)
            {
                throw new Exception("Error During Booking");
            }
    } 
    
    
}