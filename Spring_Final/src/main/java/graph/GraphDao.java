package graph;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class GraphDao {
	public SqlSession session = null;

	public GraphDao() {
		session = GraphFactory.GetFactory().openSession();
	}

	public float G7(String find) {
		float ddd = 0;
		try {
			ddd = session.selectOne("graph.G7", find);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ddd;
	}

	public int viewgrap(String find) {
		int ddd = 0;

		try {
			ddd = session.selectOne("graph.one", find);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ddd;
	}

	public int view(String find) {
		int ddd = 0;
		try {
			ddd = session.selectOne("graph.two", find);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ddd;
	}

	public List<koDataVo> koDataVo() {
		List<koDataVo> list = null;
		try {
			list = session.selectList("graph.koData");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<CityDataVo> CityDataVo() {
		List<CityDataVo> list = null;
		try {
			list = session.selectList("graph.CityData");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	public String DDate(String find) {
		String ddd= null;
		try {
			ddd =  session.selectOne("graph.DDate", find);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ddd;
	}
	public void kodata(koDataVo vo) {
		try {
			session.update("graph.UpdateCity", vo);
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void G7UpDate(GraphVo vo) {
		try {
			session.update("graph.UpdateG7", vo);
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void Ddate(DdateVo vo) {
		try {
			session.update("graph.UpdateDdate", vo);
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void CityUpdate(CityDataVo vo) {
		try {
			session.update("graph.UpdateCityDate", vo);
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
