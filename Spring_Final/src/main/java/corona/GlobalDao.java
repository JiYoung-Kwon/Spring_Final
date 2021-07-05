package corona;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import mybatis.MybaFactory;

@Component
public class GlobalDao {
	SqlSession sqlSession;

	public GlobalDao() {
		sqlSession = MybaFactory.getFactory().openSession();
	}

	// 데이터 삭제
	public String delete() {
		String msg = "ok";

		try {
			sqlSession.delete("corona.deleteG");
			sqlSession.commit();

		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 삽입
	public String insert(List<GlobalVo> voList) {
		String msg = "ok";
		try {
			for (GlobalVo vo : voList) {
				sqlSession.insert("corona.insertG", vo);
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
	public List<GlobalVo> select() {
		List<GlobalVo> voList = null;
		try {
			voList = sqlSession.selectList("corona.searchG");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return voList;
	}
	
	// 데이터 조회(합계)
		public Map<String, String> selectTotal() {
			Map<String, String> total = null;
			try {
				total = sqlSession.selectOne("corona.searchGTot");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return total;
		}
}
