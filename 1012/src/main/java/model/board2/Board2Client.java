package model.board2;



import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



public class Board2Client {
	public static void main(String[] args) {
		

		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		Board2Service bs=(Board2Service)factory.getBean("board2Service");
	
		
		Board2VO vo=new Board2VO();
		vo.setContent("jdbcTemplate Ŭ���� �̿��� �ǽ� �Ϸ�!!!");
		vo.setTitle("10��12��");
		vo.setWriter("��ƹ�");
		bs.insertBoard(vo);
		
	/*	List<Board2VO> datas=bs.getBoardList(vo);
		for(Board2VO data:datas) {
			System.out.println(data);
		}*/
		
		
		vo.setTitle("3");
		
		List<Board2VO> datas=bs.getSearch(vo);
		for(Board2VO data:datas) {
			System.out.println(data);
		}
		
		
		factory.close();
	}
}
