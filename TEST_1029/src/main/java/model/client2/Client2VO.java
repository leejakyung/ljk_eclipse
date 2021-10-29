package model.client2;

public class Client2VO {
	private String userID;
	private String userPW;
	private String email;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Client2VO [userID=" + userID + ", userPW=" + userPW + ", email=" + email + "]";
	}
	

}
