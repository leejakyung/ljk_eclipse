package model.mine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.shoes.ShoesVO;

@Service("mineService")
public class MineServiceImpl implements MineService{

	@Autowired
	private SpringMineDAO mineDAO;
	

	@Override
	public MineVO mine(MineVO vo) {
		try {
			System.out.println("mine vo" + vo);
			return mineDAO.mine(vo);
			
		} catch (Exception e) {
			System.out.println("mine null");
			return null;
		}
		
	}

	@Override
	public boolean mIns(MineVO vo) {
		return mineDAO.mineIns(vo);
	}

	@Override
	public boolean mDel(MineVO vo) {
		return mineDAO.mineDel(vo);
	}

	@Override
	public List<ShoesVO> getShoesList(MineVO vo) {
		return mineDAO.getShoesList(vo);
	}

}
