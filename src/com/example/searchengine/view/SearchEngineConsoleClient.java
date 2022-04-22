package com.example.searchengine.view;

import java.util.List;

import com.example.searchengine.control.SearchControl;
import com.example.searchengine.model.search.SearchResult;

public class SearchEngineConsoleClient {
	
	private SearchControl control;
	
	public SearchEngineConsoleClient(SearchControl ctrl) {
		super();
		this.control = ctrl;
	}
	
	public void acceptUserInput() {
		String[] drives = {"C:\\","D:\\"};
		String fileToSearch = "pom.xml";
		control.performFileSearch(fileToSearch, drives);
	}
	
	public void displaySearchResult(List<String> paths) {
		for(String path : paths) {
			System.out.println(path);
		}
	}
	
	public void displaySearchResult(String drive, SearchResult result) {
		List<String> paths = result.getFileFoundPath();
		System.out.println(drive);
		System.out.println("Number of folders scanned : " + result.getFoldersScanned());
		if(paths.size() >= 1) {
			System.out.println("File found in the following location(s)");
			for(String path: paths) {
				System.out.println(path);
			}
		}
		else {
			System.out.println("File not found");
		}
	}
}
