package model.comments;

import java.util.ArrayList;

import model.client2.Client2VO;

public interface CommentsService {
	boolean m_insert(CommentsVO vo);
	boolean m_update(CommentsVO vo);
	boolean m_delete(CommentsVO vo);
	ArrayList<CommentsVO> getDBList(Client2VO vo);
	CommentsVO getDBData(CommentsVO vo);
}
