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
	
	public ArrayList<MsgSet> selectAll(){
	      ArrayList<MsgSet> datas=new ArrayList<MsgSet>();
	      conn=JNDI.connect();
	      String sql;
	      try {
	         sql="select * from message order by mdate desc";
	         pstmt=conn.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            MsgSet ms=new MsgSet();
	            MessageVO m=new MessageVO();
	            ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>();

	            m.setMid(rs.getInt("mid"));
	            m.setMsg(rs.getString("msg"));
	            m.setFavcount(rs.getInt("favcount"));
	            m.setUserID(rs.getString("userID"));
	            m.setMdate(rs.getDate("mdate"));
	            System.out.println("mt");
	            

	            String rsql="select * from reply where mid=? order by rdate desc";
	            pstmt=conn.prepareStatement(rsql);
	            pstmt.setInt(1, rs.getInt("mid"));
	            ResultSet rrs=pstmt.executeQuery();
	            int rcnt=0;
	            while(rrs.next()) {
	            	System.out.println("체크");
	               System.out.println("r");
	               ReplyVO r=new ReplyVO();
	               r.setRdate(rrs.getDate("rdate"));
	               r.setMid(rrs.getInt("mid"));
	               r.setRid(rrs.getInt("rid"));
	               r.setRmsg(rrs.getString("rmsg"));
	               r.setUserID(rrs.getString("userID"));
	               rlist.add(r);
	               rcnt++;
	            }
	            m.setReplycount(rcnt);

	            ms.setM(m);
	            ms.setRlist(rlist);
	            datas.add(ms);
	            rrs.close();
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         try {
	            rs.close();
	            pstmt.close();
	            conn.close();
	         }catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      return datas;
	   }

	/*private ArrayList<MsgSet> selectAll(){ // 뷰에서 mcnt
		ArrayList<MsgSet> datas = new ArrayList<MsgSet>();
		conn = JNDI.connect();
		String sql;
		try {
			// if((uid==null) || (uid.equals(""))){
				// sql = "select * from message order by date desc limit 0,?";
				// sql="select * from message where rownum <=2 order by datetime"; // 댓글을 2개만 보여주겠다.
				sql="select * from message order by date desc";
				pstmt =conn.prepareStatement(sql);
				// pstmt.setInt(1, cnt);
			} 
			else {
				sql= "select * from message where uid=?, rownum<=? order by datetime desc";
				// sql= "select *from message where uid=? order by date desc limit 0,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				pstmt.setInt(2, cnt);
			}
			rs = pstmt.executeQuery();

			while(rs.next()) {
				MsgSet ms = new MsgSet();
				MessageVO m = new MessageVO();
				ArrayList<ReplyVO> rlist = new ArrayList<ReplyVO>();

				m.setMid(rs.getInt("mid"));
				m.setMsg(rs.getString("msg"));
				m.setFavcount(rs.getInt("favcount"));
				m.setUserID(rs.getString("userID"));
				m.setMdate(rs.getDate("mdate"));

				String rsql = "select * from reply where mid=? order by date desc";
				pstmt = conn.prepareStatement(rsql);
				pstmt.setInt(1, rs.getInt("mid"));
				ResultSet rrs = pstmt.executeQuery();
				int rcnt=0;
				while(rrs.next()) {
					ReplyVO r = new ReplyVO();
					r.setRdate(rrs.getDate("rdate"));
					r.setMid(rrs.getInt("mid"));
					r.setRid(rrs.getInt("rid"));
					r.setRmsg(rrs.getString("rmsg"));
					r.setUserID(rrs.getString("userID"));
					rlist.add(r);
					rcnt++;
				}
				m.setReplycount(rcnt);

				ms.setM(m);
				ms.setRlist(rlist);
				datas.add(ms);
				rrs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return datas;
	}*/
	public boolean insert(MessageVO vo) {
		conn =JNDI.connect();
		String sql = "insert into message(uid, msg, date) values(?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	public boolean delete(MessageVO vo) {
		conn = JNDI.connect();
		String sql = "delete from message where mid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
	}
	public void update(MessageVO vo) {
		conn = JNDI.connect();
		String sql = "update message set favcount=favcount+1 where mid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}