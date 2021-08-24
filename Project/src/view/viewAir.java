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

			boolean flag=false; // 프로그램 종료
			String id; // 아이디
			String pw; // 비밀번호
			String t_num; // 예약번호
			String air_num; // 운항편번호
			int payment; // 결제금액
			int use_point; // 사용한 마일리지
			String air_name; // 항공기명
			String departure; // 출발지
			String arrive; // 도착지
			String date; // 날짜
			int price; // 가격
			int t_num_sel; // 비행기 좌석수


			while(true) {
				// +메인 화면
				System.out.println();
				System.out.println("---________________HG_air ->->->>________________---");
				System.out.println();
				System.out.println("      [1]로그인	    [2]회원가입 	  [3]프로그램종료         ");
				int start=sc.nextInt();

				// 예약조회들어오면 예약정보 출력
				if(start==1) { // +1번창 (로그인)
					while(true) {
						System.out.print("아이디입력: ");
						id=sc.next();
						String sql="select * from member where='"+id+"'";
						if(pstmt.executeQuery(sql)==null) { // 아이디 값이 null이라면 ...
							System.out.println("아이디 오류!");
							continue;
						}
						else if(id=="종료") {
							flag=true;
							pstmt.close();
							break;
						}
						else { // 아이디를 제대로 입력한다면 종료.
							pstmt.close();
							break;
						}
					}

					while(true) {

						System.out.print("비밀번호입력: ");
						pw=sc.next();
						String sql="select * from member where id='"+id+"'and pw='"+pw+"'";
						//select * from member where id='(id)' and pw='(pw)';
						if(pstmt.executeQuery(sql)==null) { // 비밀번호 값이 null이라면 ...
							System.out.println("비밀번호 오류!");
							continue;
						}
						else if(pw=="종료") {
							flag=true;
							pstmt.close();
							break;
						}
						else {
							pstmt.close();
							break; // 비밀번호를 제대로 입력한다면 종료.
						}
					}

					// 운항편 예약 or  예약정보조회  +2번창
					System.out.println();
					System.out.println("[1.-예약] [2.-예약조회]");
					int res=sc.nextInt();
					if(res==1) {
						// 운항편 예약
					}
					else if(res==2) { 
						System.out.println("=======예약정보=======");
						String sql="select * from ticket_info where='"+id+"'";

						ResultSet rs=pstmt.executeQuery(sql);
						System.out.println("예약번호	운항편번호	ID	결제금액	마일리지(사용)");
						while(rs.next()) {
							id=rs.getString("id");
							t_num=rs.getString("t_num");
							air_num=rs.getString("air_num");
							payment=rs.getInt("payment");
							use_point=rs.getInt("use_point");
							//  예약번호  운항편번호 	ID	결제금액	마일리지(사용)
							System.out.println(t_num+"	"+air_num+"	"+id+"	"+payment+"	"+use_point);
						}

						rs.close();


						// 정보 출력 뒤 ... -> 예약변경 or 취소 or 종료 
						// +3번창
						System.out.println("[1.예약변경 ] [2.예약취소] [3.종료]");
						int changeOrCancle=sc.nextInt();


						if(changeOrCancle==1) { // 예약변경은 동일한 금액대에서만 변경가능 ...! 
							//System.out.println("동일한 금액으로만 변경가능합니다.");
							// 처음 운항편정보들 출력  -> 선택

							//t_num_sel
							System.out.println("변경할 운항편번호 입력");// 사용자가 기존에 가지고 있던 항공권 중 선택
							t_num_sel=sc.nextInt();

							sql="select * from HG_air";

							rs=pstmt.executeQuery(sql);
							System.out.println("운항편번호	항공기명	출발지	도착지	날짜	가격");
							while(rs.next()) {
								air_num=rs.getString("air_num");
								air_name=rs.getString("air_name");
								departure=rs.getString("departure");
								arrive=rs.getString("arrive");
								date=rs.getString("date");
								price=rs.getInt("price");

								//  예약번호  운항편번호 	ID	결제금액	마일리지(사용)
								System.out.println(air_num+"	"+air_name+"	"+departure+"	"+arrive+"	"+date+"	"+price);
							}
							rs.close();

							while(true) {
								System.out.println("=======예약변경=======");
								System.out.println("원하는 운항편 번호를 입력하세요.");
								int change=sc.nextInt(); // 운항편번호

								sql="update ticket_info set air_num="+change+", payment=?, use_point=? where air_num="+t_num_sel+"";
								if(pstmt.executeQuery(sql)==null) { // 비밀번호 값이 null이라면 ...
									System.out.println("운항편번호 오류!");
									continue;
								}
								sql="select * from ticket_info ";
								System.out.println("예약변경이 완료되었습니다.");
							}
						}
						else if(changeOrCancle==2) { // 예약취소 -> 마일리지와 결제금액 환불
							// +4번창
							//t_num_sel
							System.out.println("취소할 운항편번호 입력");// 사용자가 기존에 가지고 있던 항공권 중 선택
							t_num_sel=sc.nextInt();

							System.out.println("정말 취소하시겠습니까...?");
							System.out.println();
							System.out.println("[1.-YES]  [2.-No]");
							int YN=sc.nextInt();
							if(YN==1) {
								// 결제금액과 마일리지 환불 후 
								for (int i = 0; i < 3; i++) {
									System.out.print(".");
									Thread.sleep(500);
								}
								System.out.print("예약취소 완료!");
								System.out.println();
							}
						}
						else {
							continue; // 첫화면으로 이동
						}

					}
				}
				else if(start==2) {
					// 회원가입
					System.out.println();
					System.out.println("==========회원가입==========");
					System.out.println();

					System.out.print("아이디 입력: ");
					id=sc.next();
					System.out.print("비밀번호 입력: ");
					pw=sc.next();
					System.out.print("이름 입력: ");
					String name=sc.next();
					int m_point=sc.nextInt();
					String sql="insert into member (id,pw,name,m_point)values("+id+"','"+pw+"','"+name+"',"+0+")"; // 처음 회원가입자 보유 마일리지 0
					if(pstmt.executeQuery(sql)==null) { // 값이 null이라면 ...
						System.out.println("데이터입력 오류!");
					}
					System.out.println("회원가입완료!");
				}
				else { // 프로그램 종료
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