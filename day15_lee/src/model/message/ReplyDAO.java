package model.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.common.JNDI;

public class ReplyDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	
	public boolean insert(ReplyVO vo) {
		boolean result = false;
		conn = JNDI.connect();
		String sql = "insert into reply(rid,mid,userID,rmsg,rdate) values(nvl((select max(rid) from reply),0)+1, ?, ?, ?, sysdate)";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.setString(2, vo.getUserID());
			pstmt.setString(3, vo.getRmsg()); 
			pstmt.executeUpdate();
			
			sql= "update message set replycount = replycount+1 where mid = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
			
			conn.setAutoCommit(true);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if(result) {
					conn.commit();
				}
				else {
					conn.rollback();
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean delete(ReplyVO vo) {
		conn = JNDI.connect();
		String sql = "delete from reply where rid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
}
