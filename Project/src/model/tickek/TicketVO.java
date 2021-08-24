package model.tickek;

public class TicketVO {
	// 예약 취소 변경 조회 시 사용
	
	private int t_num;
	private String id;
	private String air_num;
	private int payment;
	private int use_point;
	
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAir_num() {
		return air_num;
	}
	public void setAir_num(String air_num) {
		this.air_num = air_num;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getUse_point() {
		return use_point;
	}
	public void setUse_point(int use_point) {
		this.use_point = use_point;
	}
	
	@Override
	public String toString() {
		return t_num + " " + air_num + " " + id + " " + payment + " " + use_point;
	}
}