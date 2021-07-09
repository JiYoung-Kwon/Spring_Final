package sanghwal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.sanghwalPage;


@Controller
public class sanghwalController {
	
	@Autowired
	sanghwalDao dao;
	
	@RequestMapping(value = "/sanghwal/search.sanghwal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView search(sanghwalPage page) {
		ModelAndView mv = new ModelAndView();
		
		List<sanghwalVo> list = dao.search(page);
		mv.addObject("list", list);
		mv.addObject("page", page);
		mv.setViewName("search");
		
		return mv;
	}
	
	@RequestMapping(value = "/sanghwal/view.sanghwal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView view(sanghwalVo vo, sanghwalPage page) {
		ModelAndView mv = new ModelAndView();
		
		
		vo = dao.view(vo.getSerial());
		 System.out.println(vo.getSerial());
		sanghwalVo vo2 = dao.viewAtt(vo.getSerial());
		
		
		mv.addObject("vo", vo);
		mv.addObject("vo2", vo2);
		mv.addObject("page", page);
		mv.setViewName("view");
		
		return mv;
	}
	
	
}
