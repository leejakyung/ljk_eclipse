package model.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {

   public static void main(String[] args) {
      String url = "https://kream.co.kr/products/44102";
      Document doc = null;   

      try {

         doc = Jsoup.connect(url).get();

      } catch (IOException e) {

         e.printStackTrace();

      }


      Elements element = doc.select(".brand"); 
      System.out.println("============================================================");
      System.out.println(element.get(0).text());
      System.out.println("============================================================");
      
      element = doc.select(".title"); 
      System.out.println("============================================================");
      System.out.println(element.get(0).text());
      System.out.println("============================================================");
      
      element = doc.select(".product_info");
      System.out.println("============================================================");
      System.out.println(element.get(0).text());
      System.out.println("============================================================");
      
      element = doc.select(".product_info"); 
      System.out.println("============================================================");
      System.out.println(element.get(1).text());
      System.out.println("============================================================");
       
      element = doc.select(".product_info"); 
      System.out.println("============================================================");
      System.out.println(element.get(3).text());
      System.out.println("============================================================");
   }

}
