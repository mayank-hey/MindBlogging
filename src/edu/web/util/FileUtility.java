package edu.web.util;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author mayank-hey
 * 
 */

public class FileUtility {
	private static final String FILE_PATH = "";//"D:\\api_data";
	private static final String FILE_NAME = "api_call_count.log";

	public static int readAPICount(){
		Path file = FileSystems.getDefault().getPath(FILE_PATH, FILE_NAME);
		int count=0;
		try {
			InputStream in = Files.newInputStream(file);
		    BufferedReader reader =
		      new BufferedReader(new InputStreamReader(in));
		    String line = null;
		    line = reader.readLine();
		    System.out.println("Number of API Calls yet: " + line);
		    count = Integer.parseInt(line);
		} catch (IOException x) {
		    System.err.println(x);
		}
		return count;
	}
	
	public static void updateAPICount(int i) {
		Path file = FileSystems.getDefault().getPath(FILE_PATH, FILE_NAME);
		try {
			OutputStream out = Files.newOutputStream(file);
		    BufferedWriter writer =
		      new BufferedWriter(new OutputStreamWriter(out));
		    writer.write(i+"");
		    writer.close();
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
}
