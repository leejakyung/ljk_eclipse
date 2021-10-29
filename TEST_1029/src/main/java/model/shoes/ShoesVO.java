package model.shoes;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ShoesVO {
	private String spk;
	private String filename;
	private String brandname;
	private String sname;
	private int price;
	private String sdate;
	private String condition;
	private String keyword;
	private MultipartFile fileUpload;
	
	public String getSpk() {
		return spk;
	}
	public void setSpk(String spk) {
		this.spk = spk;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getCondition() {
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
	}
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	@Override
	public String toString() {
		return "ShoesVO [spk=" + spk + ", filename=" + filename + ", brandname=" + brandname + ", sname=" + sname
				+ ", price=" + price + ", sdate=" + sdate + ", condition=" + condition + ", keyword=" + keyword
				+ ", fileUpload=" + fileUpload + "]";
	}
	
	
	
	
}
