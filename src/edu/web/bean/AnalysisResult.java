package edu.web.bean;

import java.util.ArrayList;

public class AnalysisResult {
	
	double neg;
	double neu;
	double pos;
	
	int emoScore;
	
	ArrayList<String> terms = new ArrayList<String>();
	
	public double getEmoScore() {
		return emoScore;
	}
	public void setEmoScore(int emoScore) {
		this.emoScore = emoScore;
	}
	
	public double getNegative() {
		return neg;
	}
	public void setNegative(double negative) {
		this.neg = negative;
	}
	public double getNeutral() {
		return neu;
	}
	public void setNeutral(double neutral) {
		this.neu = neutral;
	}
	public double getPositive() {
		return pos;
	}
	public void setPositive(double positive) {
		this.pos = positive;
	}
	public ArrayList<String> getKeywords() {
		return terms;
	}
	public void setKeywords(ArrayList<String> keywords) {
		this.terms = keywords;
	}
	
	public void updateScore() {
		this.emoScore = (int)((neu/2.0 + pos)/10.0);
	}
	
	@Override
	public String toString(){
		return "negative: " + neg + " neutral: " + neu + " positive: " + 
				pos + " emoScore: " + emoScore + " Keywords: " + keywordsAll();
	}
	
	private String keywordsAll() {
		String out="";
		for(String str : terms){
			out+= str + ";";
		}
		return out;
	}
}
