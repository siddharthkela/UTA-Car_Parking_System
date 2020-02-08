package model;

import java.io.Serializable;
import java.util.ArrayList;

import data.ReservationDAO;
import data.UserDaoImple;

public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 3L;
	private String reservationid = "";
	private String username = "";
	private String parking_Area = "";
	private String parking_Number = "";
	private String starttime_hour = "";
	private String starttime_minutes = "";
	private String endtime_hour="";
	private String endtime_minutes="";
	private String cost="";
	
	public void setReservation (String reservationid, String username,String parking_Area, String parking_Number,String starttime_hour,String starttime_minutes,String endtime_hour,String endtime_minutes,String cost) {
		setReservationid(reservationid);
		setUsername(username);
		setParking_Area(parking_Area);
		setParking_Number(parking_Number);
		setStarttime_hour(starttime_hour);
		setStarttime_minutes(starttime_minutes);
		setEndtime_hour(endtime_hour);
		setEndtime_minutes(endtime_minutes);
		setCost(cost);
		
	}

	public String getReservationid() {
		return reservationid;
	}

	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getParking_Area() {
		return parking_Area;
	}

	public void setParking_Area(String parking_Area) {
		this.parking_Area = parking_Area;
	}

	public String getParking_Number() {
		return parking_Number;
	}

	public void setParking_Number(String parking_Number) {
		this.parking_Number = parking_Number;
	}

	public String getStarttime_hour() {
		return starttime_hour;
	}

	public void setStarttime_hour(String starttime_hour) {
		this.starttime_hour = starttime_hour;
	}

	public String getStarttime_minutes() {
		return starttime_minutes;
	}

	public void setStarttime_minutes(String starttime_minutes) {
		this.starttime_minutes = starttime_minutes;
	}

	public String getEndtime_hour() {
		return endtime_hour;
	}

	public void setEndtime_hour(String endtime_hour) {
		this.endtime_hour = endtime_hour;
	}

	public String getEndtime_minutes() {
		return endtime_minutes;
	}

	public void setEndtime_minutes(String endtime_minutes) {
		this.endtime_minutes = endtime_minutes;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public void validateReservation (String action, Reservation reservation, ReservationErrorMsgs RerrorMsgs) {
		if (action.equals("searchReservation")) {
			
			RerrorMsgs.setReservationidError(validateReservationid(reservation.getReservationid()));
			RerrorMsgs.setErrorMsg(action);
			/*if (reservationid.equals("")) 
				RerrorMsgs.setReservationidError("Reservation ID cannot be blank");
			else
				RerrorMsgs.setReservationidError(validateReservationid(action, reservationid));
			RerrorMsgs.setErrorMsg(action);*/				
		}
	}
	
	private String validateReservationid(String reservationid) {
		String result="";
		if(reservationid.equals("")){
			result = "Reservation ID cannot be blank";
		}
		else{
		if (!isTextAnInteger(reservationid))
			result="Reservation ID must be a number";
		else{
			ArrayList<Reservation> ReservationInDB = new ArrayList<Reservation>();
			reservationid = reservationid.trim();
			ReservationInDB=ReservationDAO.listReservation(reservationid);
			if(ReservationInDB.isEmpty()){
				result = "Reservation does not exist";
			}
		}
		}
		
		return result;
	}
	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}

}
