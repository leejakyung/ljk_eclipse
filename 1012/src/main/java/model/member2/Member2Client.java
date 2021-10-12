package model.member2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Member2Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		
		Member2Service ms=(Member2Service)factory.getBean("member2Service");
		
		
		
		Member2VO vo=new Member2VO();
		vo.setId("kim");
		vo.setPassword("a1111");
		
		vo.setId("lee");
		vo.setPassword("123");
		vo.setName("이티모");
		vo.setRole("USER");
		ms.insertMem(vo);
		
		
		List<Member2VO> datas = ms.getMem(vo);
		
		if(datas.isEmpty()) {
			// 로그인 성공
			System.out.println("로그인 실패!");
		}
		else {
			// 로그인 실패
			System.out.println("로그인 성공!");
		}
		
		factory.close();
	}
}
