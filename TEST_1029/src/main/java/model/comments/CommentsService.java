package model.comments;

import java.util.List;

import model.page.PageVO;


public interface CommentsService {
	boolean m_insert(CommentsVO vo);
	boolean m_update(CommentsVO vo);
	boolean m_delete(CommentsVO vo);
	List<CommentsVO> getDBList(CommentsVO vo,PageVO pVO);
	//CommentsVO getDBData(CommentsVO vo);
}
