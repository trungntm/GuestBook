package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AddCommentDAO {
	public void themComment(String Name, String Message) throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=GuestBook;user=login;password=12345678";
		Connection conn=null;
		PreparedStatement cstmt=null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(dbURL);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return;
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String sql= "{call dbo.spInsertComment(?,?)}";
			cstmt=conn.prepareStatement(sql);
	
			cstmt.setString(1,Name);
			cstmt.setString(2, Message);
			
			
			int temp = cstmt.executeUpdate();
			
			cstmt.close();
			conn.close();
	}
}
