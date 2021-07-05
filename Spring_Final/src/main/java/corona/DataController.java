package corona;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class DataController {
	
	@Autowired
	KoreaDao kDao;
	
	@Autowired
	GlobalDao gDao;
	
	@Autowired
	GenderAgeDao gaDao;
	
	@Autowired
	CityDao cDao;
	
	//국내 현황 조회
	@RequestMapping(value = "/corona/searchK.corona", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView searchKorea() {
		ModelAndView mv = new ModelAndView();
		
		List<KoreaVo> kList = kDao.select();
		List<GenderAgeVo> gaList = gaDao.select();
		CityVo cVo = cDao.selectCK();
		
		Gson gson = new Gson();
		String jsonPlace = gson.toJson(kList);
		//System.out.println(jsonPlace);
		
		mv.addObject("kList", kList);
		mv.addObject("gaList", gaList);
		mv.addObject("cVo", cVo);
		mv.addObject("kJson",jsonPlace);
		
		mv.setViewName("CasesInKorea");
		return mv;
	}
	
	//국외 현황 조회
	@RequestMapping(value = "/corona/searchG.corona", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView searchGlobal() {
		ModelAndView mv = new ModelAndView();
		

		List<GlobalVo> gList = gDao.select();
		Map<String, String> total = gDao.selectTotal();
		System.out.println(total);
		mv.addObject("gList", gList);
		mv.addObject("total", total);
		
		mv.setViewName("CasesInGlobal");
		return mv;
	}
	
	//시도별 현황 조회(메인)
	@RequestMapping(value = "/corona/searchC.corona", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView searchCity() {
		ModelAndView mv = new ModelAndView();
		

		List<CityVo> cList = cDao.select();
		mv.addObject("cList", cList);
		
		mv.setViewName("CasesInMain");
		return mv;
	}
	
}
