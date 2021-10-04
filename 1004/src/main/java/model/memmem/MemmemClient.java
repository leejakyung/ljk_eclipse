package model.memmem;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemmemClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		MemmemService ms=(MemmemService)factory.getBean("memmemService");

		MemmemVO vo=new MemmemVO();
		vo.setId("hong");
		vo.setPassword("1234");
		vo.setName("ȫ�浿");
		vo.setRole("USER");
		ms.insertMemmem(vo);
		
		
		List<MemmemVO> datas=ms.getMemList(vo);
		for(MemmemVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}


}
