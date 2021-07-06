package reserve;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class ReserveDao {
SqlSession sqlSession;
	
	public ReserveDao() {
		try {
			sqlSession = MybaFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				System.out.println("sqlSession 생성시 오류 발생");
			}else {
				System.out.println("정상적으로 sqlSession이 생성됨.");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public MyReserveVo select(MyReserveVo vo){
		MyReserveVo vo2 = null;
		
		try {

			vo2 = sqlSession.selectOne("reserve_search", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return vo2;
	}
	
	public MyReserveVo selectOne(MyReserveVo vo){
		MyReserveVo vo2 = null;
		
		try {
			
			vo2 = sqlSession.selectOne("reserve_searchOne", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return vo2;
	}
	
	public MyReserveVo numSelect(MyReserveVo vo3){
		MyReserveVo v3 = null;
		
		try {
			
			v3 = sqlSession.selectOne("reserve_numSearch", vo3);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return v3;
	}
	
	public OtherReserveVo otherSelect(OtherReserveVo v){
		OtherReserveVo v2 = new OtherReserveVo();
		
		try {
			int r = sqlSession.selectOne("reserve_chkSearch", v);
			
			if(r > 0) {
				v2 = sqlSession.selectOne("reserve_ohterSearch", v);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return v2;
	}

	public String insert(MyReserveVo vo) {
		String msg = "OK";
		int r = 0;

		try {
			r = sqlSession.insert("reserve.reserve_myinsert", vo);
			System.out.println("vo size : " + r);
			if(r>0) {
					sqlSession.commit();
				}else {
					throw new Exception();
				}
		}catch(Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();

		}

		return msg;
	}
	
	public String insertO(OtherReserveVo vo) {
		String msg = "OK";
		int r = 0;
		
		try {
			r = sqlSession.insert("reserve.reserve_otherinsert", vo);
			System.out.println("vo size : " + r);
			if(r>0) {
				sqlSession.commit();
			}else {
				throw new Exception();
			}
		}catch(Exception ex) {
			msg = ex.toString();
			ex.printStackTrace();
			sqlSession.rollback();
			
		}
		
		return msg;
	}
	
	public String delete(MyReserveVo vo) {
		String msg = "OK";

		try {

			int r = sqlSession.delete("reserve.reserve_delete", vo);
			System.out.println("삭제 테스트 " + r);
			sqlSession.commit();
			
			if(r>0) {
				
				System.out.println("정상적으로 삭제됨");
				
				}else {
					throw new Exception();
				}
			
		}catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
			msg = ex.toString();
		}
		return msg;
	}
	
	public String otherDelete(OtherReserveVo v) {
		String msg = "OK";
		
		try {
			
			int r = sqlSession.delete("reserve.reserve_otherDelete", v);
			System.out.println("삭제 테스트 " + r);
			sqlSession.commit();
			
			if(r>0) {
				System.out.println("정상적으로 삭제됨");
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			sqlSession.rollback();
			ex.printStackTrace();
			msg = ex.toString();
		}
		return msg;
	}
	
}


















