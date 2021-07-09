package mky;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class HospitalDao {
	SqlSession sqlSession;
	
	public void test() {
		System.out.println("dao가 실행됨");
	}
	
	public HospitalDao() {
		try {
			sqlSession = MybaFactory.getFactory().openSession();
			//MybaFactory 클래스의 getFactory() 메서드를 통하여 SqlSessionFactory객체를 가져오고 이 객체의 openSession()를 호출하여 받은 리턴값을 저장한다.
			
			if(sqlSession == null) {	//sqlSession에 데이터가 있다면 정상 저장됨을 출력
				System.out.println("sqlSession 생성시 오류 발생");
			}else {
				System.out.println("정상적으로 sqlSession이 생성됨");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void insert(HospitalVo vo) {
		int r=0;
		
		try {
			switch(vo.getGubun()) {
			case "A0":
				r = sqlSession.insert("hospital.A0insert", vo);
				break;
			case "97":
				r = sqlSession.insert("hospital.97insert", vo);
				break;
			case "99":
				r = sqlSession.insert("hospital.99insert", vo);
				break;
			}
			
			if(r>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void delete() {
			
		try {
			 sqlSession.delete("hospital.A0delete");
			 sqlSession.delete("hospital.97delete");
			 sqlSession.delete("hospital.99delete");
			

			 sqlSession.commit();
	

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<HospitalVo> search(HospitalVo vo) {
		List<HospitalVo> list = null;
		
		try {
			switch(vo.getHpGubun()) {
			case "A0":
				list = sqlSession.selectList("hospital.A0search", vo);
				break;
			case "97":
				list = sqlSession.selectList("hospital.97search", vo);
				break;
			case "99":
				list = sqlSession.selectList("hospital.99search", vo);
				break;
			}
			
			if(list.size()>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
		
	}
		
	
	public HospitalVo mark(HospitalVo vo) {
		HospitalVo vo2 = null;
		
		try {
			switch(vo.getHpGubun()) {
			case "A0":
				vo2 = sqlSession.selectOne("hospital.A0mark", vo);
				break;
			case "97":
				vo2 = sqlSession.selectOne("hospital.97mark", vo);
				break;
			case "99":
				vo2 = sqlSession.selectOne("hospital.99mark", vo);
				break;
			}
			
			if(vo2.getLat()!=null) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return vo2;
	
}
	
}














