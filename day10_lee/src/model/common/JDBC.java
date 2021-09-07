package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {

	public static Connection getConnection() {
		
		Connection conn = null; // scope ���� �ذ��ϱ� ���� null�� �ʱ�ȭ �� �̿�
		
		String DName_oracle = "oracle.jdbc.driver.OracleDriver";  // JDBC�� ����̹� Ŭ������
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="kim";
		String password="1234";
		
		try {
			Class.forName(DName_oracle);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}

	public static void Close(Connection conn, PreparedStatement pstmt) {
		
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		try{
			pstmt.close();
			conn.close();
		}
		catch(Exception e){
			System.out.println("disconnect()���� ���");
			e.printStackTrace();
		}
	}
	
}