package account;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class accountController {
	@Autowired
	accountDao dao;
	
	// 목록 페이지 (검색) 이동
	@RequestMapping(value = "/account/search.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView search(accountPage page) {
		
		ModelAndView mv = new ModelAndView();
		List<accountVo> list = dao.search(page);
		
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("account");
		
		return mv;
	}

	
	// 계정 정보 페이지로 이동
	@RequestMapping(value = "/account/view.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView view(accountVo vo, accountPage page) {
		ModelAndView mv = new ModelAndView();
		
		accountVo vo2 = dao.view(vo);
		
		mv.addObject("vo", vo2);
		mv.addObject("page", page);
		
		mv.setViewName("account_view");
		
		return mv;
	}
	
	// 계정 정보 수정
	@RequestMapping(value = "/account/update.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView update(accountVo vo, accountPage page) {
		ModelAndView mv = new ModelAndView();
		
		accountVo vo2 = dao.update(vo);
		
		mv.addObject("vo", vo2);
		mv.addObject("page", page);
		
		mv.setViewName("account_view");
		
		return mv;
	}
	
	// 계정 삭제
	@RequestMapping(value = "/account/delete.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView delete(accountVo vo, accountPage page) {
		ModelAndView mv = new ModelAndView();
		
		dao.delete(vo);
		
		page.setNowPage(1);
		List<accountVo> list = dao.search(page);
	
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("account");
		
		return mv;
	}
	
	// 목록 페이지로 이동
	@RequestMapping(value = "/account/return.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView viewback(accountPage page) {
		ModelAndView mv = new ModelAndView();
		List<accountVo> list = dao.search(page);
		
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("account");
		
		return mv;
	}
	
	// 계정 생성 페이지로 이동
	@RequestMapping(value = "/account/register.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView register(accountPage page) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("page", page);
		
		mv.setViewName("account_register");
		
		return mv;
	}

	// 계정 생성
	@RequestMapping(value = "/account/insert.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insert(accountVo vo, accountPage page) {
		ModelAndView mv = new ModelAndView();
		
		vo.setPassword(dao.encode(vo.getPassword()));
		
		dao.insert(vo);
		
		
		page.setNowPage(1);
		List<accountVo> list = dao.search(page);
	
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("account");
		
		return mv;
	}
	
	//아이디 중복여부 체크
	@RequestMapping(value="/account/idChk.act", method= {RequestMethod.GET, RequestMethod.POST})
	public void sigungu(accountVo vo, HttpServletRequest req , HttpServletResponse resp) { 

		PrintWriter pw;
	
		try {
			resp.setCharacterEncoding("UTF-8"); 
			resp.setContentType("text/html; charset=UTF-8");
			
			pw = resp.getWriter();

			pw.print(dao.idChk(vo));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//비밀번호 일치 여부 확인
	@RequestMapping(value="/account/pwdChk.act", method= {RequestMethod.GET, RequestMethod.POST})
	public void pwdChk(accountVo vo, HttpServletRequest req , HttpServletResponse resp) { 

		PrintWriter pw;
		try {
			resp.setCharacterEncoding("UTF-8"); 
			resp.setContentType("text/html; charset=UTF-8");

			
			pw = resp.getWriter();

			Boolean result = dao.matche(vo.getPassword(), dao.pwdChk(vo));
			
			pw.print(result);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	// 비밀번호 변경
	@RequestMapping(value = "/account/pwdChange.act", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView pwdChange(accountVo vo, accountPage page) {
		ModelAndView mv = new ModelAndView();
		
		vo.setNewPwd(dao.encode(vo.getNewPwd()));
		
		dao.pwdChange(vo);
		
		accountVo vo2 = dao.view(vo);
		
		mv.addObject("vo", vo2);
		mv.addObject("page", page);
		
		mv.setViewName("account_view");
		
		return mv;
	}
	
	//비밀번호 일치 여부 확인 후 세션에 저장
		@RequestMapping(value="/account/login.act", method= {RequestMethod.GET, RequestMethod.POST})
		public void login(accountVo vo, HttpServletRequest req , HttpServletResponse resp, HttpSession session) {
			
			if ( session.getAttribute("login") !=null ){  // 기존에 login이란 세션 값이 존재한다면
	           
	            session.removeAttribute("login"); // 기존값을 제거해 준다.
	        }

			PrintWriter pw;
			try {
				resp.setCharacterEncoding("UTF-8"); 
				resp.setContentType("text/html; charset=UTF-8");
				
				pw = resp.getWriter();

				Boolean result = dao.matche(vo.getPassword(), dao.pwdChk(vo));
				
				if ( result == true ){ // 로그인 성공
		            session.setAttribute("login", vo.getMid()); // 세션에 login인이란 이름으로 mid를 저장
		        }else { // 로그인에 실패한 경우
		        	session.removeAttribute("login");
		        }
				
				pw.print(result);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
}