package sanghwal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


public class sangFileUploadController {

	//final static String saveDir = "C:\\pwg\\workspace\\WebStudy\\WebContent\\upload\\";
	final static String saveDir = "C:\\Users\\2-14\\eclipse\\jee-2020-122\\eclipse\\workspace\\final\\WebContent\\msanghwal\\upload"; //수정해주세요 ㅜㅜ
	//final static String saveDir = "c:/pwg/upload/";

	public sangFileUploadController() {
		System.out.println("sangFileUploadController");
	}
	
	public List<sanghwalAttVo> upload(HttpServletRequest req) {
		List<sanghwalAttVo> attList = null;
		try {
			req.setCharacterEncoding("utf-8");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
			
			String contentType = req.getContentType();
	
			System.out.println("contentType : " + contentType);
			
			if(contentType.toLowerCase().startsWith("multipart/")) {
				
				System.out.println("upload..........");

				attList = new ArrayList<sanghwalAttVo>();
				Collection<Part> parts = req.getParts();
				for(Part p : parts) {
					if( p.getHeader("Content-Disposition").contains("filename=")) { // file tag
						String fileName = p.getSubmittedFileName();
						sanghwalAttVo attVo = new sanghwalAttVo();
						
						String date = sdf.format(new Date());
						
						if(p.getSize()>0) {
							p.write(saveDir + date + "-" + fileName);
							p.delete();
	
							attVo.setSysAtt(date + "-" + fileName);
							attVo.setOriAtt(fileName);
							attList.add(attVo);
						}
					}
				}
		
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return attList;
	}
	
}
