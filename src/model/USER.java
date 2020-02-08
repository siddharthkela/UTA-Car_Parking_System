package model;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class USER {
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String role;
	private String phone;
	private String email;
	private String address;
	private String parkingpermittype;
	private String vehiclenumber;
	private String licensenumber;
	private String DateofBirth;
	private String status;
	private String noshow;
	private  String utaid;
	 
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
 

	public String getNoshow() {
		return noshow;
	}


	public void setNoshow(String noshow) {
		this.noshow = noshow;
	}


	public String getUtaid() {
		return utaid;
	}


	public void setUtaid(String utaid) {
		this.utaid = utaid;
	} 


	public void setUSER (String username, String password,String firstname, String lastname, String role, String phone, String email,String address, String parkingpermittype, String vehiclenumber,String licensenumber, String DateofBirth) {
		setUsername(username);
		setPassword(password);
		setFirstname(firstname);
		setLastname(lastname);
		setRole(role);
		setPhone(phone);
		setEmail(email);
		setAddress(address);
		setParkingpermittype(parkingpermittype);
		setVehiclenumber(vehiclenumber);
		setLicensenumber(licensenumber);
		setDateofBirth(DateofBirth);
	}

	
	public String getLicensenumber() {
		return licensenumber;
	}
	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParkingpermittype() {
		return parkingpermittype;
	}
	public void setParkingpermittype(String parkingpermittype) {
		this.parkingpermittype = parkingpermittype;
	}
	public String getVehiclenumber() {
		return vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	
	
	
	public String getDateofBirth() {
		return DateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		DateofBirth = dateofBirth;
	}

	public void validateUSER (String action, USER user, AdminErrorMSGS errMsgs) {
		if (action.equals("searchCompany")) {
			errMsgs.setUser_nameError(validateUsername(action, username));
			errMsgs.setErrorMsg(action);				
		}
		else
			if(action.equals("UpdateUser")){
				errMsgs.setUser_nameError(validateUsername(action,user.getUsername()));
				errMsgs.setPasswordError(validatePassword(action,user.getPassword()));
				errMsgs.setFirstnameError(validateFirstname(action,user.getFirstname()));
				errMsgs.setLastnameError(validateLastname(action,user.getLastname()));
				errMsgs.setPhoneError(validatePhone(action,user.getPhone()));
				errMsgs.setEmailError(validateEmail(action,user.getEmail()));
				errMsgs.setAddressError(validateAddress(action,user.getAddress()));
				errMsgs.setParkingpermittypeError(validateParkingpermittype(action,user.getParkingpermittype()));
				errMsgs.setVehiclenumberError(validateVehiclenumber(action,user.getVehiclenumber()));
				errMsgs.setLicensenumberError(validateLicensenumber(action,user.getLicensenumber()));
				errMsgs.setDateofBirthError(validateDateofBirth(action,user.getDateofBirth()));
				errMsgs.setErrorMsg(action);
			}
	}
	
	private String validateVehiclenumber(String action,String num) {
		String result = "";
		num = num.trim();
		if(num.equals("")){
			result = "Vehicle number cannot be blank";
		}
		return result;
	}
	
	private String validateLicensenumber(String action,String num) {
		String result = "";
		num = num.trim();
		if(num.equals("")){
			result = "License number cannot be blank";
		}
		return result;
	}
	
	
	
	private String validateUsername(String action, String username) {
		String result="";
		if (username.equals(""))
			result="Username cannot be blank";
		return result;
		
	}
	
	private String validateEmail(String action, String email) {
		String result="";
		if (email.equals(""))
			result="Email cannot be blank";
		return result;
		
	}
	
	public String validatePassword(String action, String password) {
		String result = "";
		password = password.trim();
		if(password.length()<6)
			result = "Password must be atleast 6 characters long";
		else if(!password.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"))
			result = "Password must contain atleast one digit one lower case letter one upper case letter and one special character";
		return result;
	}
	
	private String validateFirstname(String action, String firstname) {
		String result = "";
		firstname = firstname.trim();
		if(!stringSize(firstname,3,10))
			result = "First Name must be between 3 and 10 characters";
		else if(!firstname.matches("^[a-zA-Z]+$"))
			result = "First Name must contain only characters";
		return result;
	}
	
	public String validateLastname(String action, String lastname) {
		String result = "";
		lastname = lastname.trim();
		if(!stringSize(lastname,3,45))
			result = "Last Name must be between 3 and 45 characters";
		else if(!lastname.matches("^[a-zA-Z]+$"))
			result = "Last Name must contain only characters";
		return result;
	}
	
	private String validateAddress(String action, String address) {
		String result = "";
		address = address.trim();
		if(address.equals(""))
			result = "Address cannot be blank";
		else if(!stringSize(address,3,45))
			result = "Address must be between 4 and 45 characters";
		else if(!address.matches("^[0-9a-zA-Z- '/,]+$"))
			result = "Address must contain only characters hyphens spaces and /'";
		return result;
	}
	
	public String validatePhone(String action, String phone) {
		String result = "";
		if (phone.equals(""))
			result="Phone number cannot be blank cannot be blank";
		
		else{
			 if(!isTextAnInteger(phone)){
				 result = "Phone number must be a number";
			 }else{
			 if(phone.length()!=10) {
				 result = "Phone number must exactly be 10 digits";
			 }
			 
		}
		
		}return result;
	}
	
	private String validateDateofBirth(String action, String DateofBirth){
		String result = "";
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			Date date1 = sdf.parse(DateofBirth);
			Date date2 = sdf.parse(dtf.format(localDate));
			if(!DateofBirth.matches("^\\d{4}-\\d{2}-\\d{2}$"))
				result = "Invalid date format";
			else if(date1.compareTo(date2) > 0)
				result = "Date is in future";					
		}
		catch(Exception e) {
			result = "Invalid date format";
		}
		return result;
		
	}
	private String validateParkingpermittype(String action,String type){
		String result = "";
		if (!type.equals("basic") && !type.equals("premium") && !type.equals("midrange") 
				&& !type.equals("access")){
			result = "Invalid parking Type";
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


