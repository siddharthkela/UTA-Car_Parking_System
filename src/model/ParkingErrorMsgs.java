package model;
public class ParkingErrorMsgs {
	
	private String errorMsg;
	private String parking_areaError;
	private String capacityError;
	private String floorError;
	private String typeError;
	private String cartError;
	private String cameraError;
	private String historyError;

	public ParkingErrorMsgs () {
		this.errorMsg="";
		this.parking_areaError="";
		this.capacityError="";
		this.floorError="";
		this.typeError="";
		this.cartError="";
		this.cameraError="";
		this.historyError="";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String action) {
			if (!parking_areaError.equals("") || !capacityError.equals("") || !floorError.equals("") || !typeError.equals("") || !cartError.equals("") || !cameraError.equals("") || !historyError.equals(""))
				this.errorMsg="Please correct the following errors";
		
		
						
	}

	public String getParking_areaError() {
		return parking_areaError;
	}

	public void setParking_areaError(String parking_areaError) {
		this.parking_areaError = parking_areaError;
	}

	public String getCapacityError() {
		return capacityError;
	}

	public void setCapacityError(String capacityError) {
		this.capacityError = capacityError;
	}

	public String getFloorError() {
		return floorError;
	}

	public void setFloorError(String floorError) {
		this.floorError = floorError;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getCartError() {
		return cartError;
	}

	public void setCartError(String cartError) {
		this.cartError = cartError;
	}

	public String getCameraError() {
		return cameraError;
	}

	public void setCameraError(String cameraError) {
		this.cameraError = cameraError;
	}

	public String getHistoryError() {
		return historyError;
	}

	public void setHistoryError(String historyError) {
		this.historyError = historyError;
	}
	
	


}
