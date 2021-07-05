package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaFactory {
	private static SqlSessionFactory factory;
	
	static {
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	} public static SqlSessionFactory getFactory() {
		return factory;
	}
}
