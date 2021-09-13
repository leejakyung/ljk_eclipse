package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean insert(UserVO vo) {
		conn = JNDI.connect();
		String sql = "insert into user(uid,name,upw,udate) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getUpw());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public boolean login(UserVO vo) {
		conn=JNDI.connect();
		String sql="select uid,upw from user where uid =?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUid());
			rs = pstmt.executeQuery();
			rs.next();
			if(rs.getString("upw").equals(vo.getUpw())) {
				result = true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList<UserVO> selectAll() {
		ArrayList<UserVO> datas = new ArrayList<UserVO>();
		conn = JNDI.connect();
		String sql = "select * from user order by udate desc limit 0,3";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO data=new UserVO();
				data.setUdate(rs.getDate("udate"));
				data.setName(rs.getString("name"));
				data.setUpw(rs.getString("upw"));
				data.setUid(rs.getString("uid"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return datas;
	}
}
	

