package model;

public class ParkingSpotsErrorMsgs {
	

	private String parking_AreaError;
	private String parking_NumberError;
	private String membership_typeError;
	private String errorMsg;
	
	

	public String getErrorMsg() {
		
		return errorMsg;
	}


	public void setErrorMsg(String action) {
		if(!parking_AreaError.equals("") || !parking_NumberError.equals("") || !membership_typeError.equals("")) 
			this.errorMsg = "Please correct the following errors";
		
	}


	public ParkingSpotsErrorMsgs () {
		this.errorMsg ="";
		this.parking_AreaError="";
		this.parking_NumberError="";
		this.membership_typeError="";
	
	}


	public String getParking_AreaError() {
		return parking_AreaError;
	}

	public void setParking_AreaError(String parking_AreaError) {
		this.parking_AreaError = parking_AreaError;
	}

	public String getParking_NumberError() {
		return parking_NumberError;
	}

	public void setParking_NumberError(String parking_NumberError) {
		this.parking_NumberError = parking_NumberError;
	}

	public String getMembership_typeError() {
		return membership_typeError;
	}

	public void setMembership_typeError(String membership_typeError) {
		this.membership_typeError = membership_typeError;
	}




}
