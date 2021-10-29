package model.shoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



class ShoesRowMapper implements RowMapper<ShoesVO>{

	@Override
	public ShoesVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ShoesVO data = new ShoesVO();
		data.setSpk(rs.getString("spk"));
		data.setFilename(rs.getString("filename"));
		data.setBrandname(rs.getString("brandname"));
		data.setSname(rs.getString("sname"));
		data.setSdate(rs.getString("sdate"));
		data.setPrice(rs.getInt("price"));
		return data;
	}
	
}

@Repository
public class SpringShoesDAO {

	private final String s_insert="insert into shoes values(?,?,?,?,to_char(TO_DATE(?,'YYYY-MM-DD'),'YYYY-MM-DD'),?)"; // 신발 정보 추가
	private final String s_delete="delete from shoes where spk=?"; //  신발 정보 삭제
	private final String s_update="update shoes set spk=?, filename=?, brandname=?, sname=?, price=?, sdate=? where spk=?"; // 신발 정보 수정
	private final String s_selectAll="select * from shoes order by spk desc"; // 신발 게시물 모두 보기
	private final String s_selectOne="select * from shoes where spk=?"; // 신발 게시물 상세페이지
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean s_insert(ShoesVO vo) {
		if(jdbcTemplate.update(s_insert,vo.getSpk(),vo.getFilename(),vo.getBrandname(),vo.getSname(),vo.getSdate(),vo.getPrice())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean s_update(ShoesVO vo) {
		if(jdbcTemplate.update(s_update,vo.getSpk(),vo.getFilename(),vo.getBrandname(),vo.getSname(),vo.getPrice(),vo.getSdate(),vo.getSpk())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean s_delete(ShoesVO vo) {
		if(jdbcTemplate.update(s_delete,vo.getSpk())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public List<ShoesVO> getShoesList(ShoesVO vo){
		return jdbcTemplate.query(s_selectAll,new ShoesRowMapper());
	}
	
	public ShoesVO getShoesData(ShoesVO vo) {
		Object[] args= { vo.getSpk() };
		return jdbcTemplate.queryForObject(s_selectOne,args,new ShoesRowMapper());
	}
	
}
