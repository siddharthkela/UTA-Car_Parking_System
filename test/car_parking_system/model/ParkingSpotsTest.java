package car_parking_system.model;


import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.ParkingSpots;
import model.ParkingSpotsErrorMsgs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class ParkingSpotsTest {
	
	ParkingSpots pk;
	ParkingSpotsErrorMsgs pkr;

	@Before
	public void setUp() throws Exception { 
		
		pk = new ParkingSpots();
		pkr = new ParkingSpotsErrorMsgs(); 
	}

	@Test
	@FileParameters("test/ParkingSpotsTestCases.csv")
	public void test(int testcaseNo,String action,String parking_Area, String parking_Number,String membership_type,String error,String parking_AreaError,String parking_NumberError,String membership_typeError) {
		
		pk.setParkingSpots(parking_Area, parking_Number, membership_type);
		pk.validateParkingSpots(action, pk, pkr);
		assertEquals(error,pkr.getErrorMsg());
		assertEquals(parking_AreaError,pkr.getParking_AreaError());
		assertEquals(parking_NumberError,pkr.getParking_NumberError());
		assertEquals(membership_typeError,pkr.getMembership_typeError());
	
		
	}

}
