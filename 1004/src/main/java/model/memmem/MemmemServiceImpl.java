package model.memmem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memmemService")
public class MemmemServiceImpl implements MemmemService {

	@Autowired
	private MemmemDAO memmemDAO;
	
	@Override
	public void insertMemmem(MemmemVO vo) {
		memmemDAO.insertMemmem(vo);
	}

	@Override
	public void updateinsertMemmem(MemmemVO vo) {
		memmemDAO.updateMemmem(vo);
	}

	@Override
	public void deleteMemmem(MemmemVO vo) {
		memmemDAO.deleteMemmem(vo);
	}

	@Override
	public MemmemVO getMem(MemmemVO vo) {
		// TODO Auto-generated method stub
		return memmemDAO.getMem(vo);
	}

	@Override
	public List<MemmemVO> getMemList(MemmemVO vo) {
		// TODO Auto-generated method stub
		return memmemDAO.getMemList(vo);
	}

}
