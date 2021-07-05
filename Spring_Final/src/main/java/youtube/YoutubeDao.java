package youtube;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import mybatis.MybaFactory;

@Component
public class YoutubeDao {
	SqlSession sqlSession;

	public YoutubeDao() {
		sqlSession = MybaFactory.getFactory().openSession();
	}

	// 데이터 삭제
	public String delete() {
		String msg = "ok";

		try {
			sqlSession.delete("youtube.delete");
			sqlSession.commit();

		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 삽입
	public String insert(List<String> voList) {
		String msg = "ok";

		try {
			for (String vo : voList) {
				sqlSession.insert("youtube.insert", vo);
			}
			sqlSession.commit();
		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 조회
	public List<String> select() {
		List<String> voList = null;
		try {
			voList = sqlSession.selectList("youtube.search");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return voList;
	}
}
