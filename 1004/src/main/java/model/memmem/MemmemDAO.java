package model.memmem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.common.JDBC;

@Repository("MemmemDAO")
public class MemmemDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*private final String insertSQL="insert into memmem values (?,?,?,?)";
	private final String updateSQL="update memmem set id=?, password=?, name=?, role=? where id=?";
	private final String deleteSQL="delete from memmem where id=?";
	private final String getMemListSQL="select * from memmem order by id desc";*/
	private final String getMemSQL="select * from memmem where id =? and password=?";
	
	public MemmemVO getMem(MemmemVO vo) {
		// 로그인에 성공한다면, MemmemVO 객체가 리턴(반환)
		// 실패한다면, 리턴이 null
		MemmemVO data=null;
		
		System.out.println("MemmemDAO로 get");
		
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemmemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		
		return data;
	}
	
	
/*
	public void insertMemmem(MemmemVO vo) {
		System.out.println("mem dao로 insert");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateMemmem(MemmemVO vo) {
		System.out.println("mem dao로 update");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getRole());
			pstmt.setString(5, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void deleteMemmem(MemmemVO vo) {
		System.out.println("mem dao로 delete");
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1, vo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}
		
	}
	
	public MemmemVO getMem(MemmemVO vo) {
		System.out.println("mem dao로 get");
		MemmemVO data=null;
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemSQL);
			pstmt.setString(1, vo.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemmemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		return data;
	}
	
	public List<MemmemVO> getMemList(MemmemVO vo){
		System.out.println("mem dao로 getList");
		List<MemmemVO> datas=new ArrayList<MemmemVO>();
		
		try {
			conn=JDBC.getConnection();
			pstmt=conn.prepareStatement(getMemListSQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemmemVO data=new MemmemVO();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt, rs);
		}
		return datas;
	}*/
}
