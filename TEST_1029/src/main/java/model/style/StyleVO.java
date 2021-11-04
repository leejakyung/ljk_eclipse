package model.style;

import org.springframework.web.multipart.MultipartFile;

public class StyleVO {
	private int snum;
	private String spk;
	private String filename;
	private String email;
	private MultipartFile fileUpload;
	
	public MultipartFile getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(MultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "StyleVO [snum=" + snum + ", spk=" + spk + ", filename=" + filename + ", email=" + email
				+ ", fileUpload=" + fileUpload + "]";
	}
	
	
	
}
