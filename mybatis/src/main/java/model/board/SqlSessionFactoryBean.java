package model.board;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {

	private static SqlSessionFactory sFactory =null;
	static {
		try {
			if(sFactory==null) { //?̱??? ???? ?????ֱ? ???ؼ? ???? 
				Reader reader= Resources.getResourceAsReader("sql-map-config.xml");
				sFactory=new SqlSessionFactoryBuilder().build(reader);
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSession getSessionInstans() {
		return sFactory.openSession();
	}

}
