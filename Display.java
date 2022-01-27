import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class Display {
    public static void main(String[] args) {
        
    Connection conn=null;
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 
                 Statement st=conn.createStatement();
                 ResultSet rs=st.executeQuery("Select * from students");
                 while(rs.next())
                 {
                     int roll=rs.getInt("roll_no");
                     String name=rs.getString("name");
                     int marks=rs.getInt("marks");
                     System.out.print("Roll No: "+roll);
                     System.out.print(" Name: "+name);
                     System.out.println(" Marks: "+marks);

                     
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
