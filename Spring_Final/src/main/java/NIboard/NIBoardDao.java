package NIboard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import NImybatis.NIMybaFactory;

public class NIBoardDao {
	SqlSession sqlSession;

	
	public NIBoardDao() {
		try {
			sqlSession = NIMybaFactory.getFactory().openSession();
			
			if(sqlSession == null) {
				//System.out.println("sqlSession 생성시 오류 발생");
			}else {
				//System.out.println("정상적으로 sqlSession이 생성됨.");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	public List select(NI_Page page){
		List list = null;
		
		try {
			
			System.out.println(page.getTotList());
			int totList = sqlSession.selectOne("board.totList", page);
		
			page.setTotList(totList);
			
			System.out.println(page.getTotList());
			page.compute();

			switch(page.getTabGubun()) {
			
			 case "issue" :
				 list = sqlSession.selectList("board.Issue", page);
			 break; 
			 
			 case "news" :
				 list = sqlSession.selectList("board.News", page);
			 break; 
			 
			 case "hobby" :
				 list = sqlSession.selectList("board.hobby", page);
			 break;
			 
			 case "issue_M" :
				 list = sqlSession.selectList("board.Issue", page);
			 break; 
			 
			 case "news_M" :
				 list = sqlSession.selectList("board.News", page);
			 break; 
			 
			 case "hobby_M" :
				 list = sqlSession.selectList("board.hobby", page);
			 break;
			 }	

			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	
	public NIBoardVo View (NI_Page page , NIBoardVo vo) {
		NIBoardVo vo2 = null;
		
		try {			
			switch(page.getTabGubun()) {
			 case "issue" :
				 sqlSession.update("board.Issuehitup", vo.getSerial());
				 vo2 = sqlSession.selectOne("board.IssueView", vo);
				 sqlSession.commit();
			 break; 
			 case "news" :
				 sqlSession.update("board.Newshitup", vo.getSerial());
				 vo2 = sqlSession.selectOne("board.NewsView", vo);
				 sqlSession.commit();
			 break; 
			 case "hobby" :
				 sqlSession.update("board.hobbyhitup", vo.getSerial());
				 vo2 = sqlSession.selectOne("board.hobbyView", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "issue_M" :
				 vo2 = sqlSession.selectOne("board.IssueView", vo);
			 break; 
			 case "news_M" :
				 vo2 = sqlSession.selectOne("board.NewsView", vo);
			 break; 
			 case "hobby_M" :
				 vo2 = sqlSession.selectOne("board.hobbyView", vo);
			 break; 
			 
			}	
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return vo2;
	}
	
	public List back(NI_Page page){
		List list = null;
		
		try {
			int totList = sqlSession.selectOne("board.totList", page);
			
			page.setTotList(totList);
			page.compute();
			
			switch(page.getTabGubun()) {
			
			 case "issue" :
				 list = sqlSession.selectList("board.Issue", page);
			 break; 
			 
			 case "news" :
				 list = sqlSession.selectList("board.News", page);
			 break; 
			 
			 case "hobby" :
				 list = sqlSession.selectList("board.hobby", page);
			 break; }	
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	
	public void Create(NIBoardVo vo, NI_Page page) {
		
		try {
			switch(page.getTabGubun()) {
			
			 case "issue_M" :
				 sqlSession.insert("board.IssueCreate", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "news_M" :
				 sqlSession.insert("board.NewsCreate", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "hobby_M" :
				  sqlSession.insert("board.hobbyCreate", vo);
				  sqlSession.commit();
			 break; 
			 }	
				
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	
	}
	
	public void Update(NIBoardVo vo, NI_Page page) {
		
		try {
			
			switch(page.getTabGubun()) {
			
			 case "issue_M" :
				 sqlSession.insert("board.IssueUpdate", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "news_M" :
				 sqlSession.insert("board.NewsUpdate", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "hobby_M" :
				  sqlSession.insert("board.hobbyUpdate", vo);
				  sqlSession.commit();
			 break; 
			 }	
				
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void Delete(NIBoardVo vo, NI_Page page) {
		
		try {
			
			switch(page.getTabGubun()) {
			
			 case "issue_M" :
				 sqlSession.insert("board.IssueDelete", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "news_M" :
				 sqlSession.insert("board.NewsDelete", vo);
				 sqlSession.commit();
			 break; 
			 
			 case "hobby_M" :
				  sqlSession.insert("board.hobbyDelete", vo);
				  sqlSession.commit();
			 break; 
			 }	
				
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	


	public static void main(String[] args) {
		new NIBoardDao();
	}




	



		
}
	

	





