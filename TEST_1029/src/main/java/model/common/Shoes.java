package model.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Shoes {
	public static void main(String[] args) {

		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;

		String url="https://kream.co.kr/search?category_id=1&sort=popular&per_page=40";
		String httpUrl = null;
		String brandname= null;
		String sname=null;
		String spk=null;
		String sdate = null;
		String price = null;
		String imgurl = null;


		Document doc = null;
		Elements el = null;
		int p = 0;


		try {
			doc = Jsoup.connect(url).get();


			Elements element = doc.select(".search_result_item");
			for(int i=0; i<element.size(); i++) { // element.size() 있는 정보 모두 가져오기
				httpUrl = "https://kream.co.kr"+element.get(i).select("a").attr("href");
				System.out.println("http 주소: "+httpUrl);
				System.out.println("확인");



				doc = Jsoup.connect(httpUrl).get();

				imgurl = doc.select(".product > img").attr("src");
				if(imgurl.substring(0,1).equals("/")) {
					continue;
				}


				el = doc.select(".brand"); 
				brandname= el.get(0).text();

				el = doc.select(".title"); 
				sname=el.get(0).text();

				el = doc.select(".product_info");
				spk=el.get(0).text();

				el = doc.select(".product_info");
				sdate=el.get(1).text();

				sdate=sdate.replace("/", "-"); // /을 -으로 바꿔주겠다!!

				el = doc.select(".product_info");
				price=el.get(3).text();

				price=price.replace(",", "");  //,를 없애겠다!!
				price=price.replace("원", "");
				if(price.contains("약")) {
					p = 0;
				} else {
					p= Integer.parseInt(price);
				}


				System.out.println("+++++++++++++++++++++++++++++");
				System.out.println("이미지: "+ imgurl);
				System.out.println("브랜드: "+ brandname);
				System.out.println("상품이름: "+sname);
				System.out.println("품번: "+ spk);
				System.out.println("출시일: "+ sdate);
				System.out.println("가격: "+ p);

				System.out.println("+++++++++++++++++++++++++++++");

				
				 String sql ="insert into shoes values(?,?,?,?,?,?)"; 
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, spk);
		            pstmt.setString(2, imgurl);
		            pstmt.setString(3, brandname);
		            pstmt.setString(4, sname);
		            pstmt.setInt(5, p);
		            pstmt.setString(6, sdate);
		            pstmt.executeUpdate();


			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);
		}


	}
}
