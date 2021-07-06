package NImybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NIMybaFactory {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader=Resources.getResourceAsReader("NImybatis/NIconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
