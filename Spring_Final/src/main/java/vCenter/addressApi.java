package vCenter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class addressApi {

	public String adrs(Object address) {
		String result ="";
		
		
		String adr = (String) address;
		
		
		while(true) {   // 정보를 찾을때까지 반복
			StringBuilder urlBuilder = new StringBuilder("http://openapi.epost.go.kr/postal/retrieveNewAdressAreaCdSearchAllService/retrieveNewAdressAreaCdSearchAllService/getNewAddressListAreaCdSearchAll"); /*URL*/
			try {
				urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=XOv%2BhTC2ART8jx4iEibjnknE3o94faYYtY8Ql0sB0fL8CWHnl59vn4Ml5R62BX7zL1FCZqFPKnQcQnpllglPeg%3D%3D");
				urlBuilder.append("&" + URLEncoder.encode("srchwrd","UTF-8") + "=" + URLEncoder.encode(adr, "UTF-8")); /*검색어*/
		        urlBuilder.append("&" + URLEncoder.encode("countPerPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지당 출력될 개수를 지정(최대50)*/
		        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*출력될 페이지 번호*/
		        
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
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        
		        result = sb.toString();
			
		        try {
		        	result = result.substring(result.indexOf("<rnAdres>")+9,result.indexOf("</rnAdres>"));	  // 지번 주소 가져오기
		        	break; // 성공시 반복문 종료
		        	
		        }catch(Exception e) {    // 지번주소 못가져올경우.
		        	String[] result2;
		        	result2 = adr.split(" ");   // 주소를 " " 기준으로 배열로 나눈다.
		        	
		        	if(result2[2].endsWith("읍")||result2[2].endsWith("면")||result2[2].endsWith("동")||result2[2].endsWith("로")) {
		        		adr = String.format("%s %s %s", result2[0],result2[1],result2[2]);   // 3번째 배열값이 읍,면,동,로 에 포함되면 그대로 검색.
		        	}else {	// 포함되지 않을경우
		        		
		        	if(result2[1].contains("양구군")) {   // 2번째 배열값이 양구군을 포함하고 있을경우 (양구군 이외에는 시군구 값이 겹치는 경우가 없음)
		        		int i = result2[1].indexOf("양구군")+3;
		        		
		        		adr = String.format("%s %s %s", result2[0],result2[1].substring(0, i),result2[1].substring(i, result2[1].length())); //인덱스 값 만큼 잘라 검색한다.
		        		
		        	}else {    // 양구군이 아닌 시군구를 찾을경우.
		        		for(int i=1; i<result2[1].length();i++) {
		        			if(result2[1].substring(i-1, i).equals("시")) {     // 시를 포함하고 있을경우
		        				adr = String.format("%s %s %s", result2[0],result2[1].substring(0, i),result2[1].substring(i, result2[1].length()));
		        				break;
		        			}else if(result2[1].substring(i-1, i).equals("군")) { // 군를 포함하고 있을경우
		        				adr = String.format("%s %s %s", result2[0],result2[1].substring(0, i),result2[1].substring(i, result2[1].length()));
		        				break;
		        			}else if(result2[1].substring(i-1, i).equals("구")) { // 구를 포함하고 있을경우
		        				adr = String.format("%s %s %s", result2[0],result2[1].substring(0, i),result2[1].substring(i, result2[1].length()));
		        				break;
		        			}
		        			
		        		} //for문 닫기
		        	  } // 2번째  else문 닫기
		        	} // 1번째 else문 닫기
		        } // catch문 닫기
			
		        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result = (String) address;
			} /*Service Key*/
		        
		        
		        
		}

		return result;

	}
}
