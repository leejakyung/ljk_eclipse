package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction{
	private String name;
	private List<String> inven;
	@Autowired // 주로 멤버변수 위에서 많이 쓰임 , 컨테이너는 자신이 만들어두었던 객체들의 "타입"을 확인! ★의존성주입★
	@Resource(name="bow") // 타입도 보고 이름도 볼 수 있음 !!  -> 때문에 타입이겹쳐도 알 수 있음!
	private Weapon weapon; // @Autowired만 두면 생성자나 세터도 필요없음 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public void attack() {
		weapon.attack();
		// 널포인터익셉션(예외) 발생 우려가 있으니, new 했어야 했다!!
		// -> 멤버 변수로 처리, 생성자 주입
		// -> setter 주입으로 변경(기본생성자가 필요!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) { // 제네릭을 걸어주었기 때문에 이곳에 string 쓰는것 가능
			System.out.println(v);
		}
	}
	
}
