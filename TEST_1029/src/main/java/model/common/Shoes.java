package model.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Shoes {
	public static void main(String[] args) {
		String url="https://kream.co.kr/search?category_id=1&sort=popular&per_page=40";
		String httpUrl = null;
		String brandname= null;
		String sname=null;
		String spk=null;
		String sdate = null;
		String price = null;
		String imgurl = null;
		
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		Elements element = doc.select(".search_result_item");
		for(int i=0; i<element.size(); i++) { // element.size() 있는 정보 모두 가져오기
			httpUrl = "https://kream.co.kr"+element.get(i).select("a").attr("href");
			System.out.println("http 주소: "+httpUrl);
			System.out.println("확인");
			Document doc2 = null;
			
			try {
				doc2 = Jsoup.connect(httpUrl).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Elements el = doc2.select(".content");
			
//			title = el.select(".article_info > h3").first().text();
//			date = el.select(".sponsor > span").first().text();
			imgurl = el.select(".product > img").attr("src");
			brandname= el.select(".main_title_box > a").get(0).text();
			sname=el.select(".main_title_box > p").get(0).text();
			spk=el.select(".detail_product_wrap").select(".detail_box model_num >  dd").first().text();
			sdate=el.select(".detail_product_wrap").select(".detail_box > dd").get(0).text();
			price=el.select(".detail_product_wrap").select(".detail_box > dd").get(2).text();
			
//			content = el.select("._article_body_contents").get(0).text();
//			writer = el.select(".byline > p").text();
			
			System.out.println("+++++++++++++++++++++++++++++");
			System.out.println("상품이름: "+sname);
			System.out.println("출시일: "+ sdate);
			System.out.println("이미지: "+ imgurl);
			System.out.println("품번: "+ spk);
			System.out.println("브랜드: "+ brandname);
			System.out.println("가격: "+ price);
			
			System.out.println("+++++++++++++++++++++++++++++");
		
		
		
		}
		
		
		
	}
}
