import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class onestudentdetail {
    public static void main(String[] args) {
        Connection conn=null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from student");
        Scanner sc=new Scanner(System.in);
            System.out.print("Enter roll no of student which record you want to get:");
        int roll=sc.nextInt();
        while(rs.next())
        {
            int rolldb=rs.getInt("rollno");
            if(rolldb==roll)
            {
                String name=rs.getString("name");
                Double marks=rs.getDouble("marks");
                System.out.println("Roll: "+roll+" Marks"+marks+" Name: "+name);
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
