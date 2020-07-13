package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
	
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:oracle:thin:system/Amudhan.123@localhost:1521:orcle");
		if(con!=null) {
			System.out.println("Established");
		}
		return con;
	}
}
