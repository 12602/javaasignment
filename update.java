import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
//Here I use student class to display all the student record which  record get updated 
class Student1
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
/**
 *
 * @author LENOVO
 */
public class update {
    public static void main(String[] args) {
                
    Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 Scanner sc=new Scanner(System.in);
        Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("Select rollno,marks,name from student ");

        int count=0;
        Student1 s=new Student1();
        ArrayList<Student1>list=new ArrayList<>();
        while(rs.next())
        {
      int roll=rs.getInt("rollno");
      String name=rs.getString("name");
      double marks1=rs.getDouble("marks");
            System.out.print("Do you want to update marks of student roll:"+roll+"[Yes/No]: ");
            String ch=sc.next();
            if(ch.equalsIgnoreCase("Yes"))
            {
                      
                System.out.print("Enter new marks: ");
               double marks=sc.nextDouble();
                rs.updateDouble(2,marks);
               rs.updateRow();
                 count++;
                 s.setMarks(marks);
                 s.setName(name);
                 s.setRollno(roll);
                 list.add(s);
            }
            
           }
        if(list.isEmpty())
                System.out.println("No record updated");
        else
        {
            for(Student1 student:list)
            {
                System.out.println("Name: "+student.getName()+" Roll: "+student.getRollno()+" Marks: "+student.getMarks());
            }
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