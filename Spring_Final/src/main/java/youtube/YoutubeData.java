package youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import corona.KoreaVo;

@Component
public class YoutubeData {
	@Autowired
	YoutubeDao dao;
	
	public void search() throws IOException {

		String apiurl = "https://www.googleapis.com/youtube/v3/search";
		apiurl += "?key=AIzaSyCEyrtmU5850xBpZbKU6m-R8tM6q0_601A";
		apiurl += "&part=snippet&type=video&maxResults=3&videoEmbeddable=true";
		apiurl += "&q=" + URLEncoder.encode("코로나19", "UTF-8");

		URL url = new URL(apiurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		//System.out.println(response.toString());
		
		JsonParser Parser = new JsonParser();
		JsonObject jsonObj = (JsonObject) Parser.parse(response.toString());
		JsonArray arr = (JsonArray) jsonObj.get("items");
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < arr.size(); i++) {
			JsonObject object = (JsonObject) arr.get(i);
			JsonObject id = (JsonObject) object.get("id");
			
			String videoId = id.get("videoId").getAsString();
			
			System.out.println(videoId);
			list.add(videoId);
		}
		
		dao.delete();
		String msg = dao.insert(list);
		System.out.println("총 삽입 결과 : " + msg);
	}
}
