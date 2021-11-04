package model.mine;

import java.util.List;

import model.shoes.ShoesVO;

public interface MineService {
	MineVO mine(MineVO vo); 
	boolean mIns(MineVO vo);
	boolean mDel(MineVO vo);
	List<ShoesVO> getShoesList(MineVO vo);
}
