package model.member2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("member2Service")
public class Member2ServiceImpl implements Member2Service {

	@Autowired
	private SpringMember2DAO member2DAO;
	

	/*
	@Override
	public void updateinsertMem(Member2VO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMem(Member2VO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member2VO> getMemList(Member2VO vo) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Member2VO> getMem(Member2VO vo) { // try/catch 를  쓴다면 예외처리를 생각했다고 어필하고 지금과 같이 처리했다면 최적화를 생각했다고 어필 !
		return member2DAO.getMem(vo);
	}


	@Override
	public void insertMem(Member2VO vo) {
		member2DAO.insertMem(vo);
	}

}
