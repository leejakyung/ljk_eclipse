package model.memmem;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemmemRowMapper implements RowMapper<MemmemVO>{

	@Override
	public MemmemVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemmemVO data=new MemmemVO();
		data.setId(rs.getString("id"));
		data.setPassword(rs.getString("password"));
		data.setName(rs.getString("name"));
		data.setRole(rs.getString("role"));
		return data;
	}
	
}

@Repository()
public class SpringMemDAO {
	
	
	private final String getMemSQL="select * from memmem where id =? and password=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemmemVO getMem(MemmemVO vo) {
		System.out.println("jdbcTemplate¿∏∑Œ getMem");
		Object[] args= {vo.getId(),vo.getPassword()};
		return jdbcTemplate.queryForObject(getMemSQL, args,new MemmemRowMapper());
	}	
}
