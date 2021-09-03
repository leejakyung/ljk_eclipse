package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private Connection conn=null;
	private PreparedStatement pstmt=null;

	public boolean login(LoginVO invo) {
		conn=JDBC.getConnection();
		String sql="select * from login where userID=? and userPW=?";

		LoginVO outvo=null;
		boolean exist = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, invo.getUserID());
			pstmt.setString(2, invo.getUserPW());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				outvo = new LoginVO();
				outvo.setUserID(rs.getString("userID"));
				outvo.setUserPW(rs.getString("userPW"));
				exist = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return exist;
	}
	public boolean checkID(String userID) {

		conn = JDBC.getConnection();
		String sql = "select * from login where userID = ?";

		boolean exist = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				exist = true;
			}

			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return exist;
	}
}
