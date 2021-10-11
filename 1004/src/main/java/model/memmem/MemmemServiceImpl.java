package model.memmem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memmemService")
public class MemmemServiceImpl implements MemmemService {

	@Autowired
	private SpringMemDAO memmemDAO;
	
	@Override
	public MemmemVO getMem(MemmemVO vo) {
		// TODO Auto-generated method stub
		return memmemDAO.getMem(vo);
	}


}
