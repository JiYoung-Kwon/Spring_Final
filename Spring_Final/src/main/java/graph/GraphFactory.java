package graph;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GraphFactory {
	private static SqlSessionFactory factory = null;
	static {
		try {
			Reader reader =Resources.getResourceAsReader("graph/GraphConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static SqlSessionFactory GetFactory() {return factory;}
}
