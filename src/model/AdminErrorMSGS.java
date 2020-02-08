package model;
public class AdminErrorMSGS {
	
	private String errorMsg;
	private String user_nameError;
	private String passwordError;
	private String firstnameError;
	private String lastnameError;
	private String roleError;
	private String phoneError;
	private String emailError;
	private String addressError;
	private String parkingpermittypeError;
	private String vehiclenumberError;
	private String licensenumberError;
	private String dobError;
	

	public AdminErrorMSGS() {
		this.errorMsg="";
		this.user_nameError="";	
		this.passwordError="";
		this.firstnameError="";
		this.lastnameError="";
		this.roleError="";
		this.phoneError="";
		this.emailError="";
		this.addressError="";
		this.parkingpermittypeError="";
		this.vehiclenumberError="";
		this.licensenumberError="";
		this.dobError="";
		
		
	}
	public void 	setErrorMsg(String action) {
		if (action.equals("searchCompany")) {
			if (!user_nameError.equals("") )
			this.errorMsg="Please correct the following errors";
		}		
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public String getUser_nameError() {
		return user_nameError;
	}

	public void setUser_nameError(String user_nameError) {
		this.user_nameError = user_nameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getFirstnameError() {
		return firstnameError;
	}
	public void setFirstnameError(String firstnameError) {
		this.firstnameError = firstnameError;
	}
	public String getLastnameError() {
		return lastnameError;
	}
	public void setLastnameError(String lastnameError) {
		this.lastnameError = lastnameError;
	}
	public String getRoleError() {
		return roleError;
	}
	public void setRoleError(String roleError) {
		this.roleError = roleError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getAddressError() {
		return addressError;
	}
	public void setAddressError(String addressError) {
		this.addressError = addressError;
	}
	public String getParkingpermittypeError() {
		return parkingpermittypeError;
	}
	public void setParkingpermittypeError(String parkingpermittypeError) {
		this.parkingpermittypeError = parkingpermittypeError;
	}
	public String getVehiclenumberError() {
		return vehiclenumberError;
	}
	public void setVehiclenumberError(String vehiclenumberError) {
		this.vehiclenumberError = vehiclenumberError;
	}
	public String getLicensenumberError() {
		return licensenumberError;
	}
	public void setLicensenumberError(String licensenumberError) {
		this.licensenumberError = licensenumberError;
	}
	public String getDobError() {
		return dobError;
	}
	public void setDateofBirthError(String dobError) {
		this.dobError = dobError;
	}
	
	
}
