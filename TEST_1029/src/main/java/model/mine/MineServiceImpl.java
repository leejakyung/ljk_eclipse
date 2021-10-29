package model.mine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("mineService")
public class MineServiceImpl implements MineService{

	@Autowired
	private SpringMineDAO mineDAO;
	
	@Override
	public boolean mine(MineVO vo) {
		return mineDAO.mine(vo);
	}

}
