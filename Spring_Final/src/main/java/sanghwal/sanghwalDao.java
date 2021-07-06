package sanghwal;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;
import mybatis.sanghwalPage;

public class sanghwalDao {
	public SqlSession sqlsession;

	public sanghwalDao() {
		sqlsession = MybaFactory.getFactory().openSession();
	}

	public List<sanghwalVo> search(sanghwalPage page) { // ��ȸ
		List<sanghwalVo> list = null;
		int totList = 0;
		try {
			switch (page.getGubun()) {
			case "":
			case "sanghwal_basic":
				totList = sqlsession.selectOne("sanghwal.totList", page.getFindStr());
				page.setTotList(totList);
				page.compute();
				list = sqlsession.selectList("sanghwal.search_basic", page);
				break;
			case "sanghwal_doc":
				totList = sqlsession.selectOne("sanghwal.totList", page.getFindStr());
				page.setTotList(totList);
				page.compute();
				list = sqlsession.selectList("sanghwal.search_doc", page);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public sanghwalVo view(int serial) { // �󼼺���
		sanghwalVo vo = new sanghwalVo();

		try {

			sqlsession.update("sanghwal.sanghwal_hitUp", serial);
			sqlsession.commit();

			vo = sqlsession.selectOne("sanghwal.sanghwal_view", serial);
			
			System.out.println("dao내"+vo.getSerial());
			System.out.println("dao내"+vo.getTitle());
			System.out.println("dao내"+vo.getDoc());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vo;
	}

	public sanghwalVo viewAtt(int serial) { // �󼼺���
		sanghwalVo vo = new sanghwalVo();

		try {

			List<sanghwalAttVo> attList = sqlsession.selectList("sanghwal.sanghwalAtt_view", serial);
			System.out.print(attList);
			vo.setAttList(attList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vo;
	}
	

	public static void main(String[] args) {
		new sanghwalDao();
	}

}
