package day13;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener; 

/**
 * Application Lifecycle Listener implementation class CoffeeListener
 *
 */
@WebListener
public class CoffeeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CoffeeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ArrayList<String> datas=new ArrayList<String>();
         datas.add("아메리카노");
         datas.add("카페라떼");
         datas.add("돌체라떼");
         
         ServletContext context =sce.getServletContext();
         context.setAttribute("coffee", datas);
       
    }
	
}
