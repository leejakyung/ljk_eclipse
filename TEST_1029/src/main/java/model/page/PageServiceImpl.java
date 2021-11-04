package model.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.shoes.ShoesVO;

@Service("PageService")
public class PageServiceImpl implements PageService{
	
	@Autowired
	private SpringPageDAO pageDAO;
	
	
	public PageVO paging(PageVO pVO, ShoesVO sVO, String table) {
		return pageDAO.paging(pVO, sVO, table);
	}

}
