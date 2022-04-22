package com.example.searchengine.model.search;

import java.util.*;

public class SearchResult {
	private List<String> fileFoundPath = new ArrayList<String>();
	private int foldersScanned = 1;
	
	public void addFileFoundPath(String fileFound) {
		this.fileFoundPath.add(fileFound);
	}
	
	public void incrementFoldersScanned() {
		foldersScanned++;
	}
	
	public List<String> getFileFoundPath(){
		return fileFoundPath;
	}
	
	public int getFoldersScanned() {
		return foldersScanned;
	}
}
