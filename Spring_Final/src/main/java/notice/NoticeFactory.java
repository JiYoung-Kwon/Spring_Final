package notice;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class NoticeFactory {
	private static SqlSessionFactory factory = null;
	static {
		try {
			Reader reader =Resources.getResourceAsReader("notice/NoticeConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static SqlSessionFactory GetFactory() {return factory;}
}