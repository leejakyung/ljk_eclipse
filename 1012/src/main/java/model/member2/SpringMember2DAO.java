package model.member2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class Member2RowMapper implements RowMapper<Member2VO>{

	@Override
	public Member2VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member2VO data=new Member2VO();
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}

@Repository
public class SpringMember2DAO {
	
private final String getMemSQL="select * from member2 where id =? and password=?";
private final String insertMemSQL="insert into member2 values (?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Member2VO> getMem(Member2VO vo) {
		System.out.println("jdbcTemplate으로 getMem");
		Object[] args= {vo.getId(),vo.getPassword()};
		return jdbcTemplate.query(getMemSQL, args,new Member2RowMapper());
	}	
	
	public void insertMem(Member2VO vo) {
		System.out.println("jdbcTemplate으로 insert");
		jdbcTemplate.update(insertMemSQL,vo.getId(),vo.getPassword(),vo.getName(),vo.getRole());
	}
}
