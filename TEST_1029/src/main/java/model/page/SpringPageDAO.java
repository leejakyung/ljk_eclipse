package model.page;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.shoes.ShoesVO;

class PageRowMapper implements RowMapper<PageVO>{

	@Override
	public PageVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageVO data = new PageVO();
		data.setTotal(rs.getInt(1));
		return data;
		
	}
	
}

@Repository
public class SpringPageDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	//��ü ����Ʈ�� �� ������ �������� sql
	
	private final String selectAllR = "select count(*) from comments where spk = ?";			//��� ��ü ����Ʈ

	private final String selectAll = "select count(*) from shoes";							//�Ź� ��ü ����Ʈ
	private final String selectAllT = "select count(*) from shoes where brandname = ?";			//�Ź� �귣�� ���� ����Ʈ
	private final String selectAllSearch = "select count(*) from shoes where sname like ?";	//�˻��� ��ü ����Ʈ


	public PageVO paging(PageVO pVO, ShoesVO sVO, String table) {	


		if(table.equals("category")) {
			if(sVO.getBrandname() == null || sVO.getBrandname().equals("")) {				

				if(sVO.getKeyword() == null || sVO.getKeyword().equals("")) {		//type �� ���� �˻��� ������ ��ü ����Ʈ�� ����

					pVO.setTotal((jdbcTemplate.queryForObject(selectAll,new PageRowMapper())).getTotal());
					System.out.println("pageDAO ��ü ����Ʈ ī��Ʈ");
				}
				else {											//type �� ���� �˻��� ������ �˻��� ����Ʈ�� ����
					System.out.println("pageDAO ��ü ����Ʈ �˻� ī��Ʈ");

					Object[] args = { "%"+sVO.getSname()+"%" };
					pVO.setTotal((jdbcTemplate.queryForObject(selectAllSearch,args,new PageRowMapper())).getTotal());
				}
			}

			else{												
				if(sVO.getKeyword() == null || sVO.getKeyword().equals("")) {		//type�� ������ type �帣 ����Ʈ�� ����
					System.out.println("pageDAO "+sVO.getBrandname()+" ����Ʈ ī��Ʈ");

					Object[] args = { sVO.getBrandname() };
					pVO.setTotal((jdbcTemplate.queryForObject(selectAllT,args,new PageRowMapper())).getTotal());
				}
			}
		}

		else if(table.equals("shoesList")){						//����϶� shoesList�� ��� ����Ʈ ����
			System.out.println("pageDAO ��� ��ü ����Ʈ ī��Ʈ");

			Object[] args = { sVO.getSpk() };
			pVO.setTotal((jdbcTemplate.queryForObject(selectAllR,args,new PageRowMapper())).getTotal());

		}




		pVO.setLastPage((pVO.getTotal()-1)/pVO.getPerPage()+1);	//������ ������ ����	
		pVO.setStart((pVO.getCurPage()-1)*pVO.getPerPage()+1);		//�������� ������ �Խù� ����
		pVO.setEnd(pVO.getStart()+pVO.getPerPage());				//�������� ������ �Խù� ��		



		pVO.setStartPage((pVO.getCurPage()-1)/pVO.getPerPageSet()*pVO.getPerPageSet()+1);	//���� ����
		if(pVO.getStartPage() < 1) {		//������������ 1���� ������� 1�� ����
			pVO.setStartPage(1);
		}

		pVO.setEndPage(pVO.getStartPage()+pVO.getPerPageSet()-1);							//���� ��
		if(pVO.getEndPage() > pVO.getLastPage()) {	//���������� ���������������� Ŭ��� �������������� ����
			pVO.setEndPage(pVO.getLastPage());
		}

		System.out.println("pageDAO ������ vo :" + pVO);

		return pVO;

	}









}
