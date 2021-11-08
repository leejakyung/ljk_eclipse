package model.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private SpringClient2DAO client2DAO;
	
	@Override
	public boolean insert(Client2VO vo) {
		return client2DAO.insert(vo);
	}

	@Override
	public boolean update(Client2VO vo) {
		return client2DAO.update(vo);
	}

	@Override
	public boolean delete(Client2VO vo) {
		return client2DAO.delete(vo);
	}

	@Override
	public Client2VO login(Client2VO vo) {
		try {
			return client2DAO.login(vo);
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public boolean checkID(String userID) {
		try { // 실행이 되면 true
			client2DAO.checkID(userID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean checkEmail(String email) {
		try { // 실행이 되면 true
			client2DAO.checkEmail(email);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*
	@Override
	public Client2VO SelectOne(Client2VO vo) {
		return client2DAO.SelectOne(vo);
	}

	@Override
	public boolean UpdatePW(Client2VO vo) {
		return client2DAO.UpdatePW(vo);
	}*/


}
