package model.mine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class MineDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	boolean flag = false;
	
	String mine="select * from mine spk=? and email=?";
	
	public boolean mine(MineVO vo) {
		conn=JNDI.connect();
		String sql;
		try {
			pstmt=conn.prepareStatement(mine);
			pstmt.setString(1, vo.getSpk());
			pstmt.setString(2, vo.getEmail());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				sql="delete from mine where spk=? and email=?";
				pstmt=conn.prepareStatement(sql);
			} else {
				sql="insert into mine values(nvl((select max(mpk) from mine),0)+1, ?, ?)";
				pstmt=conn.prepareStatement(sql);
			}
			pstmt.setString(1, vo.getSpk());
			pstmt.setString(2, vo.getEmail());
			pstmt.executeUpdate();
			
			flag= true;
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
		
	}
}
