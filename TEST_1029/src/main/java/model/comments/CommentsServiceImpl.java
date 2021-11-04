package model.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.page.PageVO;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private SpringCommentsDAO commentsDAO;
	
	@Override
	public boolean m_insert(CommentsVO vo) {
		return commentsDAO.m_insert(vo);
	}

	@Override
	public boolean m_update(CommentsVO vo) {
		return commentsDAO.m_update(vo);
	}

	@Override
	public boolean m_delete(CommentsVO vo) {
		return commentsDAO.m_delete(vo);
	}

	@Override
	public List<CommentsVO> getDBList(CommentsVO vo,PageVO pVO) {
		return commentsDAO.getDBList(vo, pVO);
	}



	/*@Override
	public CommentsVO getDBData(CommentsVO vo) {
		return commentsDAO.getDBData(vo);
	}*/

}
