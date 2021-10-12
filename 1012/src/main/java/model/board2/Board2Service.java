package model.board2;

import java.util.List;

public interface Board2Service {
	void insertBoard(Board2VO vo);
	void updateBoard(Board2VO vo);
	void deleteBoard(Board2VO vo);
	List<Board2VO> getBoardList(Board2VO vo);
	Board2VO getBoard(Board2VO vo);
	List<Board2VO> getSearch(Board2VO vo);
}
