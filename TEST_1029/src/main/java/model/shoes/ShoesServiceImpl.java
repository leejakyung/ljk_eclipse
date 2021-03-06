package model.shoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.page.PageVO;

@Service("ShoesService")
public class ShoesServiceImpl implements ShoesService{
	
	@Autowired
	private SpringShoesDAO shoesDAO;

	@Override
	public List<ShoesVO> getShoesList(ShoesVO vo,PageVO pVO) {
		return shoesDAO.getShoesList(vo, pVO);
	}

	@Override
	public ShoesVO getShoesData(ShoesVO vo) {
		return shoesDAO.getShoesData(vo);
	}

	@Override
	public boolean s_insert(ShoesVO vo) {
		return shoesDAO.s_insert(vo);
	}

	@Override
	public boolean s_update(ShoesVO vo) {
		return shoesDAO.s_update(vo);
	}

	@Override
	public boolean s_delete(ShoesVO vo) {
		return shoesDAO.s_delete(vo);
	}

}
