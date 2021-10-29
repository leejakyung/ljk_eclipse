package model.comments;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.client2.Client2VO;

@Service("CommentsService")
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
	public ArrayList<CommentsVO> getDBList(Client2VO vo) {
		return commentsDAO.getDBList(vo);
	}

	@Override
	public CommentsVO getDBData(CommentsVO vo) {
		return commentsDAO.getDBData(vo);
	}

}
