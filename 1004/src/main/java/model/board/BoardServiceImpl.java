package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.app.common.LogPlusAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private SpringBoardDAO boardDAO;
	/*private LogPlusAdvice logPlusAdvice;*/
	
	/*public BoardServiceImpl() {
		this.logPlusAdvice=new LogPlusAdvice();
	}*/
	
	@Override
	public void insertBoard(BoardVO vo) {
		/*if(vo.getId()==0) {
			throw new IllegalArgumentException("id PK : 0 불가능!");
			// 런타임 예외(실행시에 발생,체크되는 예외)
		}*/

		//logPlusAdvice.printPlusLog();
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//logPlusAdvice.printPlusLog();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//logPlusAdvice.printPlusLog();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//logPlusAdvice.printPlusLog();
		return boardDAO.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//logPlusAdvice.printPlusLog();
		return boardDAO.getBoard(vo);
	}

}
