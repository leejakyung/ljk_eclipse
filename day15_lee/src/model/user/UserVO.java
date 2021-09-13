package model.user;

import java.util.Date;

public class UserVO {
	private String uid;
	private String name;
	private String upw;
	private Date udate;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
		return "UserVO [uid=" + uid + ", name=" + name + ", upw=" + upw + ", udate=" + udate + "]";
	}
	
	
}
