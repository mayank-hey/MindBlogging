package edu.web.util;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 
 * @author Mayank-hey
 *
 */

public class Calculator {
	
	int calculateScore(ArrayList<Integer> scores, ArrayList<Timestamp> times){
		int latestScore = scores.get(scores.size()-1);
		long lastTime = times.get(times.size()-1).getTime();
		
		long sumOfInvertedTimeDiff = 0;
		long sumOfWtdScoreDiff = 0;
		for(int i=0; i<times.size()-2; i++){
			long currTime = times.get(i).getTime();
			int currScore = scores.get(i);
			sumOfInvertedTimeDiff += 1/(lastTime-currTime);
			sumOfWtdScoreDiff += (latestScore-currScore)/(lastTime-currTime);
		}
		return latestScore + (int)(sumOfWtdScoreDiff/sumOfInvertedTimeDiff);
	}
}
