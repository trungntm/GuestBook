package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.GuestBookEntry;


public class GuestBookDAO {
	public static List<GuestBookEntry> getMessage() throws SQLException
	{
		String dbURL = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=GuestBook;integratedSecurity=true";  

		      // Declare the JDBC objects.  
		      Connection conn = null;  
		      Statement st	 = null;  
		      ResultSet rs = null;  
		      String url = "jdbc:sqlserver://localhost:1433;databaseName=GuestBook";
		      String user = "login";
		      String password = "12345678";
		      String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		int ID;
		String Name;	
		String Mess;
		try {
			 Class.forName(driverClass);
			 conn=DriverManager.getConnection(url,user,password);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return null;
	        } catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			String sql= "select * from Guest";
			 st = conn.createStatement();

			 rs = st.executeQuery(sql);
			
			List<GuestBookEntry> dsGuestBook= new ArrayList<GuestBookEntry>();
			while(rs.next()) {
				ID=rs.getInt("ID");
				Name=rs.getString("Name");
				Mess = rs.getString("Message");
				dsGuestBook.add(new GuestBookEntry(Name,Mess,ID));			
			}			
			
			 try {
				    if (conn != null) {
				      conn.close();
				    }
				    if (st != null) {
				     st.close();
				    }
				    if (rs != null) {
				     rs.close();
				    }
				   } catch (Exception ex) {
				     ex.printStackTrace();
				   }
			
			return dsGuestBook; 
	}
}
