package com.kim.app.model.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private MybatisClientDAO clientDAO;
	
	public ClientVO login(ClientVO vo) {
		return clientDAO.login(vo);
	}

	public boolean c_update(ClientVO vo) {
		return clientDAO.update(vo) > 0;
	}

	public boolean c_delete(ClientVO vo) {
		return  clientDAO.delete(vo) > 0;
	}

	public boolean c_insert(ClientVO vo) {
		return  clientDAO.insert(vo) > 0;
	}

	public boolean checkID(String id) {
		return clientDAO.checkID(id)!=null;
	}

	public ClientVO c_selectDB_one(ClientVO vo) {
		return clientDAO.checkID(vo.getId());
	}

}
