package model.shoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.page.PageVO;

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
public class SpringShoesDAO { 

	private final String s_insert="insert into shoes values(?,?,?,?,?,to_char(TO_DATE(?,'YYYY-MM-DD'),'YYYY-MM-DD'))"; // �Ź� ���� �߰�
	private final String s_delete="delete from shoes where spk=?"; //  �Ź� ���� ����
	private final String s_update="update shoes set spk=?, filename=?, brandname=?, sname=?, price=?, sdate=? where spk=?"; // �Ź� ���� ����
	//private final String s_selectAll="select * from shoes order by spk asc"; // �Ź� �Խù� ��� ����
	private final String s_selectOne="select * from shoes where spk=?"; // �Ź� �Խù� ��������
	
	// ����¡ ó��
	private final String selectAll = "select * from(select a.*, rownum as rnum from(select * from shoes order by spk asc) a where rownum < ?) where rnum >=?";			//�Ź� ��ü ����Ʈ
	private final String selectAllT = "select * from(select a.*, rownum as rnum from(select * from shoes where brandname = ? order by spk asc) a where rownum < ?) where rnum >=?";
	private final String selectAllSearch = "select * from(select a.*, rownum as rnum from(select * from shoes where sname like ? order by spk asc) a where rownum < ?) where rnum >=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean s_insert(ShoesVO vo) {
		if(jdbcTemplate.update(s_insert,vo.getSpk(),vo.getFilename(),vo.getBrandname(),vo.getSname(),vo.getPrice(),vo.getSdate())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean s_update(ShoesVO vo) {
		System.out.println("���Ͼ�����Ʈ DAO"+vo);
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
	public List<ShoesVO> getShoesList(ShoesVO vo, PageVO pVO){
	
		
		if(vo.getBrandname() == null || vo.getBrandname().equals("")) {				

			if(vo.getKeyword() == null || vo.getKeyword().equals("")) {		//ī�װ� x, �˻� x
				System.out.println("��ü ����Ʈ");
				
				Object[] args = { pVO.getEnd(),pVO.getStart() };
				return jdbcTemplate.query(selectAll,args,new ShoesRowMapper());
			}
			else {											//ī�װ� x, �˻� o
			
				System.out.println("��ü ����Ʈ �˻�");
				Object[] args = { "%"+vo.getKeyword()+"%",pVO.getEnd(),pVO.getStart() };
				return jdbcTemplate.query(selectAllSearch,args,new ShoesRowMapper());
			}
		}

		else{												
				
				Object[] args = { vo.getBrandname(),pVO.getEnd(),pVO.getStart() };
				return jdbcTemplate.query(selectAllT,args,new ShoesRowMapper());
		

		}
	
		
	}
	
	public ShoesVO getShoesData(ShoesVO vo) {
		Object[] args= { vo.getSpk() };
		return jdbcTemplate.queryForObject(s_selectOne,args,new ShoesRowMapper());
	}
	
}
