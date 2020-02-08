package model;

import java.io.Serializable;

public class ParkingSpots implements Serializable{
	
	private static final long serialVersionUID = 3L;
	private String parking_Area = "";
	private String parking_Number= "";
	private String membership_type = "";
	
	
	public void setParkingSpots (String parking_Area, String parking_Number,String membership_type) {
		setParking_Area(parking_Area);
		setParking_Number(parking_Number);
		setMembership_type(membership_type);
	
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

	public String getMembership_type() {
		return membership_type;
	}

	public void setMembership_type(String membership_type) {
		this.membership_type = membership_type;
	}
	

	public void validateParkingSpots (String action, ParkingSpots parkingspots, ParkingSpotsErrorMsgs pserrorMsgs){
		
		if (action.equals("setStatus")) {
			pserrorMsgs.setParking_AreaError(validateParking_Area(parkingspots.getParking_Area()));
			pserrorMsgs.setParking_NumberError(validateParking_Number(parkingspots.getParking_Number()));
			pserrorMsgs.setMembership_typeError(validateMembership_type(parkingspots.getMembership_type()));
			pserrorMsgs.setErrorMsg(action);
		} 
	}
	
	private String validateParking_Area(String parking_Area) {
		String result="";
		if(parking_Area.equals("")){
			result = "Parking Area cannot be blank";
		}
		return result;		
	}
	
	private String validateParking_Number(String parking_Number) {
		String result = "";
		parking_Number = parking_Number.trim();
		if(parking_Number.equals("")){
			result = "Parking Number cannot be blank";
		}
		else
			if (!isTextAnInteger(parking_Number))
				result="Parking Number must be a number";
		return result;
	}
	
	private String validateMembership_type(String membership_type){
		String result = "";
		if (!membership_type.equals("basic") && !membership_type.equals("premium") && !membership_type.equals("midrange") 
				&& !membership_type.equals("access")){
			result = "Parking Type should be one of Basic Premium Midrange Access";
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
