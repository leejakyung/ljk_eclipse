package model.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class CommentDAO {



	Connection conn = null;
	PreparedStatement pstmt = null;

	// ���� ��� ��ȸ -> ��� ������ �ҷ����� (selectAll)
	public ArrayList<CommentVO> getDBList() {

		ArrayList<CommentVO> datas = new ArrayList<CommentVO>();

		try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl"); 

			conn=ds.getConnection();
			String sql = "select * from review order by rpk desc"; // �ֱ� ������� ��ȸ

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO data = new CommentVO();
				data.setRpk(rs.getInt("rpk"));
				data.setRid(rs.getString("rid"));
				data.setRpw(rs.getString("rpw"));
				data.setReview(rs.getString("review"));
				data.setRdate(rs.getDate("rdate"));
				datas.add(data);
			}
			rs.close();


		}
		catch(Exception e){
			System.out.println(e);
		}
		return datas;
	}

	// ����  �� ���� ��ȸ(selectOne)
	public ArrayList<CommentVO> getMyDBList(String rid) {

		ArrayList<CommentVO> datas = new ArrayList<CommentVO>();

		try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl"); 

			conn=ds.getConnection();

			String sql = "select * from review where rid = ? order by rpk desc"; // �ֱ� ������� ��ȸ

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CommentVO data = new CommentVO();
				data.setRpk(rs.getInt("rpk"));
				data.setRid(rs.getString("rid"));
				data.setReview(rs.getString("review"));
				data.setRdate(rs.getDate("rdate"));
				datas.add(data);
			}

			rs.close();

		} catch (Exception e) {
			System.out.println(e);
		} 
		return datas;
	}

	// ���� ���
	public boolean insertDB(CommentVO vo) {


		boolean result = false;

		String sql = "insert into review (rpk, rid, review, rdate) values (nvl((select max(rpk) from review),0)+1, ?, ?, sysdate)";

		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRid());
			pstmt.setString(2, vo.getReview());
			pstmt.executeUpdate();

			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	// ���� ����
	public boolean deleteDB(CommentVO vo) {


		boolean result = false;

		String sql = "delete from review where rpk = ?";

		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getRpk());
			pstmt.executeUpdate();

			result = true;

		} catch (Exception e) {
			System.out.println(e);
		} 
		return result;
	}

	// ���� ����
	public boolean updateDB(CommentVO vo) {

		boolean result = false;

		String sql = "update review set rid = ?, review = ?, rdate = sysdate where rpk = ?";

		try {			
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl"); 

			conn=ds.getConnection();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRid());
			pstmt.setString(2, vo.getReview());
			pstmt.setInt(3, vo.getRpk());
			pstmt.executeUpdate();

			result = true;

		} catch (Exception e) {
			System.out.println(e);
		} 
		return result;
	}


	public CommentVO login(CommentVO invo) { // �α��� ����


		String sql = "select * from review where rid = ? and rpw = ?";

		CommentVO outvo = null;
		
		try {
			Context initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			DataSource ds=(DataSource)envContext.lookup("jdbc/orcl"); 

			conn=ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, invo.getRid());
			pstmt.setString(2, invo.getRpw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				outvo = new CommentVO();
				outvo.setRpk(rs.getInt("rpk"));
				outvo.setRid(rs.getString("rid"));
				outvo.setRpw(rs.getString("rpw"));
				outvo.setReview(rs.getString("review"));
				outvo.setRdate(rs.getDate("rdate"));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		return outvo;
	}

}
