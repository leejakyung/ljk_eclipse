package model.letter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBC; 

public class LetterDAO {

	public ArrayList<LetterVO> getDBList(){
		Connection conn=JDBC.connect();
		ArrayList<LetterVO> datas=new ArrayList();
		PreparedStatement pstmt=null;
		try{
			String sql="select * from letter order by lnum desc"; // 내림차순 사용
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				LetterVO vo=new LetterVO();
				vo.setContent(rs.getString("content"));
				vo.setLnum(rs.getInt("lnum"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setWriter(rs.getString("writer"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBList()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}

		return datas;
	}

	public LetterVO getDBData(LetterVO vo){
		Connection conn=JDBC.connect();
		LetterVO data=null;
		PreparedStatement pstmt=null;
		try{
			String sql="select * from letter where lnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getLnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new LetterVO();
				data.setContent(rs.getString("content"));
				data.setLnum(rs.getInt("lnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setWriter(rs.getString("writer"));
			}
			rs.close();
		}
		catch(Exception e){
			System.out.println("getDBData()에서 출력");
			e.printStackTrace();
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return data;
	}

	public boolean insertDB(LetterVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{ 
			String sql="insert into letter values((select nvl(max(lnum),0)+1 from letter),?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter()); 
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("insertDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean deleteDB(LetterVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try {
			String sql="delete from letter where lnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setInt(2, vo.getLnum()); 
			pstmt.executeUpdate();
			res=true;
			
		} catch(Exception e){
			System.out.println("updateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

	public boolean updateDB(LetterVO vo) {
		Connection conn=JDBC.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			String sql="update message set writer=?, title=?, content=?, wdate=sysdate where lnum=?"; // sysdate 날짜 기본 설정
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getLnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("updateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			JDBC.disconnect(pstmt,conn);
		}
		return res;
	}

}
