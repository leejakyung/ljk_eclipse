package model.mine;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MineRowMapper implements RowMapper<MineVO>{

	@Override
	public MineVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MineVO data = new MineVO();
		data.setMpk(rs.getInt("mpk"));
		data.setSpk(rs.getString("spk"));
		data.setEmail(rs.getString("email"));
		return data;
	}
	
}

@Repository
public class SpringMineDAO {
	
	private final String mine="select * from mine spk=? and email=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean mine(MineVO vo) {
		if(jdbcTemplate.update(mine,vo.getSpk(),vo.getEmail())>=1) {
			return true;
		} else {
			return false;
		}
	}
	
}
