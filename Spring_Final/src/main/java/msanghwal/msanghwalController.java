package msanghwal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mybatis.sanghwalPage;


@Controller
public class msanghwalController {
	
	@Autowired
	msanghwalDao dao;
	
	@Autowired
	sangFileUploadController fileUpload;
	
	List<sanghwalAttVo> attList;
	
	@RequestMapping(value = "/msanghwal/msanghwal_search.msanghwal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView search(sanghwalPage page) {
		
		ModelAndView mv = new ModelAndView();
		
		List<sanghwalVo> list = dao.search(page);

		
		mv.addObject("list", list);
		mv.addObject("page", page);
		mv.setViewName("msanghwal_search");
		
		return mv;
	}
	
	@RequestMapping(value = "/msanghwal/msanghwal_modify.msanghwal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView modify(sanghwalVo vo, sanghwalPage page) {
		ModelAndView mv = new ModelAndView();
		
		
		vo = dao.view(vo.getSerial());
		 System.out.println(vo.getSerial());
		sanghwalVo vo2 = dao.viewAtt(vo.getSerial());
		
		
		mv.addObject("vo", vo);
		mv.addObject("vo2", vo2);
		mv.addObject("page", page);
		mv.setViewName("msanghwal_modify");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/msanghwal/msanghwal_register.msanghwal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView register(sanghwalPage page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("page", page);
		mv.setViewName("msanghwal_register");
		
		return mv;
	}
	
	@RequestMapping(value="/fup.msanghwal", method=RequestMethod.POST)
	public void upload(HttpServletRequest req, HttpServletResponse resp){
		attList = fileUpload.upload(req);
		PrintWriter pw;
		try {
			pw = resp.getWriter();
			pw.print("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/msanghwal/msanghwal_registerR.msanghwal", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView registerR(sanghwalVo vo, sanghwalPage page) {
		
		System.out.println("Controller.resisterR");
		ModelAndView mv = new ModelAndView();
		vo.setAttList(attList);
		System.out.println(attList.get(0).getSerial());
		dao.insert(vo);
		
		mv.addObject("page", page);
		mv.setViewName("msanghwal_search");
		
		return mv;
	}
	
	@RequestMapping(value="/msanghwal/msanghwal_update.msanghwal", method= {RequestMethod.POST})
	public ModelAndView update(sanghwalVo v, sanghwalPage p, @RequestParam(value="delFile", required=false) List<String> delFile) {
		ModelAndView mv = new ModelAndView();
		List<sanghwalAttVo> delList = new ArrayList<sanghwalAttVo>();
		
		if(delFile != null) {
			for(String ori : delFile) {
				sanghwalAttVo attVo = new sanghwalAttVo();
				attVo.setSysAtt(ori);
				delList.add(attVo);
				v.setDelList(delList);
			}
			
		}	
		
		
		  v.setAttList(attList);
		  
		  dao.update(v);
		  
		  mv = search(p); 
		  
		  mv.setViewName("msanghwal_search");
		 
		 
		 return mv;
	}
	
	@RequestMapping(value="/msanghwal/msanghwal_delete.msanghwal", method= {RequestMethod.GET})
	public ModelAndView delete(sanghwalVo v, sanghwalPage p) {
		ModelAndView mv = new ModelAndView();
	
		dao.delete(v);
		System.out.println(v.getSerial());
		List<sanghwalVo> list = dao.search(p);
		mv.addObject("list", list);
		mv.addObject("page", p);
		mv.setViewName("msanghwal_search");
		
		return mv;
	}
	
}
