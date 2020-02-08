package car_parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.Login;
import model.LoginErrorMsgs;

@RunWith(JUnitParamsRunner.class)
public class LoginTest 
{
	LoginErrorMsgs lerrorm;
	Login login; 
	@Before
	public void setUp() throws Exception {
		lerrorm=new LoginErrorMsgs();
		login= new Login();
	} 

	@Test
	@FileParameters("test/login.csv")
	public void test(	int testcaseNo, String action, String username, String password, String errorMsg,    
						String userNameError,    String passwordError) {
		
		login.setLogin(username, password); 
		login.validateLogin(action, login, lerrorm);
		assertEquals(errorMsg,lerrorm.getErrorMsg());
		assertEquals(userNameError,lerrorm.getUserNameError());
		assertEquals(passwordError,lerrorm.getPasswordError());
		/*assertTrue(errorMsg.equals(lerrorm.getErrorMsg()));
		assertTrue(userNameError.equals(lerrorm.getUserNameError()));
		assertTrue(passwordError.equals(lerrorm.getPasswordError()));*/
	}
}


