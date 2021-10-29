package model.mine;

public class MineVO {
	private int mpk;
	private String spk;
	private String email;
	
	public int getMpk() {
		return mpk;
	}
	public void setMpk(int mpk) {
		this.mpk = mpk;
	}
	public String getSpk() {
		return spk;
	}
	public void setSpk(String spk) {
		this.spk = spk;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MineVO [mpk=" + mpk + ", spk=" + spk + ", email=" + email + "]";
	}
	
	
}
