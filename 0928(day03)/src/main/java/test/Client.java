package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
   public static void main(String[] args) {

      // 1. ������ �����̳ʸ� ���۽��Ѻ���!~~
      AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
      
      // 2. ��ü�� ��û�ϸ�, �ش� ��ü�� �ش�.
      //  == Look up
      /*Test t=(Test)factory.getBean("test");
      t.print();*/
     /* Phone phone=(Phone)factory.getBean("phone");  
      phone.powerOn();
      phone.volumeUp();*/
      
      CBean cb=(CBean)factory.getBean("cb"); 
      Map<String,String> map=cb.getMap();
      System.out.println(map);
     /* List<String> list=cb.getList();
      for(String v:list) {
    	  System.out.println(v);
      }*/
            
      // 3.������ �����̳� ����
      factory.close();
      
      // => Console
      // ���� <bean> ��ϵ� ��� Ŭ������ ���� ��ü�� �̸� ���������ϴ�!
      // pre-loading ��� �ε� <-> lazy loading ���� �ε�
      // �⺻ ������ ȣ���!
      
      // => Console 
      // �⺻ ������ ȣ���!
      // ���
      
   }
}