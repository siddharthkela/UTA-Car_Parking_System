package model;

import java.io.Serializable;
import java.util.ArrayList;

import data.UserDaoImple;
import model.Login;
import model.LoginErrorMsgs;

public class Login implements Serializable{
	private static final long serialVersionUID = 3L;
	private String username = ""; 
	private String password = "";
	
	public void setLogin (String username, String password) {
		setUsername(username);
		setPassword(password);
	} 

	public String getPassword() {
		return password; 
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) { 
		this.username = username;
	}
	
	public void validateLogin(String action, Login login, LoginErrorMsgs lerrorMsgs) {
		if(action.equals("loginUser")) {
			lerrorMsgs.setUserNameError(validateUser_name(login.getUsername()));
			lerrorMsgs.setPasswordError(validatePassword(login.getPassword()));
			lerrorMsgs.setErrorMsg(action);
		}
	} 
	 
	public String validateUser_name(String username) {
		
		String result = "";
		if(username.equals(""))
		{
			result = "Username cannot be Null";
		}
		else{
		ArrayList<USER> UserInDB = new ArrayList<USER>();
		username = username.trim();
		UserInDB=UserDaoImple.getUserByuserName(username);
		if(UserInDB.isEmpty()){
			result = "Username does not exist";
		}
		}
		return result;
	}
	
	public String validatePassword(String password) {
		String result = "";
		if(password.equals(""))
		{
			result = "Password cannot be Null";
		}
		else{
		ArrayList<USER> UserInDB = new ArrayList<USER>();
		password = password.trim();
		UserInDB=UserDaoImple.getUserByPassword(password);
		if(UserInDB.isEmpty()){ 
			result = "Invalid password";
		}
		}
		return result;
	}	

}
