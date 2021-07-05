package corona;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;

//업데이트 시간 여유롭게 11시
@Component
public class CityData {
	@Autowired
	CityDao dao;

	public void parsingCity() throws IOException {
		List<CityVo> list = new ArrayList<CityVo>();

		String key = "CixGmUHaUR%2FsF46havl6Z9WygXCsGidMQt4T59ncgvi5FXE8vGdroGofU4sTFY9Hp6u7ljkB2KKghtFp9mVDxA%3D%3D";

		String parsingURL = "";

		// 현재 날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		String curDate = sdf.format(cal.getTime());

		System.out.println(curDate);

		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + key); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode("-", "UTF-8")); /* 공공데이터포털에서 받은 인증키 */
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append("&" + URLEncoder.encode("startCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(curDate, "UTF-8")); /* 검색할 생성일 범위의 시작 */
		urlBuilder.append("&" + URLEncoder.encode("endCreateDt", "UTF-8") + "="
				+ URLEncoder.encode(curDate, "UTF-8")); /* 검색할 생성일 범위의 종료 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
//		System.out.println(sb.toString());

		System.out.println("===================================================");
		// XML -> DATA 파싱
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			// 파싱할 URL
			parsingURL = url.toString();
			// 페이지에 접근해줄 Document 객체 생성
			// doc 객체로 파싱할 url 요소 읽기
			Document doc = dBuilder.parse(parsingURL);

			// Tree 구조 node 로 변환
			doc.getDocumentElement().normalize();

			// root tag 값 확인
			System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

			// 파싱할 데이터 tag의 리스트 수
			NodeList nList = doc.getElementsByTagName("item"); // <item> 태그요소
			System.out.println("파싱할 리스트 수 : " + nList.getLength());

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i); // <item> i 값 nNode에 넣기

				// Element node type 비교
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					CityVo vo = new CityVo();
					Element eElement = (Element) nNode;

//					System.out.println("========================");
//					System.out.println("조회 날짜(기준) : " + getTagValue("stdDay", eElement));
//					System.out.println("시도명(한글) : " + getTagValue("gubun", eElement));
//					System.out.println("시도명(영어) : " + getTagValue("gubunEn", eElement));
//					System.out.println("확진자 수 : " + getTagValue("defCnt", eElement));
//					System.out.println("사망자 수 : " + getTagValue("deathCnt", eElement));
//					System.out.println("격리해제 수 : " + getTagValue("isolClearCnt", eElement));
//					System.out.println("치료중 환자 수(격리중) : " + getTagValue("isolIngCnt", eElement));
//					System.out.println("전일대비 증감수 : " + getTagValue("incDec", eElement));
//					System.out.println("10만명당 발생률 : " + getTagValue("qurRate", eElement));
//					System.out.println("해외유입 수 : " + getTagValue("overFlowCnt", eElement));
//					System.out.println("지역발생 수 : " + getTagValue("localOccCnt", eElement));

					String stdDate = getTagValue("stdDay", eElement);
					vo.setStdDay(stdDate.substring(0, 4) + stdDate.substring(6, 8) + stdDate.substring(10, 12));
					vo.setStdTime(stdDate.substring(14, 16) + ":00");
					vo.setCityNm(getTagValue("gubun", eElement));
					vo.setDefCnt(Integer.parseInt(getTagValue("defCnt", eElement)));
					vo.setDeathCnt(Integer.parseInt(getTagValue("deathCnt", eElement)));
					vo.setIsolClearCnt(Integer.parseInt(getTagValue("isolClearCnt", eElement)));
					vo.setIsolIngCnt(Integer.parseInt(getTagValue("isolIngCnt", eElement)));
					vo.setIncDec(Integer.parseInt(getTagValue("incDec", eElement)));

					if (getTagValue("qurRate", eElement).equals("-")) {
						vo.setQurRate(-1);
					} else {
						vo.setQurRate(Float.parseFloat(getTagValue("qurRate", eElement)));
					}
					vo.setOverFlowCnt(Integer.parseInt(getTagValue("overFlowCnt", eElement)));
					vo.setLocalOccCnt(Integer.parseInt(getTagValue("localOccCnt", eElement)));

					list.add(vo);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (list.size() != 0) {
			dao.delete();
			String msg = dao.insert(list);
			System.out.println("총 삽입 결과 : " + msg);
		}
	}

	// tag 값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {

		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);

		if (nValue == null) {
			return null;
		}

		return nValue.getNodeValue();
	}
}