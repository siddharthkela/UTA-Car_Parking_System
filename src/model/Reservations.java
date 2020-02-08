package model;

import java.io.Serializable;

public class Reservations implements Serializable{
	
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
	
	
	public void setReservations (String reservationid, String username,String parking_Area, String parking_Number,String starttime_hour,String starttime_minutes,String endtime_hour,String endtime_minutes,String cost) {
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

}
