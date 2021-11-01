package model.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDAO {
	private SqlSession mybatis;
	public BoardDAO(){
		mybatis=SqlSessionFactoryBean.getSessionInstans();
	}
	public void insertBoard(BoardVO vo) {
		mybatis.insert("dao.insertBoard", vo);
		mybatis.commit();
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("dao.updateBoard", vo);
		mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("dao.deleteBoard", vo);
		mybatis.commit();
	}
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) mybatis.selectOne("dao.getBoard", vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("dao.getBoardList", vo);
	}
	
}
