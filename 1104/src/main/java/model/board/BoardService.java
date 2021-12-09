package model.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO invo);
	void updateBoard(BoardVO invo);
	void deleteBoard(BoardVO invo);
	List<BoardVO> getBoardList(BoardVO invo);
	BoardVO getBoard(BoardVO invo);
}
