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
		vo.setContent("jdbcTemplate 클래스 이용한 실습 완료!!!");
		vo.setTitle("10월12일");
		vo.setWriter("김아무");
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
