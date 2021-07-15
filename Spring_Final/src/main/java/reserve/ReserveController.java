package reserve;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vCenter.vCenterVo;

@RestController
public class ReserveController {
	@Autowired
	ReserveDao dao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	int size;
	int num;
	
    //인증키 생성
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }
    
    //암호화
    public String encode(String password) {
    	BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
    	String securePw = ec.encode(password);
    	System.out.println("password 암호화 :"+securePw);
    	return securePw;
    	}
    	
    //암호화 매칭
    public Boolean matche(String a, String b) {
    	BCryptPasswordEncoder ec = new BCryptPasswordEncoder();
    	Boolean result = ec.matches(a, b);
    	
    	return result;
    	}

	// mailSending 코드
	@RequestMapping(value = "mailSender.reserve", method = {RequestMethod.POST})
	public String mailSender( HttpServletRequest req, HttpServletResponse resp) {
	    JsonObject json = new JsonObject();
		String chkNum = getKey(6);
		String authKey = "인증 번호는 " + chkNum + " 입니다.";

		String setfrom = "";
		String tomail = req.getParameter("tomail"); // 받는 사람 이메일
		String title = "백신예약 인증번호 안내입니다."; // 제목
		//String content = request.getParameter("content"); // 내용
		
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(authKey); // 메일 내용

			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		 json.addProperty("chkNum", chkNum);
		 json.addProperty("tomail", tomail);
		 System.out.println(json.get("chkNum"));
		 System.out.println(json.get("tomail"));
		 String result = json.toString();
		 System.out.println(result);
		 
		 return result;
		
	}
	
	//정보메일 발송
	@RequestMapping(value = "infoMailSender.reserve", method = {RequestMethod.POST})
	public String infoMailSender( HttpServletRequest req, HttpServletResponse resp) {
		JsonObject json = new JsonObject();

		String a = "접종 받으실 분 : " + req.getParameter("myName");
		String b = "접종 받으실 백신 종류 : " + req.getParameter("reserveVaccine");
		String c = "접종 장소 : " + req.getParameter("reserveCenter") + " " + req.getParameter("facilityName");
		String d = "접종 일자 및 시간 : " + req.getParameter("reserveDate") + " " + req.getParameter("reserveTime");
		String f = "예약 번호 : " + num;
		
		String mailContent = String.format("%s\n%s\n%s\n%s\n%s", a,b,c,d,f);
		
		String setfrom = "";
		String tomail = req.getParameter("Email"); // 받는 사람 이메일
		String title = "백신 예약정보 안내 메일입니다."; // 제목

		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");
			
			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(mailContent); // 메일 내용
			
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		String result = json.toString();
		
		return result;
		
	}
	
	//SMS 전송
	@RequestMapping(value="/smsSender.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public String smsSender( HttpServletRequest req, HttpServletResponse resp ) {
		
		String api_key = "";
	    String api_secret = "";
	    Message coolsms = new Message(api_key, api_secret);
	    
	    JsonObject json = new JsonObject();
		String chkNum = getKey(6);
		String authKey = "인증 번호는 " + chkNum + " 입니다.";
		String toPhone = req.getParameter("myPhone");

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", toPhone);
	    params.put("from", "");
	    params.put("type", "SMS");
	    params.put("text", authKey);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	    
	    json.addProperty("chkNum", chkNum);
		json.addProperty("toPhone", toPhone);
		System.out.println(json.get("chkNum"));
		System.out.println(json.get("toPhone"));
		String result = json.toString();
		System.out.println(result);

		return result;
	}
	
	@RequestMapping(value="/doReserve.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doReserve() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("doReserve");

		return mv;
	}
	
	@RequestMapping(value="/my.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView me() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("myReserve");

		return mv;
	}
	
	@RequestMapping(value="/other.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView other() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("otherReserve");

		return mv;
	}
	
	@RequestMapping(value="sc.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView sc() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reserveSearchAndCancle");

		return mv;
		
	}
	@RequestMapping(value="find.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView find() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reserveNumFind");
		
		return mv;
	}
	
	//예약시간 중복인원 체크
	@RequestMapping(value="timeChk.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public void timeChk(MyReserveVo vo, HttpServletRequest req , HttpServletResponse resp) {
		PrintWriter pw;

		try {
			int r = dao.timeChk(vo);
			pw = resp.getWriter();

			pw.print(r);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//본인예약 입력
	@RequestMapping(value="/insert.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView register(MyReserveVo vo, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("Controller.register....");
			
			String [] mobNum = vo.getMyJumin().split("-");
			String first = mobNum[0];
			String last = mobNum[1];
			
			vo.setMyJumin(first + "-" + encode(last));
			
			dao.insert(vo);
			MyReserveVo vo2 = dao.numSelect(vo);
				
			this.num = vo2.getReserveNum();
				
			mv.setViewName("reserveSearchAndCancle");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		return mv;
	}
	
	//대리자 예약 입력
	@RequestMapping(value="/otherInsert.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView registerO(OtherReserveVo vo, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		System.out.println("tettxtsate : " + vo.getMyPhone());
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			System.out.println("Controller.registerR....");
			
			String [] mobNum = vo.getOtherJumin().split("-");
			String first = mobNum[0];
			String last = mobNum[1];
			
			vo.setOtherJumin(first + "-" + encode(last));
			
			dao.insertO(vo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		mv.setViewName("reserveSearchAndCancle");
		return mv;
	}
	
	//예약 정보 조회
	@RequestMapping(value="/search.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView search(MyReserveVo vo, OtherReserveVo v) {
		ModelAndView mv = new ModelAndView();

		System.out.println("Controller.search............");
		
		MyReserveVo vo2 = dao.select(vo);
		OtherReserveVo v2 = dao.otherSelect(v);

		if(v2.getOtherName().equals("")) {
			v2.setOtherName(vo2.getMyName());
			v2.setOtherJumin(vo2.getMyJumin());
		}
		
		String phone = vo2.getMyPhone();
		
		String [] mobNum = vo2.getMyJumin().split("-");
		String first = mobNum[0];
		vo2.setMyJumin(first + "-*******");
		
		String [] mobNum1 = v2.getOtherJumin().split("-");
		String first1 = mobNum1[0];
		v2.setOtherJumin(first1 + "-*******");
		
		
		mv.addObject("list", vo2);
		mv.addObject("list2", v2);
		mv.addObject("phone",phone);
		mv.setViewName("reserveSearch");
		
		return mv;
	}
	
	//예약 번호 찾기
	@RequestMapping(value="/findNum.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public String findNum(MyReserveVo vo) {
		JsonObject json = new JsonObject();
		System.out.println("Controller.findNum............");
		
		String [] mobNum = vo.getMyJumin().split("-");
		String first = mobNum[0];
		String last = mobNum[1];
		
		MyReserveVo vo3 = dao.selectOne(vo);
		String [] mobNum1 = vo3.getMyJumin().split("-");
		String first1 = mobNum1[0];
		String last1 = mobNum1[1];
		
		if(matche(last, last1)) {
			vo.setMyJumin(first + "-" + last1);
		}
		
		MyReserveVo vo2 = dao.numSelect(vo);
		
		int reserveNum = vo2.getReserveNum();
		
		json.addProperty("reserveNum", reserveNum);
		
		String result = json.toString();

		return result;
	}
	
	@RequestMapping(value="canclePage.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView canclePage() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("reserveCancle");

		return mv;
	}
	
	//예약 취소
	@RequestMapping(value="/cancle.reserve", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView cancle(MyReserveVo vo, OtherReserveVo v) {
		ModelAndView mv = new ModelAndView();
		
		MyReserveVo vo2 = dao.select(vo);
		OtherReserveVo v2 = dao.otherSelect(v);
		
		if(v2.getOtherName().equals("")) {
			dao.delete(vo2);	
		}else {
			dao.otherDelete(v2);
			dao.delete(vo2);
		}
		
		mv.setViewName("reserveSearchAndCancle");
		
		return mv;
	}
}
















