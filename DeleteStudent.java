import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
//Here I use student class to display all the student record which  record get deleted 
class Student
{

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    private String name;
    private int rollno;
    private double marks;

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", rollno=" + rollno + ", marks=" + marks + '}';
    }
    
}
public class DeleteStudent {
    public static void main(String[] args) {
        Connection conn=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            ArrayList<Student>record=new ArrayList<>();
            Student  s=new Student();
            Scanner sc=new Scanner(System.in);
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs=st.executeQuery("Select rollno,marks,name from student");
                while(rs.next())
                {
                    int rolldb=rs.getInt("rollno");
                    String name=rs.getString("name");
                    double marks=rs.getDouble("marks");
                     
                    System.out.print("Do you want to delete record of roll: "+rolldb+"Yes/No:");
                
                    String c=sc.next();
                    if(c.equalsIgnoreCase("Yes"))
                    {
                        rs.deleteRow();
                      s.setName(name);
                       s.setRollno(rolldb);
                       s.setMarks(marks);
                       record.add(s);
 
                        System.out.println("Record deleted");
                        
                    }
                }
                if(record.isEmpty())
                    System.out.println("No record deleted");
                for(Student rec:record)
                {
                    System.out.println("Roll No: "+rec.getRollno()+" Name: "+rec.getName()+" Marks: "+rec.getMarks());
                }
                
                 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                conn.close();
                
            }
            catch(Exception e)
            {
                System.out.println("Error!"+e.getMessage());
            }
        }
    }
}
