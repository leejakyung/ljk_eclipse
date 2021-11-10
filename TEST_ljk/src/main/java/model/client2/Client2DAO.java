package model.client2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JNDI;

public class Client2DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	String login="select * from client2 where email=? and userPW=?"; //�α���
	String c_insert="insert into client2 values (?,?,?)"; // ȸ������
	String c_delete="delete from client2 where email=?"; // ȸ��Ż��
	String c_update="update client2 set email=?, userID=?, userPW=? where email=?"; // ȸ����������

	boolean flag=false;

	public Client2VO login(Client2VO vo) {  // �α���
		conn=JNDI.connect();

		Client2VO outvo = null;

		try {
			pstmt=conn.prepareStatement(login);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getUserPW());
			rs=pstmt.executeQuery();
			if (rs.next()) { // ��ġ�ϴ� ȸ�� ID,PW�� �ִٸ� ... 
				outvo = new Client2VO();
				outvo.setEmail(rs.getString("email"));
				outvo.setUserID(rs.getString("userID"));
				outvo.setUserPW(rs.getString("userPW"));
			} // �� ������ �޾ƿͼ� return ���ָ� ȸ������ ������ �Ҷ� ��
			// return flag�� �ϸ� ID���� �޾ƿ��ϱ� .. .
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return outvo;

	}

	public boolean insert(Client2VO vo) { // ȸ������
		conn=JNDI.connect();

		try {
			pstmt =conn.prepareStatement(c_insert);
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
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

	public boolean delete(Client2VO vo) { // ȸ�� Ż��
		conn=JNDI.connect();

		try {
			pstmt=conn.prepareStatement(c_delete);
			pstmt.setString(1, vo.getEmail());
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

	public boolean update(Client2VO vo) { // ȸ�� ���� ����
		conn=JNDI.connect();

		try {
			pstmt=conn.prepareStatement(c_update);
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPW());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();

			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}

		return flag;

	}

	public boolean checkID(String userID) { // �г��� �ߺ�Ȯ��  

		conn = JNDI.connect();
		String sql = "select * from client2 where userID = ?";

	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				flag = true;
			}

			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}

	public boolean checkEmail(String email) { // �̸��� �ߺ�Ȯ��  

		conn = JNDI.connect();
		String sql = "select * from client2 where email = ?";

	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				flag = true;
			}

			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JNDI.disconnect(pstmt, conn);
		}
		return flag;
	}
}
