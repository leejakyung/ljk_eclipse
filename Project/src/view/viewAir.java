package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
/*
class Member{
	String id;
	int pw;
	String name;
	int m_point;
	public Member(String id, int pw, String name, int m_point) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.m_point = m_point;
	}
}
*/
public class viewAir {
	private static String sql;

	public static void main(String[] args){

		//ArrayList<Member> memberList=new ArrayList(); 

		String DName="oracle.jdbc.driver.OracleDriver";

		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="kim";
		String password="1234";

		Connection conn=null;
		PreparedStatement pstmt=null;

		try {
			Class.forName(DName);

			conn=DriverManager.getConnection(url, user, password);

			pstmt=conn.prepareStatement(sql);

			Scanner sc=new Scanner(System.in);

			boolean flag=false; // ���α׷� ����
			String id; // ���̵�
			String pw; // ��й�ȣ
			String t_num; // �����ȣ
			String air_num; // �������ȣ
			int payment; // �����ݾ�
			int use_point; // ����� ���ϸ���
			String air_name; // �װ����
			String departure; // �����
			String arrive; // ������
			String date; // ��¥
			int price; // ����
			int t_num_sel; // ����� �¼���


			while(true) {
				// +���� ȭ��
				System.out.println();
				System.out.println("---________________HG_air ->->->>________________---");
				System.out.println();
				System.out.println("      [1]�α���	    [2]ȸ������ 	  [3]���α׷�����         ");
				int start=sc.nextInt();

				// ������ȸ������ �������� ���
				if(start==1) { // +1��â (�α���)
					while(true) {
						System.out.print("���̵��Է�: ");
						id=sc.next();
						String sql="select * from member where='"+id+"'";
						if(pstmt.executeQuery(sql)==null) { // ���̵� ���� null�̶�� ...
							System.out.println("���̵� ����!");
							continue;
						}
						else if(id=="����") {
							flag=true;
							pstmt.close();
							break;
						}
						else { // ���̵� ����� �Է��Ѵٸ� ����.
							pstmt.close();
							break;
						}
					}

					while(true) {

						System.out.print("��й�ȣ�Է�: ");
						pw=sc.next();
						String sql="select * from member where id='"+id+"'and pw='"+pw+"'";
						//select * from member where id='(id)' and pw='(pw)';
						if(pstmt.executeQuery(sql)==null) { // ��й�ȣ ���� null�̶�� ...
							System.out.println("��й�ȣ ����!");
							continue;
						}
						else if(pw=="����") {
							flag=true;
							pstmt.close();
							break;
						}
						else {
							pstmt.close();
							break; // ��й�ȣ�� ����� �Է��Ѵٸ� ����.
						}
					}

					// ������ ���� or  ����������ȸ  +2��â
					System.out.println();
					System.out.println("[1.-����] [2.-������ȸ]");
					int res=sc.nextInt();
					if(res==1) {
						// ������ ����
					}
					else if(res==2) { 
						System.out.println("=======��������=======");
						String sql="select * from ticket_info where='"+id+"'";

						ResultSet rs=pstmt.executeQuery(sql);
						System.out.println("�����ȣ	�������ȣ	ID	�����ݾ�	���ϸ���(���)");
						while(rs.next()) {
							id=rs.getString("id");
							t_num=rs.getString("t_num");
							air_num=rs.getString("air_num");
							payment=rs.getInt("payment");
							use_point=rs.getInt("use_point");
							//  �����ȣ  �������ȣ 	ID	�����ݾ�	���ϸ���(���)
							System.out.println(t_num+"	"+air_num+"	"+id+"	"+payment+"	"+use_point);
						}

						rs.close();


						// ���� ��� �� ... -> ���ຯ�� or ��� or ���� 
						// +3��â
						System.out.println("[1.���ຯ�� ] [2.�������] [3.����]");
						int changeOrCancle=sc.nextInt();


						if(changeOrCancle==1) { // ���ຯ���� ������ �ݾ״뿡���� ���氡�� ...! 
							//System.out.println("������ �ݾ����θ� ���氡���մϴ�.");
							// ó�� ������������ ���  -> ����

							//t_num_sel
							System.out.println("������ �������ȣ �Է�");// ����ڰ� ������ ������ �ִ� �װ��� �� ����
							t_num_sel=sc.nextInt();

							sql="select * from HG_air";

							rs=pstmt.executeQuery(sql);
							System.out.println("�������ȣ	�װ����	�����	������	��¥	����");
							while(rs.next()) {
								air_num=rs.getString("air_num");
								air_name=rs.getString("air_name");
								departure=rs.getString("departure");
								arrive=rs.getString("arrive");
								date=rs.getString("date");
								price=rs.getInt("price");

								//  �����ȣ  �������ȣ 	ID	�����ݾ�	���ϸ���(���)
								System.out.println(air_num+"	"+air_name+"	"+departure+"	"+arrive+"	"+date+"	"+price);
							}
							rs.close();

							while(true) {
								System.out.println("=======���ຯ��=======");
								System.out.println("���ϴ� ������ ��ȣ�� �Է��ϼ���.");
								int change=sc.nextInt(); // �������ȣ

								sql="update ticket_info set air_num="+change+", payment=?, use_point=? where air_num="+t_num_sel+"";
								if(pstmt.executeQuery(sql)==null) { // ��й�ȣ ���� null�̶�� ...
									System.out.println("�������ȣ ����!");
									continue;
								}
								sql="select * from ticket_info ";
								System.out.println("���ຯ���� �Ϸ�Ǿ����ϴ�.");
							}
						}
						else if(changeOrCancle==2) { // ������� -> ���ϸ����� �����ݾ� ȯ��
							// +4��â
							//t_num_sel
							System.out.println("����� �������ȣ �Է�");// ����ڰ� ������ ������ �ִ� �װ��� �� ����
							t_num_sel=sc.nextInt();

							System.out.println("���� ����Ͻðڽ��ϱ�...?");
							System.out.println();
							System.out.println("[1.-YES]  [2.-No]");
							int YN=sc.nextInt();
							if(YN==1) {
								// �����ݾװ� ���ϸ��� ȯ�� �� 
								for (int i = 0; i < 3; i++) {
									System.out.print(".");
									Thread.sleep(500);
								}
								System.out.print("������� �Ϸ�!");
								System.out.println();
							}
						}
						else {
							continue; // ùȭ������ �̵�
						}

					}
				}
				else if(start==2) {
					// ȸ������
					System.out.println();
					System.out.println("==========ȸ������==========");
					System.out.println();

					System.out.print("���̵� �Է�: ");
					id=sc.next();
					System.out.print("��й�ȣ �Է�: ");
					pw=sc.next();
					System.out.print("�̸� �Է�: ");
					String name=sc.next();
					int m_point=sc.nextInt();
					String sql="insert into member (id,pw,name,m_point)values("+id+"','"+pw+"','"+name+"',"+0+")"; // ó�� ȸ�������� ���� ���ϸ��� 0
					if(pstmt.executeQuery(sql)==null) { // ���� null�̶�� ...
						System.out.println("�������Է� ����!");
					}
					System.out.println("ȸ�����ԿϷ�!");
				}
				else { // ���α׷� ����
					break;
				}

			}



		}// try

		catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}



	}

}