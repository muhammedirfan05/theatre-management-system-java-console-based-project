package Model;

import java.io.EOFException;
// import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowFunction 
{
    public static boolean addShow(String name,String time) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "INSERT INTO shows VALUES (?, ?)");) 
        {
            statement.setString(1, name);
            statement.setString(2, time);
            // Execute the SQL INSERT statement
            int rowsInserted = statement.executeUpdate();
            // Check if the insertion was successful
            if (rowsInserted > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
    }
    public static boolean removeShow(int id) throws Exception
    {
        try (PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "DELETE FROM shows WHERE id = ?")) 
        {
            statement.setInt(1, id);
            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();
            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB ERROR");
        }
    }
    public static List<Show> viewAllShow()
    {
        List<Show> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM shows");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("movie_name");
                String time = resultSet.getString("timing");
                int availableseats = resultSet.getInt("availability_seats");
                st.add(new Show(id,name,time,availableseats));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
     public static boolean changeTimings(int id,String time) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "UPDATE shows SET timing = ? WHERE id = ? ")) 
        {
            statement.setString(1, time);
            statement.setInt(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
    }
    public static boolean changeMovieName(int id,String c) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "UPDATE shows SET moviename = ? WHERE id = ? ")) 
        {
            statement.setString(1, c);
            statement.setInt(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
    }
    public static boolean updateAvailableSeats(int userseat, int showId) throws Exception 
    {
        String sqlSelect = "SELECT availability_seats FROM shows WHERE id = ?";
        String sqlUpdate = "UPDATE shows SET availability_seats = availability_seats - ? WHERE id = ?";
        
        int availableSeats;
        try (
             PreparedStatement selectStatement = DBconnectivity.getConnection().prepareStatement(sqlSelect);
             PreparedStatement updateStatement = DBconnectivity.getConnection().prepareStatement(sqlUpdate)) {
            selectStatement.setInt(1, showId);
            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    availableSeats = resultSet.getInt("availability_seats");
                    
                } else {
                    throw new SQLException("Show with id " + showId + " not found.");
                }
            }
            if (availableSeats < userseat) {
                throw new Exception("there is no available tickets for your availability " + showId);
            }
            else if(availableSeats==0)
            throw new Exception("House is full for show with id " + showId);
            
            // Update the available seats count
            updateStatement.setInt(1, userseat);
            updateStatement.setInt(2, showId);
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected>0;
        }
    }
}
