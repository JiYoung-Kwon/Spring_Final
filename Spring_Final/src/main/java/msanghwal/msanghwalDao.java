package msanghwal;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;
import mybatis.sanghwalPage;

public class msanghwalDao {
	public SqlSession sqlsession;

	public msanghwalDao() {
		sqlsession = MybaFactory.getFactory().openSession();
	}

	public List<sanghwalVo> search(sanghwalPage page) { // 占쏙옙회
		List<sanghwalVo> list = null;
		
		int totList = 0;
		try {
			switch (page.getGubun()) {
			case "":
			case "sanghwal_basic":
				totList = sqlsession.selectOne("msanghwal.totList", page.getFindStr());
				page.setTotList(totList);
				page.compute();
				list = sqlsession.selectList("msanghwal.search_basic", page);
				break;
			case "sanghwal_doc":
				totList = sqlsession.selectOne("msanghwal.totList", page.getFindStr());
				page.setTotList(totList);
				page.compute();
				list = sqlsession.selectList("msanghwal.search_doc", page);
				break;
			}
			
			for(int i=0;i<list.size();i++) {
				String nail = sqlsession.selectOne("msanghwal.sanghwal_thumbnail", list.get(i).getSerial());
				list.get(i).setNail(nail);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public sanghwalVo view(int serial) { // �󼼺���
		sanghwalVo vo = new sanghwalVo();

		try {
			
			vo = sqlsession.selectOne("msanghwal.sanghwal_modify", serial);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return vo;
	}
	
	public sanghwalVo viewAtt(int serial) { // �󼼺���
		sanghwalVo vo = new sanghwalVo();

		try {
			List<sanghwalAttVo> attList = sqlsession.selectList("msanghwal.sanghwalAtt_modify", serial);
			//<sanghwalAttVo> attList = sqlsession.selectList("msanghwal.sanghwalAtt_modify", serial);
			vo.setAttList(attList);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		
		return vo;
	}
	
	public String insert(sanghwalVo vo) {
		String msg = "OK";
		int r = 0;
		int chkCnt = 0;
		
		try {
			int serial = sqlsession.selectOne("msanghwal.sanghwal_getSerial");
			vo.setSerial(serial);
			r = sqlsession.insert("msanghwal.sanghwal_insert", vo);	
			if(r>0) {
				chkCnt = 0;
				for(msanghwal.sanghwalAttVo v : vo.getAttList()) {
					v.setpSerial(serial);
					System.out.println("시리얼 : " + v.getpSerial());
					chkCnt += sqlsession.insert("msanghwal.sanghwalAtt_insert", v);
				}
				if(chkCnt == vo.getAttList().size()) {
					sqlsession.commit();
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			msg = ex.toString();
			System.out.println("r=" + r);
			System.out.println("chkCnt=" + chkCnt);
			ex.printStackTrace();
			sqlsession.rollback();
			
			for(msanghwal.sanghwalAttVo delVo : vo.getAttList()) {
				File f = new File(sangFileUploadController.saveDir + delVo.getSysAtt());
				if(f.exists()) f.delete();
			}
		}
		return msg;
	}
	
public String update(sanghwalVo vo) {
		
		String msg = "OK";
		int r=0;
		int chkCnt = 0;
		try {
			sqlsession.update("msanghwal.sanghwal_update", vo);
			
			for(sanghwalAttVo v : vo.getAttList()) {
				v.setpSerial(vo.getSerial());
				chkCnt += sqlsession.insert("msanghwal.sanghwalAtt_insert", v);
			}
			
			System.out.println("인설트 후 cnt : "+chkCnt);
			System.out.println("인설트 후 listsize : "+vo.getAttList().size());
			if(chkCnt == vo.getAttList().size()) {
				System.out.println("실행됨");
				System.out.println("인설트 후 delsize : "+vo.getDelList().size());
				for(sanghwalAttVo delVo : vo.getDelList()) {
					sqlsession.delete("msanghwal.sanghwalAtt_delete2", delVo.getSysAtt() );
					File f = new File(sangFileUploadController.saveDir +  delVo.getSysAtt());
					if(f.exists()) f.delete();
				}
				sqlsession.commit();
			}else {
				throw new Exception();
			}
			
		}catch(Exception ex) {
			System.out.println("r=" + r);
			System.out.println("chkCnt=" + chkCnt);
			msg = ex.toString();
			ex.printStackTrace();
			sqlsession.rollback();
			for(sanghwalAttVo delVo : vo.getAttList()) {
				File f = new File(sangFileUploadController.saveDir + delVo.getSysAtt());
				if(f.exists()) f.delete();
			}

		}

		return msg;
		
		
	}
	
	public void create(sanghwalVo vo) {
		try {
			sqlsession.insert("msanghwal.sanghwal_insert", vo);
			sqlsession.commit();
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	public String delete(sanghwalVo vo) {
		String msg = "OK";
		List<sanghwalAttVo> delList = null;
		try {
			delList = sqlsession.selectList("msanghwal.sanghwalAtt_list", vo.getSerial());
			int r = sqlsession.delete("msanghwal.sanghwal_delete", vo);
			if(r>0) {
				r = sqlsession.delete("msanghwal.sanghwalAtt_delete", vo.getSerial());
				
					sqlsession.commit();
					for(sanghwalAttVo v : delList) {
						File f = new File(sangFileUploadController.saveDir + v.getSysAtt());
						if(f.exists()) f.delete();
						}
			}else {
				throw new Exception();				
			}
		}catch(Exception ex) {
			sqlsession.rollback();
			ex.printStackTrace();
			msg = ex.toString();
		}
		return msg;
	}
	
	public void deleteAtt(sanghwalVo vo) {
		String msg = "OK";
		List<sanghwalAttVo> delList = null;
		try {
			delList = sqlsession.selectList("msanghwal.sanghwalAtt_list", vo.getSerial());
			
				int r = sqlsession.delete("msanghwal.sanghwalAtt_delete", vo.getSerial());
				
				if(r>0) {
				sqlsession.commit();
				for(sanghwalAttVo v : delList) {
					File f = new File(sangFileUploadController.saveDir + v.getSysAtt());
					if(f.exists()) f.delete();
				}
			}
		}catch(Exception ex) {
			sqlsession.rollback();
			ex.printStackTrace();
			msg = ex.toString();
		}
	}

	
	public static void main(String[] args) {
		new msanghwalDao();
	}
	
}


