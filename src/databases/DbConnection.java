package databases;
import java.sql.*;
public class DbConnection {
	private Connection conn;
	private static final String CONN = "jdbc:mysql://localhost/siterfs?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public DbConnection(){
		this.setConn();
	}
	
	public Connection getConn() {
		if(conn == null){
			this.setConn();
		}
		return conn;
	}
	
	private void setConn(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection(CONN, USER, PASS);
		}catch(Exception e){
			throw new RuntimeException(e);
		}	
	}	
}
