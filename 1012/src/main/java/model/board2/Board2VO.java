package model.board2;

import java.sql.Date;

public class Board2VO {
	private int id;
	private String title;
	private String writer;
	private String content;
	private Date wdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
	@Override
	public String toString() {
		return "Board2VO [id=" + id + ", title=" + title + ", writer=" + writer + ", content=" + content + ", wdate="
				+ wdate + "]";
	}
	
	
	
}
