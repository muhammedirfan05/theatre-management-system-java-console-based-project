package Model;
public class Employee 
{
    private int id;
    private String email;
    private String name;
    private int age;
    private String designation;
    public Employee(int id,String email, String name,int age, String designation) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.age = age;
    }
    public int getId()
    {
        return id;
    }
    public String getEmail() 
    {
        return email;
    }
    public String getName() 
    {
        return name;
    }
    public String getDesignation() 
    {
        return designation;
    }
    public int getAge() 
    {
        return age;
    }
    @Override
    public String toString() {
        return " Employees - {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Age=" + age +
                ", designation=" + designation +
                '}';
    }
}
