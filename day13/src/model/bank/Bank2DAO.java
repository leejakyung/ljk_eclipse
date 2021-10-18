package model.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;


public class Bank2DAO {
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	Bank2VO data= null;
	

	public Bank2VO getBank2() {
		conn=JNDI.connect();
		String sql="select * from bank2 where bid= 2001";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
			data = new Bank2VO();
			data.setBid(rs.getInt("bid"));
			data.setName(rs.getString("name"));
			data.setBalance(rs.getInt("balance")); 
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return data; // void가 아닐때는 리턴해줘야함
	}
	
	
	
	public boolean trans(int bal) {
		conn=JNDI.connect();
		try {
			conn.setAutoCommit(false); // set autocommit=0;
			String sql1="update bank2 set balance=balance-? where bid=2001";
			String sql2="update bank1 set balance=balance+? where bid=1001";
			
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, bal);
			pstmt.executeUpdate();
			
			
			
			// ResultSet rs=pstmt.executeQuery("select balance from bank1 where bid=1001");
			String sql= "select balance from bank2 where bid=2001";
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
			JNDI.disconnect(pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return true;
	}
	
}
