package vCenter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

public class vCenterApi {

	public void vCenterUpdate() {
		
		int p = 600;   // perPage 수
		String page = String.format("page=1&perPage=%d&", p); // page 주소
		String key = "XOv%2BhTC2ART8jx4iEibjnknE3o94faYYtY8Ql0sB0fL8CWHnl59vn4Ml5R62BX7zL1FCZqFPKnQcQnpllglPeg%3D%3D";  // key 주소
		String result = ""; 
		BufferedReader br = null;
		vCenterDao dao = new vCenterDao();
		try {
		
			URL url = new URL("https://api.odcloud.kr/api/15077586/v1/centers?"+page+"serviceKey="+key); //해당 url 생성
			
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();  //url 가져오기
			urlconn.setRequestMethod("GET");   // get 타입
			
			br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
			result = br.readLine();
			
			result = result.substring(result.indexOf("["),result.indexOf("]")+1);		// url에서 []외에 제거
			
			System.out.println(result); 
			JSONParser parser = new JSONParser();     // json 타입 parsing 하기
			Object obj = parser.parse(result);  
			JSONArray jsonArray = (JSONArray)obj;
			
			System.out.println((jsonArray.size()));   // parsing 한 전체 사이즈 확인 
			
			for(int i=0; i<jsonArray.size();i++) {     //전체 사이즈만큼 for문 실행
				JSONObject jsonObj = (JSONObject) jsonArray.get(i);
				  
				
				  String address = (String) jsonObj.get("address"); 
				  
				  if(address.indexOf("(")>0) {          // 주소에 ()가 있을경우 검색을 못하게 되므로 앞부분까지 잘라낸다.
				  address = address.substring(0, address.indexOf("("));
				  }
					
				  addressApi ap = new addressApi();     
				  String adrs = ap.adrs(address);       // 주소 api에 검색후 값을 가져온다.
				  
				  String[] adr = adrs.split(" ");       // 반환된 값을 " "로 나눠 배열에 저장한다.
				  
				  vCenterVo vo = new vCenterVo();       // vo 객체 생성 후 데이터 저장
				  				  
				  vo.setAddress((String)jsonObj.get("address"));
				  vo.setCenterName((String)jsonObj.get("centerName"));
				  vo.setFacilityName((String) jsonObj.get("facilityName"));
				  vo.setLat((String) jsonObj.get("lat"));
				  vo.setLng((String) jsonObj.get("lng"));
				  vo.setPhoneNumber((String) jsonObj.get("phoneNumber"));
				  vo.setSido(adr[0]);   // 1번째 배열값 시/도
				  vo.setSigungu(adr[1]);   // 2번째 배열값 시/군/구
				  vo.setDong(adr[2]);   // 3번째 배열값 읍/면/동
				  
				 dao.insert(vo);  // db에 추가
				 System.out.println("데이터 입력중....");
			}
			 System.out.println("데이터 입력완료!");
		}catch(Exception ex) {
		 ex.printStackTrace();			
		}
	}
}
