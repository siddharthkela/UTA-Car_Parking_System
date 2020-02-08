package model;

public class ReservationErrorMsgs {
	
	private String errorMsg;
	private String reservationidError;
	/*private String usernameError;
	private String parking_AreaError;
	private String parking_NumberError;
	private String starttime_hourError;
	private String starttime_minutesError;
	private String endtime_hourError;
	private String endtime_minutesError;
	private String costError;*/
	
	public ReservationErrorMsgs () {
		this.errorMsg="";
		this.reservationidError="";
		/*this.usernameError="";
		this.parking_AreaError="";
		this.parking_NumberError="";
		this.starttime_hourError="";
		this.starttime_minutesError="";
		this.endtime_hourError="";
		this.endtime_minutesError="";
		this.costError="";*/
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String action) {
		
		if (!reservationidError.equals("")){
			this.errorMsg="Please correct the following errors";
		}	
	}

	public String getReservationidError() {
		return reservationidError;
	}

	public void setReservationidError(String reservationidError) {
		this.reservationidError = reservationidError;
	}

	/*public String getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
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

	public String getStarttime_hourError() {
		return starttime_hourError;
	}

	public void setStarttime_hourError(String starttime_hourError) {
		this.starttime_hourError = starttime_hourError;
	}

	public String getStarttime_minutesError() {
		return starttime_minutesError;
	}

	public void setStarttime_minutesError(String starttime_minutesError) {
		this.starttime_minutesError = starttime_minutesError;
	}

	public String getEndtime_hourError() {
		return endtime_hourError;
	}

	public void setEndtime_hourError(String endtime_hourError) {
		this.endtime_hourError = endtime_hourError;
	}

	public String getEndtime_minutesError() {
		return endtime_minutesError;
	}

	public void setEndtime_minutesError(String endtime_minutesError) {
		this.endtime_minutesError = endtime_minutesError;
	}

	public String getCostError() {
		return costError;
	}

	public void setCostError(String costError) {
		this.costError = costError;
	}*/

	
	

}
