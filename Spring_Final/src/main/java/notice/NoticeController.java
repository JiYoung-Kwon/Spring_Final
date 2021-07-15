package notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	@Autowired
	NoticeDao dao;
	
	@RequestMapping(value = "/notice/ureader.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ureader(NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		List<NoticeVo> list = dao.ureader(page);
		
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("unotice_reader_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/uview.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView uview(NoticeVo vo, NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		NoticeVo v = dao.uview(vo);
		
		mv.addObject("vo", v);
		mv.addObject("page", page);
		
		mv.setViewName("unotice_view_form");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/notice/mcview.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mcview(NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_create_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/mview.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mview(NoticeVo vo, NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		NoticeVo v = dao.mview(vo);
		
		mv.addObject("vo", v);
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_update_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/mcreate.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mcreate(NoticeVo vo, NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		dao.mcreate(vo);
		
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_reader_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/mreader.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mreader(NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(page.getNowPage());
		System.out.println(page.getFindStr());
		
		List<NoticeVo> list = dao.mreader(page);
		
		mv.addObject("list", list);
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_reader_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/mupdate.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mupdate(NoticeVo vo, NoticePage page, String updatecompare) {
		ModelAndView mv = new ModelAndView();
		
		dao.mupdate(vo, updatecompare);
		
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_reader_form");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/mdelete.notice", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mdelete(NoticeVo vo, NoticePage page) {
		ModelAndView mv = new ModelAndView();
		
		dao.mdelete(vo);
		
		mv.addObject("page", page);
		
		mv.setViewName("mnotice_reader_form");
		
		return mv;
	}
}