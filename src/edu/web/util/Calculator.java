package edu.web.util;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 
 * @author Mayank-hey
 *
 */

public class Calculator {
	
	public int calculateScore(ArrayList<Integer> scores, ArrayList<Timestamp> times){
		int latestScore = scores.get(0);
		long lastTime = times.get(0).getTime();
		
		long sumOfInvertedTimeDiff = 0;
		long sumOfWtdScoreDiff = 0;
		for(int i=1; i<times.size()-1; i++){
			long currTime = times.get(i).getTime();
			int currScore = scores.get(i);
			sumOfInvertedTimeDiff += 1/(lastTime-currTime);
			sumOfWtdScoreDiff += (latestScore-currScore)/(lastTime-currTime);
		}
		return latestScore + (int)(sumOfWtdScoreDiff/sumOfInvertedTimeDiff);
	}
	
	public boolean needsHelp(ArrayList<Integer> scores){
		if(scores.size()<7)
			return false;
		int sumOfScores=0;
		for(int i=0; i<7; i++){
			sumOfScores+=i;
		}
		if(sumOfScores/7 <= 3)
			return true;
		return false;
	}
}
