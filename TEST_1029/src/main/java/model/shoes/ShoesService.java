package model.shoes;

import java.util.List;

public interface ShoesService {
	List<ShoesVO> getShoesList(ShoesVO vo);
	ShoesVO getShoesData(ShoesVO vo);
	boolean s_insert(ShoesVO vo);
	boolean s_update(ShoesVO vo);
	boolean s_delete(ShoesVO vo);
}
