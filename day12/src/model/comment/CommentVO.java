package model.comment;

import java.sql.Date;

public class CommentVO {
	private int rpk;
	private String rid;
	private String rpw;
	private String review;
	private Date rdate;
	public int getRpk() {
		return rpk;
	}
	public void setRpk(int rpk) {
		this.rpk = rpk;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRpw() {
		return rpw;
	}
	public void setRpw(String rpw) {
		this.rpw = rpw;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	@Override
	public String toString() {
		return "CommentVO [rpk=" + rpk + ", rid=" + rid + ", rpw=" + rpw + ", review=" + review + ", rdate=" + rdate
				+ "]";
	}
	
	
	
}
