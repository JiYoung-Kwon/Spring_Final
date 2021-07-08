package graph;


import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GraphController {

	@Autowired
	GraphDao dao;
	
	@Autowired
	VaccinUpdate vaccin;

	@RequestMapping(value = "/graph/ko.graph", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ko() throws IOException {
		ModelAndView mv = new ModelAndView();

		List<koDataVo> koDataVo = dao.koDataVo();
		List<CityDataVo> CityDataVo = dao.CityDataVo();
		int one = dao.viewgrap("합계");
		int two = dao.viewgrap("서울");
		int thr = dao.viewgrap("부산");
		int fou = dao.viewgrap("대구");// 1��
		int fix = dao.viewgrap("인천");
		int six = dao.viewgrap("광주");
		int ser = dao.viewgrap("대전");
		int eig = dao.viewgrap("울산");
		int nin = dao.viewgrap("세종");
		int ten = dao.viewgrap("경기");
		int ele = dao.viewgrap("강원");
		int twe = dao.viewgrap("충북");
		int thi = dao.viewgrap("충남");
		int fon = dao.viewgrap("전북");
		int fif = dao.viewgrap("전남");
		int sin = dao.viewgrap("경북");
		int sev = dao.viewgrap("경남");
		int gin = dao.viewgrap("제주");

		int oneone = dao.view("합계");
		int onetwo = dao.view("서울");
		int onethr = dao.view("부산");
		int onefou = dao.view("대구");
		int onefix = dao.view("인천");
		int onesix = dao.view("광주");// 2��
		int oneser = dao.view("대전");
		int oneeig = dao.view("울산");
		int onenin = dao.view("세종");
		int oneten = dao.view("경기");
		int oneele = dao.view("강원");
		int onetwe = dao.view("충북");
		int onethi = dao.view("충남");
		int onefon = dao.view("전북");
		int onefif = dao.view("전남");
		int onesin = dao.view("경북");
		int onesev = dao.view("경남");
		int onegin = dao.view("제주");

		String Date = dao.DDate("1");
		String Date1 = dao.DDate("2");
		mv.addObject("Ddate", Date);
		mv.addObject("Ddate1", Date1);
		mv.addObject("oneone", oneone);
		mv.addObject("onetwo", onetwo);
		mv.addObject("onethr", onethr);
		mv.addObject("onefou", onefou);
		mv.addObject("onefix", onefix);
		mv.addObject("onesix", onesix);
		mv.addObject("oneser", oneser);
		mv.addObject("oneeig", oneeig);
		mv.addObject("onenin", onenin);
		mv.addObject("oneten", oneten);
		mv.addObject("oneele", oneele);
		mv.addObject("onetwe", onetwe);
		mv.addObject("onethi", onethi);
		mv.addObject("onefon", onefon);
		mv.addObject("onefif", onefif);
		mv.addObject("onesin", onesin);
		mv.addObject("onesev", onesev);
		mv.addObject("onegin", onegin);

		mv.addObject("one", one);
		mv.addObject("two", two);
		mv.addObject("thr", thr);
		mv.addObject("fou", fou);
		mv.addObject("fix", fix);
		mv.addObject("six", six);
		mv.addObject("ser", ser);
		mv.addObject("eig", eig);
		mv.addObject("nin", nin);
		mv.addObject("ten", ten);
		mv.addObject("ele", ele);
		mv.addObject("twe", twe);
		mv.addObject("thi", thi);
		mv.addObject("fon", fon);
		mv.addObject("fif", fif);
		mv.addObject("sin", sin);
		mv.addObject("sev", sev);
		mv.addObject("gin", gin);

		mv.addObject("koDataVo", koDataVo);
		mv.addObject("CityDataVo", CityDataVo);
		mv.setViewName("graph");
		return mv;
	}

	@RequestMapping(value = "/graph/G7.graph", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView G7() throws IOException {
		ModelAndView mv = new ModelAndView();

		String Date = dao.DDate("3");
		mv.addObject("Ddate", Date);

		float United = dao.G7("미국");
		float America = dao.G7("캐나다");
		float Canada = dao.G7("프랑스");
		float Germany = dao.G7("독일");
		float Italy = dao.G7("이탈리아");
		float Japan = dao.G7("일본");
		float England = dao.G7("영국");
		float ko = dao.G7("한국");
		float one = dao.G7("전 세계");

		mv.addObject("ko", ko);
		mv.addObject("one", one);
		mv.addObject("United", United);
		mv.addObject("America", America);
		mv.addObject("Canada", Canada);
		mv.addObject("Germany", Germany);
		mv.addObject("Italy", Italy);
		mv.addObject("Japan", Japan);
		mv.addObject("England", England);
		mv.setViewName("G7");
		return mv;
	}
}
