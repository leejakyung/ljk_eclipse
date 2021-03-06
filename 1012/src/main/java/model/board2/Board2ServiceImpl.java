package model.board2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("board2Service") // 객체를 생성 
public class Board2ServiceImpl implements Board2Service {

	@Autowired // 여기서 맞는 타입의 컴포넌트를 쓰겠다. 
	private SpringBoard2DAO board2DAO;
	
	@Override
	public void insertBoard(Board2VO vo) {
		board2DAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(Board2VO vo) {
		board2DAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(Board2VO vo) {
		board2DAO.deleteBoard(vo);
	}

	@Override
	public List<Board2VO> getBoardList(Board2VO vo) {
		return board2DAO.getBoardList(vo);
	}

	@Override
	public Board2VO getBoard(Board2VO vo) {
		return board2DAO.getBoard(vo);
	}

	@Override
	public List<Board2VO> getSearch(Board2VO vo) {
		return board2DAO.getSearch(vo);
	}
	

}
