package model.mine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.shoes.ShoesVO;

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

class ShoesRowMapper implements RowMapper<ShoesVO>{

	@Override
	public ShoesVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShoesVO data = new ShoesVO();
		data.setSpk(rs.getString("spk"));
//		data.setFilename(rs.getString("filename"));
		data.setBrandname(rs.getString("brandname"));
		data.setSname(rs.getString("sname"));
		data.setSdate(rs.getString("sdate"));
		data.setPrice(rs.getInt("price"));
		
		String isHttp = null;	
		isHttp = rs.getString("filename");

		
		if(!isHttp.substring(0, 4).equals("http")) {		// ó�� 4���ڰ� http�� �ƴϸ� �տ� imgaes/�߰�
			isHttp = "images/"+isHttp;
		}

		data.setFilename(isHttp);
	
		
		return data;
	
	}
	
}

@Repository
public class SpringMineDAO {
	
	private final String mine="select * from mine where spk=? and email=?";
	private final String mineIns="insert into mine values (nvl((select max(mpk) from mine),0)+1, ?, ?)";
	private final String mineDel="delete from mine where spk=? and email=?";
	private final String mineAll="select * from shoes inner join mine on shoes.spk = mine.spk and mine.email = ?"; // �� ��� ����
//	private final String mineAll="select * from mine where email = ?"; // �� ��� ����

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MineVO mine(MineVO vo) {
		Object[] args= { vo.getSpk(),vo.getEmail() };
		return jdbcTemplate.queryForObject(mine,args,new MineRowMapper());
	}
	public boolean mineIns(MineVO vo) {
		if(jdbcTemplate.update(mineIns,vo.getSpk(),vo.getEmail())>=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean mineDel(MineVO vo) {
		if(jdbcTemplate.update(mineDel,vo.getSpk(),vo.getEmail())>=1) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<ShoesVO> getShoesList(MineVO vo){
		Object[] args= { vo.getEmail() };
		return jdbcTemplate.query(mineAll,args,new ShoesRowMapper());	
	}
}
