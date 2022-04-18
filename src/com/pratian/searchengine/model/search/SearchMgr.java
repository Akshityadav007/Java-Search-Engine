package com.pratian.searchengine.model.search;

import java.util.HashMap;
import java.util.Map;

public class SearchMgr {
	
	public Map<String,SearchResult> searchForFileOnDrive(String fileName,String[] drives){
		HashMap<String,SearchResult> map = new HashMap<String,SearchResult>();
		
		FileSearcher[] searchers = new FileSearcher[drives.length];
		for(int i=0;i<drives.length;i++){
			searchers[i] = new FileSearcher(drives[i],fileName);
			searchers[i].start();
		}
		
		for(FileSearcher searcher : searchers)
		try {
			searcher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(FileSearcher searcher : searchers)
			map.put(searcher.getDrive(), searcher.getSearchResult());
			
		return map;
	}
}
