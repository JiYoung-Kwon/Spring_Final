package youtube;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class indexController {
	@Autowired
	YoutubeDao dao;
	
	@RequestMapping(value = "/youtube.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView searchKorea() {
		ModelAndView mv = new ModelAndView();
		
		List<String> youtube = dao.select();
		
		Gson gson = new Gson();
		String jsonPlace = gson.toJson(youtube);
		//System.out.println(jsonPlace);

		mv.addObject("yJson",jsonPlace);
		
		mv.setViewName("youtube");
		return mv;
	}
	
}
