package car_parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.Revoke;
import model.RevokeErrorMsgs;

import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RevokeTest {

	Revoke re;
	RevokeErrorMsgs rem;

	@Before
	public void setUp() throws Exception {
		re = new Revoke();
		rem = new RevokeErrorMsgs();

		
	}

	@Test
	@FileParameters("test/Test_Cases.csv")
	public void test(int testcaseNo, String action, String username, String reason, String errorMsg, String user_nameError, String reasonError ) 
	   {	
		re.setRevoke(username,reason);
		re.validateRevoke(action,re,rem);
		assertTrue(user_nameError.equals(rem.getUser_nameError()));
		assertTrue(reasonError.equals(rem.getReasonError()));
		assertTrue(errorMsg.equals(rem.getErrorMsg()));
		}

}
