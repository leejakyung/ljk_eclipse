package model.comments;

import java.sql.Date;

public class CommentsVO {
	private int cnum;
	private String spk;
	private String userID;
	private String content;
	private String cdate;
	
	/*private String condition;
	private String keyword;*/
	
	/*public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}*/
	public String getSpk() {
		return spk;
	}
	public void setSpk(String spk) {
		this.spk = spk;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	@Override
	public String toString() {
		return "CommentsVO [cnum=" + cnum + ", spk=" + spk + ", userID=" + userID + ", content=" + content + ", cdate="
				+ cdate + "]";
	}
	


	
	
}