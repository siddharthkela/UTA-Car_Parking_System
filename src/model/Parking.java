package model;
import java.io.Serializable;
import model.ParkingErrorMsgs;

public class Parking implements Serializable{
	private static final long serialVersionUID = 3L;
	private String parking_area = "";
	private String capacity = "";
	private String floor = "";
	private String type = "";
	private String cart = "";
	private String camera = "";
	private String history = ""; 

	public void setParking (String parking_area, String capacity,String floor, String type, String cart, String camera, String history) {
		setParking_area(parking_area);
		setCapacity(capacity);
		setFloor(floor);
		setType(type);
		setCart(cart);
		setCamera(camera);
		setHistory(history);
	} 

	public String getParking_area() {
		return parking_area;
	}

	public void setParking_area(String parking_area) {
		this.parking_area = parking_area;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	public void validateParking (String action, Parking parking, ParkingErrorMsgs errorMsgs){
		
		if (action.equals("saveParking")) {
			errorMsgs.setParking_areaError(validateParking_area(parking.getParking_area()));
			errorMsgs.setCapacityError(validateCapacity(parking.getCapacity()));
			errorMsgs.setFloorError(validateFloor(parking.getFloor()));
			errorMsgs.setTypeError(validateType(parking.getType()));
			errorMsgs.setCartError(validateCart(parking.getCart()));
			errorMsgs.setCameraError(validateCamera(parking.getCamera()));
			errorMsgs.setHistoryError(validateHistory(parking.getHistory()));
			errorMsgs.setErrorMsg(action);
		}
	}
	
	private String validateParking_area(String parking_area) {
		String result="";
		if (!stringSize(parking_area,3,15))
			result= "Parking Area Name must between 3 and 15 digits";
		else
			if (Character.isLowerCase(parking_area.charAt(0)))
				result="Parking Area Name must start with a capital letter";
		return result;		
	} 
	
	private String validateCapacity(String capacity) {
		String result = "";
		capacity = capacity.trim();
		if(capacity.equals("")){
			result = "Capacity cannot be blank";
		}
		else
			if (!isTextAnInteger(capacity))
				result="Capacity must be a number";
		return result;
	}
	
	private String validateFloor(String floor) {
		String result = "";
		floor = floor.trim();
		if(floor.equals("")){
			result = "Floor cannot be blank";
		}
		return result;
	}
	
	private String validateType(String type){
		String result = "";
		if (!type.equals("Basic") && !type.equals("Premium") && !type.equals("Midrange") 
				&& !type.equals("Access")){
			result = "Invalid parking Type";
		}
		return result;
	}
	
	private String validateCart(String cart){
		String result = "";
		if(cart.equals("")){
			result = "Fiels cannot be left blank";
		}
		return result;
		
	}
	
	private String validateCamera(String camera) {
		String result = "";
		if(camera.equals("")){
			result = "Camera cannot be blank";
		}
		return result;
	}
	
	
	private String validateHistory(String history) {
		String result = "";
		if(history.equals("")){
			result = "History cannot be blank";
		}
		return result;
	}
	
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
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
