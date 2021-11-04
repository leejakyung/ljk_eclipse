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


	//전체 리스트의 총 개수를 가져오는 sql
	
	private final String selectAllR = "select count(*) from comments where spk = ?";			//댓글 전체 리스트

	private final String selectAll = "select count(*) from shoes";							//신발 전체 리스트
	private final String selectAllT = "select count(*) from shoes where brandname = ?";			//신발 브랜드 선택 리스트
	private final String selectAllSearch = "select count(*) from shoes where sname like ?";	//검색시 전체 리스트


	public PageVO paging(PageVO pVO, ShoesVO sVO, String table) {	


		if(table.equals("category")) {
			if(sVO.getBrandname() == null || sVO.getBrandname().equals("")) {				

				if(sVO.getKeyword() == null || sVO.getKeyword().equals("")) {		//type 이 없고 검색이 없을시 전체 리스트의 개수

					pVO.setTotal((jdbcTemplate.queryForObject(selectAll,new PageRowMapper())).getTotal());
					System.out.println("pageDAO 전체 리스트 카운트");
				}
				else {											//type 이 없고 검색이 있을시 검색한 리스트의 개수
					System.out.println("pageDAO 전체 리스트 검색 카운트");

					Object[] args = { "%"+sVO.getSname()+"%" };
					pVO.setTotal((jdbcTemplate.queryForObject(selectAllSearch,args,new PageRowMapper())).getTotal());
				}
			}

			else{												
				if(sVO.getKeyword() == null || sVO.getKeyword().equals("")) {		//type이 있을때 type 장르 리스트의 개수
					System.out.println("pageDAO "+sVO.getBrandname()+" 리스트 카운트");

					Object[] args = { sVO.getBrandname() };
					pVO.setTotal((jdbcTemplate.queryForObject(selectAllT,args,new PageRowMapper())).getTotal());
				}
			}
		}

		else if(table.equals("shoesList")){						//댓글일때 shoesList의 댓글 리스트 개수
			System.out.println("pageDAO 댓글 전체 리스트 카운트");

			Object[] args = { sVO.getSpk() };
			pVO.setTotal((jdbcTemplate.queryForObject(selectAllR,args,new PageRowMapper())).getTotal());

		}




		pVO.setLastPage((pVO.getTotal()-1)/pVO.getPerPage()+1);	//마지막 페이지 설정	
		pVO.setStart((pVO.getCurPage()-1)*pVO.getPerPage()+1);		//페이지에 보여줄 게시물 시작
		pVO.setEnd(pVO.getStart()+pVO.getPerPage());				//페이지에 보여줄 게시물 끝		



		pVO.setStartPage((pVO.getCurPage()-1)/pVO.getPerPageSet()*pVO.getPerPageSet()+1);	//목차 시작
		if(pVO.getStartPage() < 1) {		//시작페이지가 1보다 작을경우 1로 설정
			pVO.setStartPage(1);
		}

		pVO.setEndPage(pVO.getStartPage()+pVO.getPerPageSet()-1);							//목차 끝
		if(pVO.getEndPage() > pVO.getLastPage()) {	//끝페이지가 마지막페이지보다 클경우 마지막페이지로 설정
			pVO.setEndPage(pVO.getLastPage());
		}

		System.out.println("pageDAO 설정후 vo :" + pVO);

		return pVO;

	}









}
