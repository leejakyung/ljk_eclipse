package model.shoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;

public class ShoesDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	boolean flag=false;
	
	String s_insert="insert into shoes values(?,?,?,?,?,?)"; // �Ź� ���� �߰�
	String s_delete="delete from shoes where spk=?"; //  �Ź� ���� ����
	String s_update="update shoes set spk=?, filename=?, brandname=?, sname=?, price=?, sdate=? where spk=?"; // �Ź� ���� ����
	String s_selectAll="select * from shoes order by spk dese"; // �Ź� �Խù� ��� ����
	String s_selectOne="select * from shoes where spk=?"; // �Ź� �Խù� ��������
	
	public ArrayList<ShoesVO> getShoesList(){ // �Ź� �Խù� ��� ����
		ArrayList<ShoesVO> datas = new ArrayList<ShoesVO>();
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(s_selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ShoesVO data = new ShoesVO();
				data.setSpk(rs.getString("spk"));
				data.setFilename(rs.getString("filename"));
				data.setBrandname(rs.getString("brandname"));
				data.setSname(rs.getString("sname"));
				data.setPrice(rs.getInt("price"));
				data.setSdate(rs.getString("sdate"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ShoesVO getShoesData(ShoesVO vo) { // �Ź� �Խù� ��������
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(s_selectOne);
			pstmt.setString(1, vo.getSpk());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setSpk(rs.getString("spk"));
				vo.setFilename(rs.getString("filename"));
				vo.setBrandname(rs.getString("brandname"));
				vo.setSname(rs.getString("sname"));
				vo.setPrice(rs.getInt("price"));
				vo.setSdate(rs.getString("sdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return vo;
	}
	
	public boolean s_insert(ShoesVO vo) { // �Ź� �Խù� ���
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(s_insert);
			pstmt.setString(1, vo.getSpk());
			pstmt.setString(2, vo.getFilename());
			pstmt.setString(3, vo.getBrandname());
			pstmt.setString(4, vo.getSname());
			pstmt.setInt(5, vo.getPrice());
			pstmt.setString(6, vo.getSdate());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		
		return flag;
	}
	
	public boolean s_delete(ShoesVO vo) { // �Ź� �Խù� ����
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(s_delete);
			pstmt.setString(1, vo.getSpk());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
		
	}
	
	public boolean s_update(ShoesVO vo) { // �Ź� �Խù�  ����
		conn=JNDI.connect();
		
		try {
			pstmt=conn.prepareStatement(s_update);
			pstmt.setString(1, vo.getSpk());
			pstmt.setString(2, vo.getFilename());
			pstmt.setString(3, vo.getBrandname());
			pstmt.setString(4, vo.getSname());
			pstmt.setInt(5, vo.getPrice());
			pstmt.setString(6, vo.getSdate());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}
}
