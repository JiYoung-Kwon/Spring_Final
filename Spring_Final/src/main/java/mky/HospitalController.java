package mky;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HospitalController {
	
	@Autowired
	HospitalDao dao;
	
	@RequestMapping(value = "/search.hospital", method = { RequestMethod.GET, RequestMethod.POST })
	   public ModelAndView search(HospitalVo vo) throws IOException {
	      ModelAndView mv = new ModelAndView();
	      
	      List<HospitalVo> list = dao.search(vo);
	      String a = vo.getHpGubun();
	      
	     
	      mv.addObject("list", list);
	      mv.addObject("hpGubun", a);
	      mv.setViewName("search");

	      return mv;
	   }
	
  
	
	@RequestMapping(value="/mark.hospital", method= RequestMethod.POST)
	public void mark(HospitalVo vo, HttpServletRequest req, HttpServletResponse resp){
		
		System.out.println("주소 서블릿 받음 : "+vo.getAddress());
		System.out.println("구분 서블릿 받음 : "+vo.getHpGubun());

		
		PrintWriter pw;
		
		
		try {
			
			HospitalVo vo2 = dao.mark(vo);
			
			System.out.println("lat"+vo2.getLat());
			System.out.println("lng"+vo2.getLng());
			
			String result = vo2.getLat()+","+vo2.getLng();
			
			pw = resp.getWriter();
			pw.print(result);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/map.hospital", method = { RequestMethod.GET, RequestMethod.POST })
	   public ModelAndView map(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String gubun = req.getParameter("gubun");
				
	      ModelAndView mv = new ModelAndView();
	     
	      mv.addObject("gubunval", gubun);
	      mv.setViewName("map");

	      return mv;
	   }
	
	
}
