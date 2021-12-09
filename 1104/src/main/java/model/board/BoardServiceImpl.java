package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private JPABoardDAO springBoardDAO;
	
	@Override
	public void insertBoard(BoardVO invo) {
		springBoardDAO.insertBoard(invo);
	}
	@Override
	public void updateBoard(BoardVO invo) {
		springBoardDAO.updateBoard(invo);
	}
	@Override
	public void deleteBoard(BoardVO invo) {
		springBoardDAO.deleteBoard(invo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO invo) {
		return springBoardDAO.getBoardList(invo);
	}
	@Override
	public BoardVO getBoard(BoardVO invo) {
		return springBoardDAO.getBoard(invo);
	}
}
