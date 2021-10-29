package model.comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.client2.Client2VO;
import model.common.JNDI;

public class CommentsDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	boolean flag=false;

	String m_selectAll= "select * from comments order by cnum desc"; // 모든 코멘트 보기
	String m_selectOne="select * from comments where userID=? order by cnum desc"; // 내 코멘트 보기
	String m_insert="insert into comments(cnum,userID,title,content,cdate) values (nvl((select max(cnum) from message2),0)+1, ?, ?, ?, sysdate)"; // 코멘트 등록
	String m_delete="delete from comments where cnum=?"; // 코멘트 삭제
	String m_update="update comments set title=?, content=?, cdate= sysdate where cnum=?"; // 코멘트 수정
	String realSelectOne="select * from comments where cnum=?";
	
	
	public CommentsVO getDBData(CommentsVO vo) {
		conn=JNDI.connect();
		System.out.println("selectone :"+vo.getCnum());
		try {
			pstmt=conn.prepareStatement(realSelectOne);
			pstmt.setInt(1, vo.getCnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setCnum(rs.getInt("cnum"));
				vo.setUserID(rs.getString("userID"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setCdate(rs.getString("cdate"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return vo;
		
		
	}
	
	
	
	public ArrayList<CommentsVO> getDBList(Client2VO vo){ // 모든 게시글 보기
		ArrayList<CommentsVO> datas = new ArrayList<CommentsVO>();
		conn=JNDI.connect();
		
		
		try {
			
			if(vo == null ) {
				pstmt=conn.prepareStatement(m_selectAll);
			}
			
			else{
				pstmt=conn.prepareStatement(m_selectOne);
				pstmt.setString(1, vo.getUserID());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				CommentsVO data = new CommentsVO();
				data.setContent(rs.getString("content"));
				data.setCnum(rs.getInt("cnum"));
				data.setTitle(rs.getString("title"));
				data.setCdate(rs.getString("cdate"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		System.out.println("mDAO selectAll : " + datas);
		return datas;
	
	}
	
	

	
	/*public ArrayList<Message2VO> getMyDBList(Client2VO vo){ // 내가 쓴 글 보기
		conn=JNDI.connect();
		ArrayList<Message2VO> datas= new ArrayList<Message2VO>();
		
		try {
			pstmt=conn.prepareStatement(m_selectOne);
			pstmt.setString(1, vo.getUserID());
			ResultSet rs = pstmt.executeQuery();		
			while(rs.next()) {
				Message2VO data = new Message2VO();
				data.setContent(rs.getString("content"));
				data.setMnum(rs.getInt("mnum"));
				data.setTitle(rs.getString("title"));
				data.setWdate(rs.getDate("wdate"));
				data.setUserID(rs.getString("userID"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return datas;
	}*/
	
	 public boolean m_insert(CommentsVO vo) { // 게시글 등록
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_insert);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		 return flag;
		 
	 }
	 
	 public boolean m_delete(CommentsVO vo) { // 게시글 삭제
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_delete);
			pstmt.setInt(1, vo.getCnum());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	 }
	 
	 public boolean m_update(CommentsVO vo) { // 게시글 수정 
		 conn=JNDI.connect();
		 
		 try {
			pstmt=conn.prepareStatement(m_update);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getCnum());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	 }
}
