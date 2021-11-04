package model.comments;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.page.PageVO;


class CommentsRowMapper implements RowMapper<CommentsVO>{

	@Override
	public CommentsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentsVO data=new CommentsVO();
		data.setCnum(rs.getInt("cnum"));
		data.setSpk(rs.getString("spk"));
		data.setUserID(rs.getString("userID"));
		data.setContent(rs.getString("content"));
		data.setCdate(rs.getString("cdate"));
		return data;
	}
	
}

@Repository
public class SpringCommentsDAO {
	

	private final String m_selectAll= "select * from(select a.*, rownum as rnum from(select * from comments where spk=? order by cnum desc) a where rownum < ?) where rnum >=?"; // 모든 코멘트 보기
	//private final String m_selectOne="select * from comments where userID=? order by cnum desc"; // 내 코멘트 보기
	private final String m_insert="insert into comments(cnum,spk,userID,content,cdate) values (nvl((select max(cnum) from comments),0)+1, ?, ?, ?, to_char(TO_DATE(sysdate,'YY/MM/DD'),'YY/MM/DD'))"; // 코멘트 등록
	private final String m_delete="delete from comments where cnum=?"; // 코멘트 삭제
	private final String m_update="update comments set content=?, cdate= sysdate where cnum=?"; // 코멘트 수정
	//private final String realSelectOne="select * from comments where userID=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean m_insert(CommentsVO vo) {
		if(jdbcTemplate.update(m_insert,vo.getSpk(),vo.getUserID(),vo.getContent())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean m_delete(CommentsVO vo) {
		if(jdbcTemplate.update(m_delete,vo.getCnum())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean m_update(CommentsVO vo) {
		if(jdbcTemplate.update(m_update,vo.getContent(),vo.getCnum())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public List<CommentsVO> getDBList(CommentsVO vo,PageVO pVO){



		System.out.println("댓글 전체 리스트");

		Object[] args = { vo.getSpk(),pVO.getEnd(),pVO.getStart() };
		return jdbcTemplate.query(m_selectAll,args,new CommentsRowMapper());


	}
	/*public CommentsVO getDBData(CommentsVO vo) {
		Object[] args= { vo.getUserID() };
		return jdbcTemplate.queryForObject(m_selectOne,args,new CommentsRowMapper());
	}*/
	
}
