package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction{
	private String name;
	private List<String> inven;
	@Autowired // �ַ� ������� ������ ���� ���� , �����̳ʴ� �ڽ��� �����ξ��� ��ü���� "Ÿ��"�� Ȯ��! �����������ԡ�
	@Resource(name="bow") // Ÿ�Ե� ���� �̸��� �� �� ���� !!  -> ������ Ÿ���̰��ĵ� �� �� ����!
	private Weapon weapon; // @Autowired�� �θ� �����ڳ� ���͵� �ʿ���� 
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
		// ���������ͼ���(����) �߻� ����� ������, new �߾�� �ߴ�!!
		// -> ��� ������ ó��, ������ ����
		// -> setter �������� ����(�⺻�����ڰ� �ʿ�!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v:inven) { // ���׸��� �ɾ��־��� ������ �̰��� string ���°� ����
			System.out.println(v);
		}
	}
	
}
