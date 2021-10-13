package model.board2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class Board2RowMapper implements RowMapper<Board2VO>{
	
	@Override
	public Board2VO mapRow(ResultSet rs, int rowNum) throws SQLException{
		Board2VO data=new Board2VO();
		data.setId(rs.getInt("id"));
		data.setTitle(rs.getString("title"));
		data.setWriter(rs.getString("writer"));
		data.setContent(rs.getString("content"));
		data.setWdate(rs.getDate("wdate"));
		return data;
	}
}

@Repository // component의 하위개념 //  DB에 접근하는 모든 코드가 모여있음. // 아 이거 dao구나 라고 생각할 수 있음!
public class SpringBoard2DAO{
	
	
	private final String insertSQL="insert into board2 (id,title,writer,content) values((select nvl(max(id),0)+1 from board2),?,?,?)";
	private final String updateSQL="update board2 set title=?,content=? where id=?";
	private final String deleteSQL="delete board2 where id=?";
	private final String getBoardSQL="select * from board2 where id=?";
	private final String getBoardListSQL="select * from board2 order by id desc";
	private final String getSearchSQL="select* from board2 where title like ?";

	@Autowired // 생성자주입. setter주입.
	private JdbcTemplate jdbcTemplate;
	
	public void insertBoard(Board2VO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertSQL,vo.getTitle(),vo.getWriter(),vo.getContent());
		// 데이터소스를 가지고 접근함
	}

	public void updateBoard(Board2VO vo) {
		System.out.println("jdbcTemplate으로 update");
		jdbcTemplate.update(updateSQL,vo.getTitle(),vo.getWriter(),vo.getId());
	}

	public void deleteBoard(Board2VO vo) {
		System.out.println("jdbcTemplate으로 delete");
		jdbcTemplate.update(deleteSQL,vo.getId());
	}

	public List<Board2VO> getBoardList(Board2VO vo) {
		System.out.println("jdbcTemplate으로 getBoardList");
		return jdbcTemplate.query(getBoardListSQL,new Board2RowMapper());
	}

	public Board2VO getBoard(Board2VO vo) {
		System.out.println("jdbcTemplate으로 getBoard");
		Object[] args= { vo.getId() };
		return jdbcTemplate.queryForObject(getBoardSQL, args, new Board2RowMapper());
	}
	
	public List<Board2VO> getSearch(Board2VO vo){
		System.out.println("jdbcTemplate으로 search");
		Object[] args= { "%"+vo.getTitle()+"%" };
		return jdbcTemplate.query(getSearchSQL, args, new Board2RowMapper());
	}
}