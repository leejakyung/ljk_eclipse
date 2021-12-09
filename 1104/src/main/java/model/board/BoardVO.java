package model.board;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="BOARD") // 클래스명과 테이블명이 만약 다를 경우 name 속성을 이용하여 이름을 맞춰줄 수 있다.
public class BoardVO {
	
	@Id // 해당 필드를 식별자 필드로 만들어주는 어노테이션 (필수)
	@GeneratedValue // pk를 시퀀스로 처리하거나, nvl 처리 해줄 경우 붙여줘야함!
	private int wpk; // 식별자 필드 == pk
	private String title;
	private String id;
	private String content;
	@Temporal(TemporalType.DATE) // DATE 타입일 경우 적용
	private Date wdate = new Date();
	@Transient // spring에서는 사용하지만 테이블에 없는 컬럼일 경우 매핑에서 제외시키는 어노테이션
	private String type; // 검색 옵션
	@Transient
	private String keyword; // 검색 키워드
	
	public int getWpk() {
		return wpk;
	}
	public void setWpk(int wpk) {
		this.wpk = wpk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "BoardVO [wpk=" + wpk + ", title=" + title + ", id=" + id + ", content=" + content + ", wdate=" + wdate + "]";
		
	}
	
}
