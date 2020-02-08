package car_parking_system.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

import model.Reservation;
import model.ReservationErrorMsgs;

@RunWith(JUnitParamsRunner.class)
public class ReservationTest {
	
	Reservation res;
	ReservationErrorMsgs resr;

	@Before
	public void setUp() throws Exception {
		
		res = new Reservation();
		resr = new ReservationErrorMsgs();
	}

	
	@Test
	@FileParameters("test/ReservationTestCases.csv")
	public void test(int testcaseNo,String action,String reservationid, String username,String parking_Area, String parking_Number,String starttime_hour,String starttime_minutes,String endtime_hour,String endtime_minutes,String cost,
		String errorMsg,String reservationidError) {
		res.setReservation(reservationid, username, parking_Area, parking_Number, starttime_hour, starttime_minutes, endtime_hour, endtime_minutes, cost);
		res.validateReservation(action, res, resr);
		assertTrue(reservationidError.equals(resr.getReservationidError()));
		assertTrue(errorMsg.equals(resr.getErrorMsg()));

	} 

}
