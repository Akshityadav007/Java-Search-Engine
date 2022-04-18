package com.pratian.searchengine.model.search;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
	private	List <String>filesFoundPath = new ArrayList<String>();
	private int foldersScanned = 1;
	
	public void addFilesFoundPath(String fileFound)
	{
		this.filesFoundPath.add(fileFound);
	}
	public void incrementFoldersScanned()
	{
		foldersScanned++;
	}
	public List<String> getFilesFoundPath() {
		return filesFoundPath;
	}
	public int getFoldersScanned() {
		return foldersScanned;
	}
}
