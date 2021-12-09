package model.board;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JPABoardDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardVO vo) {
		em.persist(vo);
	}
	
	public void updateBoard(BoardVO vo) {
		em.merge(vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		em.remove(em.find(BoardVO.class, vo.getWpk())); // id 어노테이션이 달려있는 즉, 식별자 필드를 파라미터로 사용
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO) em.find(BoardVO.class, vo.getWpk()); // id 어노테이션이 달려있는 즉, 식별자 필드를 파라미터로 사용
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("JPA 스프링 연동 실습");
		return em.createQuery("select b from Board b", BoardVO.class).getResultList();
	}
}
