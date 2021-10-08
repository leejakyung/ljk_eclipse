package model.memmem;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemmemClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		MemmemService ms=(MemmemService)factory.getBean("memmemService");

		MemmemVO vo=new MemmemVO();
		vo.setId("kim");
		vo.setPassword("1234");
		
		MemmemVO data = ms.getBoard(vo);
		
		if(data!=null) {
			// 로그인 성공
			System.out.println("로그인 성공!");
		}
		else {
			// 로그인 실패
			System.out.println("로그인 실패!");
		}
		
		factory.close();
	}


}
