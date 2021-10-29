package model.comments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.client2.Client2VO;

class CommentsRowMapper implements RowMapper<CommentsVO>{

	@Override
	public CommentsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentsVO data=new CommentsVO();
		data.setCnum(rs.getInt("cnum"));
		data.setUserID(rs.getString("userID"));
		data.setTitle(rs.getString("title"));
		data.setContent(rs.getString("content"));
		data.setCdate(rs.getString("cdate"));
		return data;
	}
	
}

@Repository
public class SpringCommentsDAO {
	
	private final String m_selectAll= "select * from comments order by cnum desc"; // 모든 코멘트 보기
	private final String m_selectOne="select * from comments where userID=? order by cnum desc"; // 내 코멘트 보기
	private final String m_insert="insert into comments(cnum,userID,title,content,cdate) values (nvl((select max(cnum) from message2),0)+1, ?, ?, ?, sysdate)"; // 코멘트 등록
	private final String m_delete="delete from comments where userID=?"; // 코멘트 삭제
	private final String m_update="update comments set title=?, content=?, cdate= sysdate where userID=?"; // 코멘트 수정
	private final String realSelectOne="select * from comments where userID=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean m_insert(CommentsVO vo) {
		if(jdbcTemplate.update(m_insert,vo.getUserID(),vo.getTitle(),vo.getContent())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean m_delete(CommentsVO vo) {
		if(jdbcTemplate.update(m_delete,vo.getUserID())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean m_update(CommentsVO vo) {
		if(jdbcTemplate.update(m_update,vo.getUserID(),vo.getTitle(),vo.getContent())>=1) {
			return true;
		} else {
			return false;
		}
	}
	/*public ArrayList<CommentsVO> getDBList(Client2VO vo){
		
	}
	public CommentsVO getDBData(CommentsVO vo) {
		
	}*/
	
}
