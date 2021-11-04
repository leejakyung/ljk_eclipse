package model.style;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class StyleRowMapper implements RowMapper<StyleVO>{

	@Override
	public StyleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StyleVO data = new StyleVO();
		data.setSnum(rs.getInt("snum"));
		data.setSpk(rs.getString("spk"));
		data.setFilename(rs.getString("filename"));
		data.setEmail(rs.getString("email"));
		return data;
	}

}

@Repository
public class SpringStyleDAO {
	
	private final String st_insert="insert into style values(nvl((select max(snum) from style),0)+1, ?, ?, ?)"; // 스타일 뽐내기
	private final String st_delete="delete from style where snum=?"; //  내  스타일뽐내기사진 삭제
	private final String st_selectAll="select * from style where spk=? and rownum<=? order by snum desc"; // 스타일 더보기
	// select * from style  where rownum<=3 order by snum desc;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean st_insert(StyleVO vo) {
		if(jdbcTemplate.update(st_insert,vo.getSpk(),vo.getFilename(),vo.getEmail())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean st_delete(StyleVO vo) {
		if(jdbcTemplate.update(st_delete,vo.getSnum())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public List<StyleVO> getStyleList(StyleVO vo, int scnt){
		Object[] args= { vo.getSpk(),scnt };
		return jdbcTemplate.query(st_selectAll,args,new StyleRowMapper());
	}
	
}
