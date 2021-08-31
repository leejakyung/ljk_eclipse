package model.letter;

import java.sql.Date;

public class LetterVO {
	int lnum;
	String writer;
	String title;
	String content;
	Date wdate;
	public int getLnum() {
		return lnum;
	}
	public void setLnum(int lnum) {
		this.lnum = lnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
		return "LetterVO [번호:" + lnum + ", 작성자:" + writer + ", 제목:" + title + ", 내용:" + content
				+ ", 작성날짜:" + wdate + "]";
	}
}
