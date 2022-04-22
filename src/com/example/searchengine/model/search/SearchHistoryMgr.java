package com.example.searchengine.model.search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SearchHistoryMgr {
	public static boolean isHistoryAvailable(String fileName) {
		File file = new File(getLogFileName(fileName));
		return file.exists();
	}

	public static List<String> getSearchHistory(String fileName) {
		List<String> list = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(getLogFileName(fileName)));
			String path = "";
			while ((path = reader.readLine()) != null) {
				if (new File(path).exists()) {
					list.add(path);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void saveSearchToFile(List<String> list,String fileName) {
		BufferedWriter writer = null;
		try {
			String logFileName =  getLogFileName(fileName);
			writer = new BufferedWriter(new FileWriter(logFileName));
			
			for(String s : list)
				writer.write(s + "\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String getLogFileName(String fileName) {
		StringBuilder logFileName = new StringBuilder();
		logFileName.append(fileName);
		logFileName.append(".log");
		return logFileName.toString();
	}
}

