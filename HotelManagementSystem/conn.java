package HotelManagementSystem;
import java.util.*;
import java.sql.*;
public class conn {
	Scanner sc=new Scanner(System.in);
	Connection c;
	Statement s;
          public conn() {
        		
        	  
          
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String uname="system";
		String pass="system";
		
		//Step 2:Connection to db
	     c=DriverManager.getConnection(url,uname,pass);
		
		s=c.createStatement();
	/*PreparedStatement pstat=con.prepareStatement("insert into login values(?,?)");
	System.out.println("enter Username");
	pstat.setString(1,sc.next());
	System.out.println("Enter Password");
	pstat.setString(2, sc.next());*/
	
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
        
          }}
