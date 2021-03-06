package model.message;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JNDI;


public class MessageDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	boolean flag=false;
	public ArrayList<MsgSet> selectAll(String userID,int cnt){ // 뷰에서 mcnt
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		conn = JNDI.connect();
		String sql;
		
	
		//System.out.println("3");
		try {
			if((userID==null) || (userID.equals(""))){
				//System.out.println("6");
				// sql = "select * from message order by date desc limit 0,?";
				// sql="select * from message where rownum <=? order by mdate desc"; // 댓글을 2개만 보여주겠다. asc 오름차순
				sql = "select * from (select * from message order by mdate desc) where rownum<=?";
				// sql="select * from message order by date desc";
				pstmt =conn.prepareStatement(sql);
				pstmt.setInt(1, cnt);
				
			} 
			else {
				//System.out.println("7");
				sql = "select * from (select * from message order by mdate desc) where userID = ? and rownum<=?";
				// sql= "select *from message where uid=? order by date desc limit 0,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				pstmt.setInt(2, cnt);
			}
			rs = pstmt.executeQuery();
			//System.out.println("5");
			while(rs.next()) {
				//System.out.println("4");
				MsgSet ms = new MsgSet();
				MessageVO m = new MessageVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();

				m.setMid(rs.getInt("mid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setReplycount(rs.getInt("replycount"));
				m.setUserID(rs.getString("userID"));
				m.setMdate(rs.getDate("mdate"));

				String rsql = "select * from reply where mid=? order by rid desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1, rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				//int rcnt=0;
				while(rrs.next()) {
					System.out.println("5");
					ReplyVO r = new ReplyVO();
					r.setRdate(rrs.getDate("rdate"));
					r.setMid(rrs.getInt("mid"));
					r.setRid(rrs.getInt("rid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserID(rrs.getString("userID"));
					rlist.add(r);
					// rcnt++;
				}
				// m.setReplycount(rs.getInt("replycount"));

				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}		
		return datas;
	}
	public boolean insert(MessageVO vo) {
		System.out.println("인서트0");
		conn =JNDI.connect();
		String sql = "insert into message(mid,userID, msg, mdate) values(nvl((select max(mid) from message),0)+1, ?, ?, sysdate)";
		System.out.println("인서트1");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
			System.out.println("인서트2");
			
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}
	public boolean delete(MessageVO vo) {
		conn = JNDI.connect();
		String sql = "delete from message where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
			
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
			/*try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
		return flag;	
	}
	public void update(MessageVO vo) {
		conn = JNDI.connect();
		String sql = "update message set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
			System.out.println("확인");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JNDI.disconnect(pstmt, conn);
		}
	}
}