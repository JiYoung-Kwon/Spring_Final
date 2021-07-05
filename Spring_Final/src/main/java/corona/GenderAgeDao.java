package corona;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import mybatis.MybaFactory;

@Component
public class GenderAgeDao {
	SqlSession sqlSession;

	public GenderAgeDao() {
		sqlSession = MybaFactory.getFactory().openSession();
	}

	// 데이터 삭제
	public String delete() {
		String msg = "ok";

		try {
			sqlSession.delete("corona.deleteGA");
			sqlSession.commit();

		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 삽입
	public String insert(List<GenderAgeVo> voList) {
		String msg = "ok";
		try {
			for (GenderAgeVo vo : voList) {
				sqlSession.insert("corona.insertGA", vo);
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
	public List<GenderAgeVo> select() {
		List<GenderAgeVo> voList = null;
		try {
			voList = sqlSession.selectList("corona.searchGA");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return voList;
	}
}
