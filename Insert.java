public class Insert {
    public static void main(String[] args) {
        Connection conn=null;
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
                 conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-3JDRGG3:1521/xe","oracle","abc");
                 PreparedStatement ps=conn.prepareStatement("Insert into student values(?,?,?) ");
                 Scanner sc=new Scanner(System.in);
                 System.out.print("Enter roll no:");
                 int roll=sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter name:");
                 String name=sc.nextLine();
                 System.out.print("Enter marks:");
                 double marks=sc.nextDouble();
                 ps.setInt(1, roll);
                 ps.setString(2, name);
                 ps.setDouble(3, marks);
                 ps.execute();
                 
                 
                 
                 
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