package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBC;
import model.message.MessageVO;

public class MemberDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public boolean login(MemberVO invo) { // 로그인 인증
		
		conn = JDBC.getConnection();
		String sql = "select * from members where userID = ? and userPW = ?";
		
		MemberVO outvo = null;
		boolean exist = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, invo.getUserID());
			pstmt.setString(2, invo.getUserPW());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				outvo = new MemberVO();
				outvo.setUserID(rs.getString("userID"));
				outvo.setUserPW(rs.getString("userPW"));
				outvo.setName(rs.getString("name"));
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
	
	public boolean signUp(MemberVO invo) { // 회원가입 시 데이터 추가
		conn = JDBC.getConnection();
		String sql = "insert into members values (?,?,?)";
		
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, invo.getUserID());
			pstmt.setString(2, invo.getUserPW());
			pstmt.setString(3, invo.getName());
			pstmt.executeUpdate();
			result = true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return result;
	}
	
	public boolean checkID(String userID) {
		
		conn = JDBC.getConnection();
		String sql = "select * from members where userID = ?";
		
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
	
	public MemberVO getMemData(MemberVO vo) {
		System.out.println(vo.getUserID());
		conn = JDBC.getConnection();
		MemberVO data = null;

		String sql = "select * from members where userID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("DAO확인!");
				data = new MemberVO();
				data.setUserID(rs.getString("userID"));
				data.setUserPW(rs.getString("userPW"));
				data.setName(rs.getString("name"));
			}

			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return data;
	}
	
	// 회원 탈퇴
	public boolean deleteMemDB(MemberVO vo) {

		conn = JDBC.getConnection();
		boolean result = false;

		String sql = "delete from members where userID = ?";

		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.executeUpdate();

			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return result;
	}

	// 회원정보 수정
	public boolean updateMemDB(MemberVO vo) {

		conn = JDBC.getConnection();
		boolean result = false;

		String sql = "update members set userID = ?, userPW = ?, name = ? where userID = ?";

		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getUserID());
			pstmt.executeUpdate();

			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.Close(conn, pstmt);
		}
		return result;
	}
}
