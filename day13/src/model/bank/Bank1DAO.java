package model.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBC;


public class Bank1DAO {
	Connection conn=null;
	PreparedStatement pstmt=null;

	Bank1VO data= null;
	

	public Bank1VO getBank1() {
		conn=JDBC.connect();
		String sql="select * from bank1 where bid = 1001";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
			data = new Bank1VO();
			data.setBid(rs.getInt("bid"));
			data.setName(rs.getString("name"));
			data.setBalance(rs.getInt("balance")); 
			}
			System.out.println(data);
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt, conn);
		}
		return data; // void가 아닐때는 리턴해줘야함
	}
	
	
	public boolean trans(int bal) {
		conn=JDBC.connect();
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="update bank1 set balance=balance-? where bid=1001";
			String sql2="update bank2 set balance=balance+? where bid=2001";
			
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			
			
			
			// ResultSet rs=pstmt.executeQuery("select balance from bank1 where bid=1001");
			String sql= "select balance from bank1 where bid=1001";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)<0) { // 잔액이 0미만이면,
				conn.rollback(); // 다시 처음으로 ...?
				return false;
			}
			else {
				conn.commit(); // commit;
			}
			
			
			
			
			conn.setAutoCommit(true); // set autocommit=0;
			rs.close();
			JDBC.disconnect(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return true;
	}
	
}
