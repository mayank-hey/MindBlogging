package edu.web.bo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import edu.web.bean.AnalysisResult;
import edu.web.util.AnalysisResultPopulator;
import edu.web.util.FileUtility;

/**
 * @author mayank-hey
 * 
 */

public class SkyttleClient {
	
	private static final String YOUR_MASHAPE_KEY = "ruitZa9vMUWWZH3yD0IFELMhsI9UedaM";//+"123";

	public static void main(String[] args) throws UnsupportedEncodingException{
		
		AnalysisResult analResult = analyzeText("");
		System.out.println(analResult);
		//System.out.println("Response: " + response);

	}
	
	public static AnalysisResult analyzeText(String text){
		String url = "https://sentinelprojects-skyttle20.p.mashape.com/";
		if("".equals(text))
				text = "We have visited this restaurant a few times in the past, and the meals have been ok, but this time we were deeply disappointed.";
		String lang = "en";
		String keywords = "1";
		String sentiment = "1";
		String annotate = "0";

		String params=null;
		try {
			params = "text=" + URLEncoder.encode(text, "UTF-8") +
			"&lang=" + URLEncoder.encode(lang, "UTF-8") +
			"&keywords=" + URLEncoder.encode(keywords, "UTF-8") +
			"&sentiment=" + URLEncoder.encode(sentiment, "UTF-8") +
			"&annotate=" + URLEncoder.encode(annotate, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String response = makeCall(url, params);
		ObjectMapper mapper = new ObjectMapper();
		//mapper.
		//mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		AnalysisResult analResult = new AnalysisResult();
			try {
				JsonNode node = mapper.readValue(response, JsonNode.class);
				AnalysisResultPopulator.populateAnalysisResult(analResult, node);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//System.out.println(analResult);
			//System.out.println("Response: " + response);
		return analResult;
	}
	
	public static String makeCall(String targetURL, String urlParameters)
	  {
		int api_call_count = FileUtility.readAPICount();
		if(api_call_count>=99){
			System.out.println("API call limit exceeded");
			System.exit(1);
		}
		FileUtility.updateAPICount(api_call_count+1);
	    URL url;
	    HttpURLConnection connection = null;
	    try {
	      // create connection
	      url = new URL(targetURL);
	      connection = (HttpURLConnection) url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type",
	      				"application/x-www-form-urlencoded");
	      connection.setRequestProperty("X-Mashape-Authorization",
			YOUR_MASHAPE_KEY);
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      // send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes(urlParameters);
	      wr.flush();
	      wr.close();

	      // get Response
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer();
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      return response.toString();

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    } finally {

	      if(connection != null) {
	        connection.disconnect();
	      }
	    }
	  }
}