package test;

import org.springframework.stereotype.Component;

/*<bean class="test.Sword" id="sword">*/
//  == @Component  (Ŭ���� ����� ���� �ۼ�)
@Component("sword")
public class Sword implements Weapon {

	@Override
	public void attack() {
		System.out.println("������ ����!");
	}

}
