package mainApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean validate(LoginPojo loginPojo) throws ClassNotFoundException, SQLException {
		String userName = loginPojo.getUserName();
		String password = loginPojo.getPassword();
		
		ConnectionManager cm = new ConnectionManager();
		Statement st = cm.getConnection().createStatement();
		
		ResultSet resultSet = st.executeQuery("Select * from USERDETAILS");
		while(resultSet.next()) {
			if(userName.equals(resultSet.getString("USERNAME"))&& password.equals(resultSet.getString("PASSWORD"))) 
			{
				cm.getConnection().close();
				return true;
			}
			else {
				cm.getConnection().close();
				return false;
			}
			
		}
		return false;
	}

}
