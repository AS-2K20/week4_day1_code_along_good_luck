package mainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		System.out.println(" 1. Register ");
		System.out.println(" 2. Login ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans; 
		ans = Integer.parseInt(br.readLine());
		//crating object
		RegisterPojo registerPojo = new RegisterPojo();
		RegisterDAO registerDao = new RegisterDAO();
		LoginPojo loginPojo = new LoginPojo();
		LoginDAO loginDao = new LoginDAO();
		switch(ans) {
		case 1:
			System.out.println(" Enter Your First Name: ");
			String firstName = br.readLine();
			System.out.println(" Enter Your Last Name: ");
			String lastName = br.readLine();
			System.out.println(" Enter Your User Name: ");
			String userName = br.readLine();
			System.out.println(" Enter Your Password: ");
			String password = br.readLine();
			System.out.println(" Enter Your Email: ");
			String email = br.readLine();
			
			registerPojo.setFirstName(firstName);
			registerPojo.setLastName(lastName);
			registerPojo.setUserName(userName);
			registerPojo.setEmail(email);
			registerPojo.setPassword(password);
			
			registerDao.addUser(registerPojo);
			break;
		case 2:
			System.out.println(" Enter Your User Name: ");
			String name = br.readLine();
			System.out.println(" Enter Your Password: ");
			String pass = br.readLine();
			loginPojo.setUserName(name);
			loginPojo.setPassword(pass);
			
			if(loginDao.validate(loginPojo)==true) {
				Luck luck = new Luck();
				luck.display();
			}
			else {
				System.out.println("Incorrect Username or Password");
			}
			break;
		}
	}

}
