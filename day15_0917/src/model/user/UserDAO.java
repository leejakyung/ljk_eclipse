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
		String sql = "insert into clients(userID,name,upw,udate) values(?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
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
		String sql="select userID,upw from clients where userID =?";
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
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
		//String sql = "select * from clients order by udate desc limit 0,3";
		// String sql="select * from clients where rownum <=3 order by udate desc"; -> 잘못된 방식
		String sql="select * from (select * from clients order by udate desc) where rownum<=3";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserVO data=new UserVO();
				data.setUdate(rs.getDate("udate"));
				data.setName(rs.getString("name"));
				data.setUpw(rs.getString("upw"));
				data.setUserID(rs.getString("userID"));
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
	

