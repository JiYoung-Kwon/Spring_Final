package account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import notice.NoticeFactory;

public class accountDao {
	
	public SqlSession session = null;
	
	public accountDao() {session = NoticeFactory.GetFactory().openSession();
	}
	
	
	public List<accountVo> search(accountPage page) {
		int r;
		List<accountVo> list = null;
		try {
			r = session.selectOne("account.totlist", page);
			page.setTotList(r);
			page.compute();
			
			list = session.selectList("account.search", page);
						
		}catch(Exception ex) {
			ex.printStackTrace();
			}
		return list;
	}


	public accountVo view(accountVo vo) {
		accountVo vo2 = null;
		try {
			vo2 = session.selectOne("account.view", vo);
						
		}catch(Exception ex) {
			ex.printStackTrace();
			}
		return vo2;
	}

	public accountVo update(accountVo vo) {
		int r = 0;
		accountVo vo2 = null;
		try {
			r = session.update("account.update", vo);
			
			if(r>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
			vo2 = session.selectOne("account.view", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo2;
	}

	
	public void delete(accountVo vo) {
		int r = 0;
		
		try {
			r = session.delete("account.delete", vo);
			
			if(r>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void insert(accountVo vo) {
		int r = 0;
		
		try {
			r = session.insert("account.insert", vo);
			
			if(r>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public String idChk(accountVo vo) {
		 String result = null;
		
		try {
			int r = session.selectOne("account.idChk", vo);
			result = String.format("%s", r);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	
	public void pwdChange(accountVo vo) {
		
		try {
			int r = session.update("account.pwdChange", vo);
			
			if(r>0) {
				session.commit();
			}else {
				session.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public String pwdChk(accountVo vo) {
		 String result = null;
		
		try {
			 result = session.selectOne("account.pwdChk", vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	
	public void login_chk() {
		
	}
	
	
	
	// 비밀번호 암호화 (인코딩)
	public String encode(String password) {
	BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
	String securePw = ec.encode(password);
	return securePw;
	}
	
	// 비밀번호 복호화 후 매치 (일치여부 판단)
	public Boolean matche(String pwd, String DBPwd) {
		BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
		Boolean result = ec.matches(pwd, DBPwd);
		
		return result;
	}
	

}