package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardClient {
	public static void main(String[] args) { 
		
		
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		BoardService bs=(BoardService)factory.getBean("boardService");
	
		BoardVO vo=new BoardVO(); 
		vo.setContent("jdbcTemplate 클래스를 이용한 실습 완료!");
		vo.setTitle("제목입니다!!");
		vo.setWriter("관리자");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.getBoardList(vo);
		for(BoardVO data:datas) {
			System.out.println(data);
		}
		
		factory.close();
	}
}
