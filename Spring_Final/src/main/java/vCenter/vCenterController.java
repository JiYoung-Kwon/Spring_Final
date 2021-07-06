package vCenter;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class vCenterController {	
		
	@Autowired
	vCenterDao dao;
	
	
	// 시도 검색
	@RequestMapping(value="/vCenter/sido.vCenter", method= {RequestMethod.GET, RequestMethod.POST})
	public void sido(HttpServletRequest req , HttpServletResponse resp) { 

		PrintWriter pw;
		
		List list;
		list = dao.sido();
		
		
		try {
			String result = null;
			   resp.setCharacterEncoding("UTF-8"); 
			   resp.setContentType("text/html; charset=UTF-8");
			   pw = resp.getWriter();
			   for(int i=0;i<list.size();i++) {
				   if(i==0) {result = list.get(i)+",";
				   }
				   else {result += list.get(i)+",";
				   }
			   }
			   pw.print(result);
			   
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
	}
	
	// 시군구 검색
	@RequestMapping(value="/vCenter/sigungu.vCenter", method= {RequestMethod.GET, RequestMethod.POST})
	public void sigungu(HttpServletRequest req , HttpServletResponse resp) { 

		PrintWriter pw;
		
		List list;
		list = dao.sigungu(req.getParameter("sido"));
		
		
		try {
			String result = null;
			resp.setCharacterEncoding("UTF-8"); 
			resp.setContentType("text/html; charset=UTF-8");
			pw = resp.getWriter();
			for(int i=0;i<list.size();i++) {
				if(i==0) {result = list.get(i)+",";
				}
				else {result += list.get(i)+",";
				}
			}
			pw.print(result);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// 읍면동 검색
	@RequestMapping(value="/vCenter/dong.vCenter", method= {RequestMethod.GET, RequestMethod.POST})
	public void dong(vCenterVo vo, HttpServletRequest req , HttpServletResponse resp) { 
		
		PrintWriter pw;
		
		List list;
		list = dao.dong(vo);
		
		
		try {
			String result = null;
			resp.setCharacterEncoding("UTF-8"); 
			resp.setContentType("text/html; charset=UTF-8");
			pw = resp.getWriter();
			for(int i=0;i<list.size();i++) {
				if(i==0) {result = list.get(i)+",";
				}
				else {result += list.get(i)+",";
				}
			}
			pw.print(result);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	  // 선택된 지역의 병원 검색
	  @RequestMapping(value="/vCenter/search.vCenter", method= {RequestMethod.GET, RequestMethod.POST}) 
	  public ModelAndView search(vCenterVo vo) {
	  ModelAndView mv = new ModelAndView();
	  
	  List<vCenterVo> list = null;
		
	  list = dao.search(vo);
	  
	  mv.addObject("list",list); 
	  mv.setViewName("vCenterSearch"); 
	 	  
	  return mv; 
	  }
	  
	  
	  // 선택한 병원 검색
	  @RequestMapping(value="/vCenter/information.vCenter", method= {RequestMethod.GET, RequestMethod.POST}) 
	  public ModelAndView information(vCenterVo vo, HttpServletRequest req) {
	  ModelAndView mv = new ModelAndView();
	  
	  List list = null;
	  
	  
	  String rg[] = req.getParameter("rg").split(" ");
	  vo.setDong(rg[rg.length-1]);    // 해당 읍/면/동
      
      
      vCenterVo vo2  = dao.information(vo);    // 검색
      list  = dao.timeChk(vo);   // 시간별 인원수 체크
	 
	  
	  mv.addObject("vo",vo2); 
	  mv.addObject("list",list); 
	  
	  mv.setViewName("vCenterSearch2"); 
	 	  
	  return mv; 
	  }	  
	  		  
	  
	  // 예약 전 해당 시간의 인원수 검색
	  @RequestMapping(value="/vCenter/timeChk.vCenter", method= {RequestMethod.GET, RequestMethod.POST})
	  public void timeChk(vCenterVo vo, HttpServletRequest req , HttpServletResponse resp) { 

			PrintWriter pw;

			try {
				int r = dao.timeChk2(vo);
				pw = resp.getWriter();

				pw.print(r);
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	  
	  // 예약자 병원 검색 후 위도 / 경도 가져오기
	  @RequestMapping(value="/mapChk.vCenter", method= {RequestMethod.GET, RequestMethod.POST})
	  public void mapChk(vCenterVo vo, HttpServletRequest req , HttpServletResponse resp) { 

		  PrintWriter pw;
		  
		  try {
			  vCenterVo vo2 = dao.mapChk(vo);

			  pw = resp.getWriter();

			  String result = vo2.getLat()+","+vo2.getLng();
			  
			  pw.print(result);
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
	  }


}
