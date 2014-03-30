package edu.web.util;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * @author mayank-hey
 * 
 */

public class FileUtility {
	private static final String FILE_PATH = "";//"D:\\api_data";
	private static final String FILE_NAME = "api_call_count.log";

	public static int readAPICount(){
		int count=0;
		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(FILE_PATH+FILE_NAME));
		    String line = reader.readLine();
		    System.out.println("Number of API Calls yet: " + line);
		    count = Integer.parseInt(line);
		} catch (IOException ex) {
		  // report
		} finally {
		   try {reader.close();} catch (Exception ex) {}
		}
		
		return count;
	}
	
	public static void updateAPICount(int i) {
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(FILE_NAME), "utf-8"));
		    writer.write(i+"");
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	}
}
