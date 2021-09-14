package model.user;

import java.util.Date;

public class UserVO {
	private String userID;
	private String name;
	private String upw;
	private Date udate;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", name=" + name + ", upw=" + upw + ", udate=" + udate + "]";
	}
	
	
}
