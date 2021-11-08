package model.client2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class ClientRowMapper implements RowMapper<Client2VO>{

	@Override
	public Client2VO mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client2VO data=new Client2VO();
		data.setEmail(rs.getString("email"));
		data.setUserID(rs.getString("userID"));
		data.setUserPW(rs.getString("userPW"));
		return data;
	}
	
}

@Repository
public class SpringClient2DAO {

	private final String login="select * from client2 where email=? and userPW=?"; //로그인
	private final String c_insert="insert into client2 values (?,?,?)"; // 회원가입
	private final String c_delete="delete from client2 where email=?"; // 회원탈퇴
	private final String c_update="update client2 set email=?, userID=?, userPW=? where email=?"; // 회원정보수정
	private final String Email="select * from client2 where email=?"; // 유효성검사 
	private final String UserID="select * from client2 where userID=?"; // 유효성검사 
	//private final String UpdatePW="update client2 set userPW=? where email=?"; // 임시비밀번호발급
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean insert(Client2VO vo) {
		if(jdbcTemplate.update(c_insert,vo.getEmail(),vo.getUserID(),vo.getUserPW())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public boolean update(Client2VO vo) {
		if(jdbcTemplate.update(c_update,vo.getEmail(),vo.getUserID(),vo.getUserPW(),vo.getEmail())>=1) {;
			return true;
		} else {
			return false;
		}
	}
	public boolean delete(Client2VO vo) {
		if(jdbcTemplate.update(c_delete,vo.getEmail())>=1) {
			return true;
		} else {
			return false;
		}
	}
	public Client2VO login(Client2VO vo) {
		Object[] args= { vo.getEmail(),vo.getUserPW()};
		return jdbcTemplate.queryForObject(login,args,new ClientRowMapper());
		 
	}
	
	public Client2VO checkID(String userID) {
		Object[] args= {userID};
		return jdbcTemplate.queryForObject(UserID,args,new ClientRowMapper());
	}
	
	public Client2VO checkEmail(String email) {
		Object[] args= {email};
		return jdbcTemplate.queryForObject(Email,args,new ClientRowMapper());
	}

}
