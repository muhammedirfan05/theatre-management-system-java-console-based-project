package Model;

import java.util.*;

public class Show
{
    // static Scanner sc=new Scanner(System.in);
    private int id;
    private String movieName;
    private String timing;
    private int availableSeats;
    static int show1[][]=new int[5][5];
    static int show2[][]=new int[5][5];

    static int show3[][]=new int[5][5];
    static 
    {
        for(int i=0;i<5;i++)
        {
            Arrays.fill(show1[i],0);
            Arrays.fill(show2[i],0);
            Arrays.fill(show3[i],0);
        }
    }
    public Show(int id,String movieName, String timing,int availableSeats) 
    {
        this.id = id;
        this.movieName = movieName;
        this.timing = timing;
        this.availableSeats=availableSeats;
    }
    public int getid() 
    {
        return id;
    }
    public String getMovieName() 
    {
        return movieName;
    }
    public int getAvail() {
        return availableSeats;
    }
    public String getTiming() 
    {
        return timing;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAvail(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    
    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    public String toString() {
        return " shows - {" +
                "id='" + id + '\'' +
                ", moviename='" + movieName + '\'' +
                ", timing='" + timing + '\'' +
                ", Available seats='" + availableSeats+
                '}';
    }
}