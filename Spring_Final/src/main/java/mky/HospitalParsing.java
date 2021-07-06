package mky;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

//11시 갱신
public class HospitalParsing {
	
	  @Autowired 
	  HospitalDao dao;
	
	public void Hospital() {
		dao.delete();
		HospitalInfoParsing hp = new HospitalInfoParsing();
//		List<HospitalVo> list = new ArrayList<HospitalVo>();
   		
//		BufferedReader br = null;
        //DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;

        try {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/pubReliefHospService/getpubReliefHospList"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Kt%2FML8WOZt6gKKRPIo8zhYqtIKcETx%2FhHDplVMJ1T34dekGYoxLvjPM0l5BS3NEWiHsNbGGWggtrYNeOnegijQ%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1100", "UTF-8")); /*한 페이지 결과 수*/
//		urlBuilder.append("&" + URLEncoder.encode("spclAdmTyCd","UTF-8") + "=" + URLEncoder.encode("A0", "UTF-8")); /*A0: 국민안심병원/97: 코로나검사 실시기관/99: 코로나 선별진료소 운영기관*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		String result = "";
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
//		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			result = result + line.trim();
//			System.out.println(result);
		}
		rd.close();
		conn.disconnect();
        
		// xml 파싱하기
        InputSource is = new InputSource(new StringReader(result));
        builder = factory.newDocumentBuilder();
        doc = builder.parse(is);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        // XPathExpression expr = xpath.compile("/response/body/items/item");
        XPathExpression expr = xpath.compile("//items/item");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        
		 for (int i = 0; i < nodeList.getLength(); i++) { 
			HospitalVo vo = new HospitalVo();
            NodeList child = nodeList.item(i).getChildNodes();
            for (int j = 0; j < child.getLength(); j++) {
                Node node = child.item(j);
                
                String nodeName = node.getNodeName();
                String nodeValue = node.getTextContent();

                switch(nodeName) {
                case "yadmNm":
                	vo.setHospitalName(nodeValue);
                	break;
                case "sidoNm" :
                	vo.setSido(nodeValue);
                	break;
                case "sgguNm" :
                	vo.setSigungu(nodeValue);
                	break;
                case "hospTyTpCd" :
                	vo.setHospType(nodeValue);
                	break;
                case "spclAdmTyCd" :
                	vo.setGubun(nodeValue);
                	break;
                case "telno" :
                	vo.setCheckNumber(nodeValue);
                }
                
            } // 2번째 for문 닫기
            
            sido(vo);
            hp.addressch(vo);
            
            if(vo.getLng().equals(null)) {
            	
            	
            }
            
            dao.insert(vo);
            
        }// 1번째 for문 닫기
        
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
   	
	public void sido(HospitalVo vo) {
		
		switch(vo.getSido()) {
		case "서울" : 
			vo.setSidoCd("11");
			break;
		case "부산" : 
			vo.setSidoCd("21");
			break;
		case "대구" : 
			vo.setSidoCd("23");
			break;
		case "인천" : 
			vo.setSidoCd("22");
			break;
		case "광주" : 
			vo.setSidoCd("24");
			break;
		case "대전" : 
			vo.setSidoCd("25");
			break;
		case "울산" : 
			vo.setSidoCd("26");
			break;
		case "경기" : 
			vo.setSidoCd("31");
			break;
		case "강원" : 
			vo.setSidoCd("32");
			break;
		case "충북" : 
			vo.setSidoCd("33");
			break;
		case "충남" : 
			vo.setSidoCd("34");
			break;
		case "전북" : 
			vo.setSidoCd("35");
			break;
		case "전남" : 
			vo.setSidoCd("36");
			break;
		case "경북" : 
			vo.setSidoCd("37");
			break;
		case "경남" : 
			vo.setSidoCd("38");
			break;
		case "제주" : 
			vo.setSidoCd("39");
			break;	
		case "세종" : 
			vo.setSidoCd("41");
			break;
		}
		
	}
	
}