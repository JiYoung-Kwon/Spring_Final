package corona;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import mybatis.MybaFactory;

@Component
public class KoreaDao {
	SqlSession sqlSession;

	public KoreaDao() {
		sqlSession = MybaFactory.getFactory().openSession();
	}

	// 데이터 삭제
	public String delete() {
		String msg = "ok";

		try {
			sqlSession.delete("corona.deleteK");
			sqlSession.commit();

		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 삽입
	public String insert(List<KoreaVo> voList) {
		String msg = "ok";

		try {
			for (KoreaVo vo : voList) {
				sqlSession.insert("corona.insertK", vo);
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
	public List<KoreaVo> select() {
		List<KoreaVo> voList = null;
		try {
			voList = sqlSession.selectList("corona.searchK");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return voList;
	}

	// 데이터 조회
	public List<String> selectConfirmed() {
		List<String> confirmedList = null;
		try {
			confirmedList = sqlSession.selectList("corona.searchTodayCF");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return confirmedList;
	}
}
