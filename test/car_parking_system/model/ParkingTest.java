package car_parking_system.model;

import static org.junit.Assert.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import model.Parking;
import model.ParkingErrorMsgs;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ParkingTest {
	
	
	Parking pk;
	ParkingErrorMsgs pkr;

	@Before
	public void setUp() throws Exception {
		
		pk = new Parking();
		pkr = new ParkingErrorMsgs();
	}

	@Test
	@FileParameters("test/TestCases.csv")
	public void test(int testcaseNo, String action, String parking_area, String capacity,String floor, String type, String cart, String camera, String history, String errorMsg, String parking_areaError,String capacityError,String floorError,String typeError,String cartError,String cameraError,String historyError) {
	
		pk.setParking(parking_area,capacity,floor,type,cart,camera,history);
		pk.validateParking(action,pk,pkr);
		assertTrue(errorMsg.equals(pkr.getErrorMsg()));
		assertTrue(parking_areaError.equals(pkr.getParking_areaError()));
		assertTrue(capacityError.equals(pkr.getCapacityError()));
		assertTrue(floorError.equals(pkr.getFloorError()));
		assertTrue(typeError.equals(pkr.getTypeError()));
		assertTrue(cartError.equals(pkr.getCartError()));
		assertTrue(cameraError.equals(pkr.getCameraError()));
		assertTrue(historyError.equals(pkr.getHistoryError()));
	}

}
