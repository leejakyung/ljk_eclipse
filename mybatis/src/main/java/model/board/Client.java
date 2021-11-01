package model.board;

import java.util.List;

public class Client {
	public static void main(String[] args) {

		BoardDAO dao=new BoardDAO();

		BoardVO vo=new BoardVO();
		vo.setTitle("제목");
		vo.setWriter("작성자");
		vo.setContent("내용");

		dao.insertBoard(vo);


		vo.setKeyword("제");
		List<BoardVO> datas=dao.getBoardList(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
	}
}
