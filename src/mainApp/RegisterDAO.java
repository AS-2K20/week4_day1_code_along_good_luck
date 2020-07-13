package mainApp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void addUser(RegisterPojo registerPojo) throws ClassNotFoundException, SQLException {
	String firstName = registerPojo.getFirstName();
	String lastName = registerPojo.getLastName();
	String userName = registerPojo.getUserName();
	String password = registerPojo.getPassword();
	String email = registerPojo.getEmail();
	
	ConnectionManager cm = new ConnectionManager();
	//insert all the details into database
	String sql = "insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
	//CREATE STATEMENT OBJECT
	PreparedStatement st = cm.getConnection().prepareStatement(sql);
	st.setString(1, firstName);
	st.setString(2, lastName);
	st.setString(3, userName);
	st.setString(4, password);
	st.setString(5, email);
	
	st.executeUpdate();
	cm.getConnection().close();
	}
}
