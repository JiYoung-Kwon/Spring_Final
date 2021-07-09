package mky;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.IOException;

public class HospitalInfoParsing {
	
		public void addressch(HospitalVo vo) {
	        
			//DocumentBuilderFactory 생성
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        factory.setNamespaceAware(true);
	        DocumentBuilder builder;
	        Document doc = null;
	        String result = "";
	        HospitalInfoOfSido hpSido = new HospitalInfoOfSido();
	        
	        try {
        	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospInfoService1/getHospBasisList1"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=Kt%2FML8WOZt6gKKRPIo8zhYqtIKcETx%2FhHDplVMJ1T34dekGYoxLvjPM0l5BS3NEWiHsNbGGWggtrYNeOnegijQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*서비스키*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode(vo.getHospitalName(), "UTF-8")); /*병원명(UTF-8 인코딩 필요)*/
	        
	        URL url = new URL(urlBuilder.toString());
	    
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
//	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
        	result = result + line.trim();
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
	            NodeList child = nodeList.item(i).getChildNodes();
	            for (int j = 0; j < child.getLength(); j++) {
	                Node node = child.item(j);
	                
	                String nodeName = node.getNodeName();
	                String nodeValue = node.getTextContent();

	                switch(nodeName) {
	                case "addr" :
	                	vo.setAddress(nodeValue);
	                	break;
	                case "XPos":
	                	vo.setLat(nodeValue);
	                	break;
	                case "YPos" :
	                	vo.setLng(nodeValue);
	                	break;
	                case "telno" :
	                	vo.setPhoneNumber(nodeValue);
	                	break;
	                case "hospUrl" :
	                	vo.setHospUrl(nodeValue);
	                	break;
	                }
	                
	            } // 2번째 for문 닫기
	            String check = vo.getCheckNumber().replaceAll("[^0-9]", "");
	            String check1 = vo.getPhoneNumber().replaceAll("[^0-9]", "");
	            
	            if(!(check.equals(check1))) { // 코로나19병원 전화번호와 병원정보 전화번호가 다를 시에
	            	hpSido.sidoAddress(vo);
	            }
	        } // 1번째 for문 닫기
	        
	        
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	        
	}
}
	

