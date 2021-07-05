package corona;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import mybatis.MybaFactory;

@Component
public class CityDao {
	SqlSession sqlSession;

	public CityDao() {
		sqlSession = MybaFactory.getFactory().openSession();
	}

	// 데이터 삭제
	public String delete() {
		String msg = "ok";

		try {
			sqlSession.delete("corona.deleteC");
			sqlSession.commit();

		} catch (Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
		}
		return msg;
	}

	// 데이터 삽입
	public String insert(List<CityVo> voList) {
		String msg = "ok";
		try {
			for (CityVo vo : voList) {
				sqlSession.insert("corona.insertC", vo);
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
	public List<CityVo> select() {
		List<CityVo> voList = null;

		try {
			voList = sqlSession.selectList("corona.searchC");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return voList;
	}
	
	// 해외지역, 국내지역 발생 수만 조회
	public CityVo selectCK() {
		CityVo vo = null;

		try {
			vo = sqlSession.selectOne("corona.searchCK");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
}
