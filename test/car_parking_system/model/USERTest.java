package car_parking_system.model;

import static org.junit.Assert.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.USER;
import model.AdminErrorMSGS;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class USERTest {
	
	USER us;
	AdminErrorMSGS adm;
	
	@Before
	public void setUp() throws Exception {
		
		us = new USER();
		adm = new AdminErrorMSGS();
	}

	@Test
	@FileParameters("test/SearchUser.csv")
	public void test(int testcaseNo, String action, String username, String password,String firstname, String lastname,  String role, String phone, String email,String address, String parkingpermittype, String vehiclenumber,String licensenumber, String DateofBirth, String errorMsg, String user_nameError, String passwordError, String firstnameError, String lastnameError, String roleError,String phoneError,String emailError,String addressError,String parkingpermittypeError,String vehiclenumberError,String licensenumberError,String dobError){
	
		us.setUSER(username, password, firstname, lastname, role, phone, email, address, parkingpermittype, vehiclenumber, licensenumber, DateofBirth);
		us.validateUSER(action,us,adm);
		/*assertTrue(errorMsg.equals(adm.getErrorMsg()));*/
		//assertTrue(user_nameError.equals(adm.getUser_nameError()));
		assertEquals(user_nameError,adm.getUser_nameError());
		assertEquals(passwordError,adm.getPasswordError());
		assertEquals(firstnameError,adm.getFirstnameError());
		assertEquals(lastnameError,adm.getLastnameError());
		assertEquals(roleError,adm.getRoleError());
		assertEquals(phoneError,adm.getPhoneError());
		assertEquals(emailError,adm.getEmailError());
		assertEquals(addressError,adm.getAddressError());
		assertEquals(parkingpermittypeError,adm.getParkingpermittypeError());
		assertEquals(vehiclenumberError,adm.getVehiclenumberError());
		assertEquals(licensenumberError,adm.getLicensenumberError());
		assertEquals(dobError,adm.getDobError());
	}

}
