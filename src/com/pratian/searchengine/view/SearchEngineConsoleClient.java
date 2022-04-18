package com.pratian.searchengine.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.pratian.searchengine.control.SearchControl;
//import com.pratian.searchengine.model.search.SearchHistoryMgr;
//import com.pratian.searchengine.model.search.SearchMgr;
import com.pratian.searchengine.model.search.SearchResult;

public class SearchEngineConsoleClient {
	
	private SearchControl control;
	
	
	
	public SearchEngineConsoleClient(SearchControl control) {
		super();
		this.control = control;
	}

	public void acceptUserInput(){
		String[] drives = {"C:\\","D:\\"};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String fileToSearch = sc.nextLine();
		control.performFileSearch(fileToSearch, drives);
	}
	
	public void displaySearchResult(List<String> paths){
		for(String path : paths){
			System.out.println(path);
		}
	}
	public void displaySearchResult(String drive, SearchResult result){
		List<String> paths = result.getFilesFoundPath();
		System.out.println(drive);
		System.out.println("Number of folders scanned : " + result.getFoldersScanned());
		if(paths.size() >=1) {
			System.out.println("File found in the following location(s)");
			for(String path : paths)
				System.out.println(path);
		}else
			System.out.println("File not found");
	}
}
