package model.board;

import java.util.List;

public class Client {
	public static void main(String[] args) {

		BoardDAO dao=new BoardDAO();

		BoardVO vo=new BoardVO();
		vo.setTitle("����");
		vo.setWriter("�ۼ���");
		vo.setContent("����");

		dao.insertBoard(vo);


		vo.setKeyword("��");
		List<BoardVO> datas=dao.getBoardList(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
	}
}
