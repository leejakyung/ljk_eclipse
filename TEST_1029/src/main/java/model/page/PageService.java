package model.page;

import model.shoes.ShoesVO;

public interface PageService {
	public PageVO paging(PageVO pVO, ShoesVO sVO, String table);
	
}
