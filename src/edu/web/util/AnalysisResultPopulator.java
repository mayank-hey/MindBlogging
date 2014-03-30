package edu.web.util;

import java.util.ArrayList;

import org.codehaus.jackson.JsonNode;

import edu.web.bean.AnalysisResult;

/**
 * @author mayank-hey
 * 
 */

public class AnalysisResultPopulator {
	
	public static void populateAnalysisResult(AnalysisResult analResult, JsonNode node){
		node = node.get("docs").get(0);
		JsonNode scoresNode = node.get("sentiment_scores");
		analResult.setNegative(scoresNode.findValues("neg").get(0).asDouble());
		analResult.setPositive(scoresNode.findValues("pos").get(0).asDouble());
		analResult.setNeutral(scoresNode.findValues("neu").get(0).asDouble());
		ArrayList<String> strings = new ArrayList<String>();
		for(Object obj : node.findValuesAsText("term").toArray()){
			strings.add(obj.toString());
		}
		analResult.setKeywords(strings);
		analResult.updateScore();
	}
}
