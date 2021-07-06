package NIboard;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NIBoardController {
	
	@Autowired
	NIBoardDao dao;
	
	
	@RequestMapping(value="/NI/search.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Issue(NI_Page page) {
	ModelAndView mv = new ModelAndView();
		
	System.out.println("돌긴 돔 ");

	System.out.println(page.getTabGubun());
	List list = dao.select(page);
	
	System.out.println(page.getFindStr());
	System.out.println(page.getTotList());
	
	mv.addObject("list", list);
	mv.addObject("page", page);
	
	switch(page.getTabGubun()) {
	case "issue" :
		mv.setViewName("Issue");
		break;
	case "news" :
		mv.setViewName("News");
		break;
	case "hobby" :
		mv.setViewName("hobby"); // 천재 영민씨
		break;
		
	case "issue_M" :
		mv.setViewName("Issue_Manager"); 
		break;
	case "news_M" :
		mv.setViewName("News_Manager"); 
		break;
	case "hobby_M" :
		mv.setViewName("hobby_Manager"); 
		break;
	}
	
	return mv;
	
	}
	
	
	@RequestMapping(value="/NI/View.brd", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView View(NIBoardVo vo, NI_Page page) {
	ModelAndView mv = new ModelAndView();
	
	NIBoardVo vo2 = dao.View(page, vo);
	mv.addObject("page", page);
	mv.addObject("vo", vo2);
	
	switch(page.getTabGubun()) {
	case "issue" :
		mv.setViewName("View");
		break;
	case "news" :
		mv.setViewName("View");
		break;
	case "hobby" :
		mv.setViewName("View"); // 천재 영민씨
		break;
	case "issue_M" :
		mv.setViewName("Update_form"); 
		break;
	case "news_M" :
		mv.setViewName("Update_form"); 
		break;
	case "hobby_M" :
		mv.setViewName("Update_form"); 
		break;
	}

	return mv;
	
	}
	
	
	  @RequestMapping(value = "/NI/Create.brd", method = {RequestMethod.GET,
	  RequestMethod.POST}) public ModelAndView create(NIBoardVo vo, NI_Page page) {
	 
	  ModelAndView mv = new ModelAndView();
	  
	  dao.Create(vo, page);
	  
	  List list = dao.select(page);
		
	  mv.addObject("list", list);
	  mv.addObject("page",page);
	  mv.addObject("vo", vo);
	  
	  switch(page.getTabGubun()) { 
	  
	  case "issue_M" :
	  mv.setViewName("Issue_Manager");
	  break;
	  
	  case "news_M" : 
	  mv.setViewName("News_Manager");
	  break; 
	  
	  case "hobby_M" :
	  mv.setViewName("hobby_Manager"); 
	  break; 
	  }
	  
	  return mv;
	  }
	  
	  
	  @RequestMapping(value = "/NI/Update.brd", method = {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView Update(NIBoardVo vo, NI_Page page) {
			 
			  ModelAndView mv = new ModelAndView();
			  
			  dao.Update(vo, page);
			  List list = dao.select(page);
				
			  mv.addObject("list", list);
			  mv.addObject("page",page);
			  mv.addObject("vo", vo);
			  
			  switch(page.getTabGubun()) { 
			  
			  case "issue_M" :
			  mv.setViewName("Issue_Manager");
			  break;
			  
			  case "news_M" : 
			  mv.setViewName("News_Manager");
			  break; 
			  
			  case "hobby_M" :
			  mv.setViewName("hobby_Manager"); 
			  break; 
			  }
			  
			  return mv;
			  }
	
	  @RequestMapping(value = "/NI/Delete.brd", method = {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView Delete(NIBoardVo vo, NI_Page page) {
			 
			  ModelAndView mv = new ModelAndView();
			  
			  dao.Delete(vo, page);
			  List list = dao.select(page);
				
			  mv.addObject("list", list);
			  mv.addObject("page",page);
			  mv.addObject("vo", vo);
			  
			  switch(page.getTabGubun()) { 
			  
			  case "issue_M" :
			  mv.setViewName("Issue_Manager");
			  break;
			  
			  case "news_M" : 
			  mv.setViewName("News_Manager");
			  break; 
			  
			  case "hobby_M" :
			  mv.setViewName("hobby_Manager"); 
			  break; 
			  }
			  
			  return mv;
			  }
	  

	  
}





