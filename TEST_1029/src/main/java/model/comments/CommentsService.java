package model.comments;

import java.util.List;


public interface CommentsService {
	boolean m_insert(CommentsVO vo);
	boolean m_update(CommentsVO vo);
	boolean m_delete(CommentsVO vo);
	List<CommentsVO> getDBList(CommentsVO vo);
	//CommentsVO getDBData(CommentsVO vo);
}
