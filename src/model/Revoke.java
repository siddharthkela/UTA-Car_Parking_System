package model;

public class Revoke {
	
	private String username;
	private String reason;
	
	public void setRevoke(String username, String reason){
		setUsername(username);
		setReason(reason);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public void validateRevoke(String action,Revoke revoke,RevokeErrorMsgs RverrorMsgs){
		if (action.equals("revoke")){
			RverrorMsgs.setUser_nameError(validateUsername(action,revoke.getUsername()));
			RverrorMsgs.setReasonError(validateReason(action,revoke.getReason()));
			RverrorMsgs.setErrorMsg(action);
		}
	}
	
	private String validateUsername(String action, String username) {
		String result="";
		if (username.equals(""))
			result="Username cannot be blank";
		return result;
		
	}
	
	private String validateReason(String action, String reason) {
		String result="";
		if (reason.equals(""))
			result="Reason cannot be blank";
		return result;
		
	}

}
