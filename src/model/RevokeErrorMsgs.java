package model;

public class RevokeErrorMsgs {
	
	private String errorMsg;
	private String user_nameError;
	private String reasonError;
	
	
	public RevokeErrorMsgs(){
		this.errorMsg="";
		this.user_nameError="";
		this.reasonError="";
	}
	
	public void setErrorMsg(String action) {
			if (!user_nameError.equals("") ||  !reasonError.equals("") )
			this.errorMsg="Please correct the following errors";
		
		
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

	public String getReasonError() {
		return reasonError;
	}

	public void setReasonError(String reasonError) {
		this.reasonError = reasonError;
	}
	
	
	

}
