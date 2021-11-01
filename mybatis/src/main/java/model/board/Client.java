package model.board;

import java.util.List;

public class Client {
	public static void main(String[] args) {

		BoardDAO dao=new BoardDAO();

		BoardVO vo=new BoardVO();
		vo.setTitle("力格");
		vo.setWriter("累己磊");
		vo.setContent("郴侩");

		dao.insertBoard(vo);


		vo.setKeyword("力");
		List<BoardVO> datas=dao.getBoardList(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
	}
}
