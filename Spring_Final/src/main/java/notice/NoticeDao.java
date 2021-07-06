package notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class NoticeDao {
	public SqlSession session = null;
	public NoticeDao() {session = NoticeFactory.GetFactory().openSession();}
	
	public List<NoticeVo> ureader(NoticePage page){
		List<NoticeVo> list = null;
		int totlist =  0;
		try {
			switch(page.getFindSort()) {
			case "":
			case "제목":
				totlist = session.selectOne("notice.totlist_Title", page.getFindStr());
				page.setTotList(totlist);
				page.compute();
				list = session.selectList("notice.reader_Title", page);
				break;
			case "내용":
				totlist = session.selectOne("notice.totlist_Content", page.getFindStr());
				page.setTotList(totlist);
				page.compute();
				list = session.selectList("notice.reader_Content", page);
				break;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		return list;
	}
	
	public NoticeVo uview(NoticeVo vo) {
		NoticeVo v = null;
		try {
			v = session.selectOne("notice.view_serial", vo.getSerial());
			session.update("notice.view_hitup", vo.getSerial());
			session.commit();
		}catch(Exception ex) {ex.printStackTrace();}
		return v;
	}
	
	
	
	
	
	
	public NoticeVo mview(NoticeVo vo) {
		NoticeVo v = null;
		try {
			v = session.selectOne("notice.view_serial", vo.getSerial());
		}catch(Exception ex) {ex.printStackTrace();}
		return v;
	}
	
	public void mcreate(NoticeVo vo) {
		try {
			session.insert("notice.create_notice", vo);
			session.commit();
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	
	public List<NoticeVo> mreader(NoticePage page){
		List<NoticeVo> list = null;
		int totlist =  0;
		try {
			switch(page.getFindSort()) {
			case "":
			case "제목":
				totlist = session.selectOne("notice.totlist_Title", page.getFindStr());
				page.setTotList(totlist);
				page.compute();
				list = session.selectList("notice.reader_Title", page);
				break;
			case "내용":
				totlist = session.selectOne("notice.totlist_Content", page.getFindStr());
				page.setTotList(totlist);
				page.compute();
				list = session.selectList("notice.reader_Content", page);
				break;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		return list;
	}
	
	public void mupdate(NoticeVo vo, String updatecompare) {
		try {
			session.update("notice.update_notice", vo);
			session.commit();
			if(updatecompare.equals("수정됨")) {
				String titlereplace = vo.getTitle();
				
				String ok = titlereplace.replace(" [수정됨] ", "");
				
				vo.setTitle(ok);
				
				session.update("notice.updatecompare_notice", vo);
				session.commit();
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public void mdelete(NoticeVo vo) {
		session.delete("notice.delete_notice", vo);
		session.commit();
	}
}