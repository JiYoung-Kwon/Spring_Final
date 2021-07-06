package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VaccinUpdate {
	@Autowired
	GraphDao dao;

	public void koUpdate() {
		String Address;
		URL url;
		BufferedReader br;
		HttpURLConnection conn;
		String protocol = "GET";
		String gie;
		String array[] = new String[100];
		String array1[] = new String[100];
		int p = 0;
		try {
			Address = "https://nip.kdca.go.kr/irgd/cov19stats.do?list=all";
			url = new URL(Address);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(protocol);
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				gie = line.replace("<?xml version='1.0' encoding='UTF-8' ?>", "").replace("<response>", "")
						.replace("</response>", "").replace("<body>", "").replace("</body>", "")
						.replace("<dataTime>", "fhxsa").replace("<items>", "").replace("<item>", "")
						.replace("<tpcd>당일실적(A)</tpcd>", "").replace("<tpcd>전체건수(C): (A)+(B)</tpcd>", "")
						.replace("<tpcd>전일누적(B)</tpcd>", "").replace("</dataTime>", "").replace("</item>", "")
						.replace("<firstCnt>", "fhxsa").replace("</firstCnt>", "").replace("<secondCnt>", "fhxsa")
						.replace("</items>", "").replace("</secondCnt>", "");
				array = gie.split("fhxsa");
				for (int i = 0; i < array.length; i++) {
					if (array[i] != "" && array[i] != null) {
						array1[p] = array[i];
						p++;
					}
				}

			}
			br.close();
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
		koDataVo vo = new koDataVo();
		vo.setOneday(array1[9]);
		vo.setOneplu(array1[5]);
		vo.setOnesum(array1[7]);
		vo.setTwoday(array1[10]);
		vo.setTwoplu(array1[6]);
		vo.setTwosum(array1[8]);
		dao.kodata(vo);

		DdateVo dv = new DdateVo();
		dv.setName("1");
		dv.setDdate(array1[4]);
		dao.Ddate(dv);
	}

	public void G7Update() {
		String url = "https://www.bbc.com/korean/features-56066227"; // 크롤링할 url지정
		Document doc = null; // Document에는 페이지의 전체 소스가 저장된다
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Elements element = doc.select("div.table-container");
		int i = 0;
		int[] array = new int[9];
		if (doc != null) {
			for (Element el : element.select("td.td.th--v.td--l")) {
				if (el.text().equals("전 세계")) {
					
					array[0] = i;
				}
				if (el.text().equals("캐나다")) {
					
					array[1] = i;
				}
				if (el.text().equals("미국")) {
					
					array[2] = i;
				}
				if (el.text().equals("일본")) {
					
					array[3] = i;
				}
				if (el.text().equals("독일")) {
					
					array[4] = i;
				}
				if (el.text().equals("이탈리아")) {
					
					array[5] = i;
				}
				if (el.text().equals("프랑스")) {
				
					array[6] = i;
				}
				if (el.text().equals("영국")) {
					
					array[7] = i;
				}
				if (el.text().equals("한국")) {
					
					array[8] = i;
				}
				i++;
			}

			int j = 0;
			GraphVo vo = new GraphVo();

			for (Element el : element.select("div.value")) {
				if (j == array[0]) {
					
					vo.setName("전 세계");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[1]) {
					
					vo.setName("캐나다");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[2]) {
					
					vo.setName("미국");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[3]) {
					
					vo.setName("일본");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[4]) {
					
					vo.setName("독일");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[5]) {
					
					vo.setName("이탈리아");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[6]) {
					
					vo.setName("프랑스");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[7]) {
					
					vo.setName("영국");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				if (j == array[8]) {
					
					vo.setName("한국");
					vo.setPercent(el.text());
					dao.G7UpDate(vo);
				}
				j++;
			}
			String Ddate = null;
			Elements element1 = doc.select("div.table-footer");
			for (Element el : element1.select("p.footer-timestamp")) {
				Ddate = el.text();
			}
			DdateVo dv = new DdateVo();
			dv.setName("3");
			dv.setDdate(Ddate);
			dao.Ddate(dv);
		}
	}

	public void CityUpData() {
		String result = "";
		BufferedReader br = null;
		Date time = new Date();
		Date d1 = null;
		Date d2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		URL url;

		try {
			d1 = sdfh.parse("10:00");
			d2 = sdfh.parse(sdfh.format(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String strToday = sdf.format(c1.getTime());
		c2.add(Calendar.DATE, -1);
		String stryesday = sdf.format(c2.getTime());
		String lie = "";
		String array[] = new String[400];
		DdateVo dv = new DdateVo();
		try {
			if (d2.compareTo(d1) >= 0) {
				url = new URL(
						"https://api.odcloud.kr/api/15077756/v1/vaccine-stat?page=1&perPage=18&cond%5BbaseDate%3A%3AEQ%5D="
								+ strToday
								+ "%2000%3A00%3A00&serviceKey=VEKVIb6ivfupH3Zdlx5e47YinVobNxxY%2F59eROUkDhQ81ReilKjcl%2FAi8358JCpROyt3XJlRubKuBYxpdmo5SA%3D%3D"); // 해당
				dv.setName("2");
				dv.setDdate(strToday);
				dao.Ddate(dv);
			} else {
				url = new URL(
						"https://api.odcloud.kr/api/15077756/v1/vaccine-stat?page=1&perPage=18&cond%5BbaseDate%3A%3AEQ%5D="
								+ stryesday
								+ "%2000%3A00%3A00&serviceKey=VEKVIb6ivfupH3Zdlx5e47YinVobNxxY%2F59eROUkDhQ81ReilKjcl%2FAi8358JCpROyt3XJlRubKuBYxpdmo5SA%3D%3D");
				dv.setName("2");
				dv.setDdate(stryesday);
				dao.Ddate(dv);
				
	
			}
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection(); // url 가져오기
			urlconn.setRequestMethod("GET"); // get 타입

			br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
			result = br.readLine();
			result = result.substring(result.indexOf("[") + 1, result.indexOf("]"));
			lie = result.replace("{\"accumulatedFirstCnt\":", "").replace(",\"accumulatedSecondCnt\":", "fhxsa")
					.replace(",\"baseDate\":\"", "fhxsa").replace(stryesday, "").replace(strToday, "")
					.replace(" 00:00:00\",", "").replace("\"firstCnt\":", "").replace(",\"secondCnt\":", "fhxsa")
					.replace("}", "").replace(",\"sido\":\"", "fhxsa").replace("\",\"totalFirstCnt\":", "fhxsa")
					.replace(",\"totalSecondCnt\":", "fhxsa").replace(",", "fhxsa");
			array = lie.split("fhxsa");
			
			
			CityDataVo vo = new CityDataVo();

			for (int i = 0; i < (array.length) / 7; i++) {
				if (array[i * 7 + 4].equals("전국")) {
					vo.setNum("합계");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("서울특별시")) {
					vo.setNum("서울");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("부산광역시")) {
					vo.setNum("부산");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("대구광역시")) {
					vo.setNum("대구");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);

					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("광주광역시")) {
					vo.setNum("광주");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("인천광역시")) {
					vo.setNum("인천");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);

					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("대전광역시")) {
					vo.setNum("대전");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("울산광역시")) {
					vo.setNum("울산");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);

					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("세종특별자치시")) {
					vo.setNum("세종");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("경기도")) {
					vo.setNum("경기");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("강원도")) {
					vo.setNum("강원");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("충청북도")) {
					vo.setNum("충북");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("충청남도")) {
					vo.setNum("충남");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("전라북도")) {
					vo.setNum("전북");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("전라남도")) {
					vo.setNum("전남");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("경상북도")) {
					vo.setNum("경북");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("경상남도")) {
					vo.setNum("경남");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
				if (array[i * 7 + 4].equals("제주특별자치도")) {
					vo.setNum("제주");
					vo.setOneplu(array[i * 7 + 2]);
					vo.setOnesum(array[i * 7 + 5]);
					vo.setTwoplu(array[i * 7 + 3]);
					vo.setTwosum(array[i * 7 + 6]);
					dao.CityUpdate(vo);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
