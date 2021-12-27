package com.kim.app.model.client;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
	public ClientVO login(ClientVO vo);
	public ClientVO checkID(String id);
	public int update(ClientVO vo);
	public int delete(ClientVO vo);
	public int insert(ClientVO vo);	
}
// DAO 는 xml이랑 맞추고 ,
// service는 controller 메서드명과 맞춤

// 하나의 sql문 이름과 맞춰서 메서드명 작성