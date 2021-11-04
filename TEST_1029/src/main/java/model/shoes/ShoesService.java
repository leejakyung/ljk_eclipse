package model.shoes;

import java.util.List;

import model.page.PageVO;

public interface ShoesService {
	List<ShoesVO> getShoesList(ShoesVO vo,PageVO pVO);
	ShoesVO getShoesData(ShoesVO vo);
	boolean s_insert(ShoesVO vo);
	boolean s_update(ShoesVO vo);
	boolean s_delete(ShoesVO vo);
}
