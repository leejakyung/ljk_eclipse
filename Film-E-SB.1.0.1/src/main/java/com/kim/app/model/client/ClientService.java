package com.kim.app.model.client;

// DAO에 있는것을 이곳의 함수명과 맞춰줌 
public interface ClientService {
	public ClientVO login(ClientVO vo);
	public boolean checkID(String id);
	public boolean c_update(ClientVO vo);
	public boolean c_delete(ClientVO vo);
	public boolean c_insert(ClientVO vo);	
	public ClientVO c_selectDB_one(ClientVO vo); // 회원 정보 변경시 쓰는 함수
}
