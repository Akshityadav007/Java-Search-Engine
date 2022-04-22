package com.example.searchengine.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.searchengine.model.search.SearchHistoryMgr;
import com.example.searchengine.model.search.SearchMgr;
import com.example.searchengine.model.search.SearchResult;
import com.example.searchengine.view.SearchEngineConsoleClient;

public class SearchControl {
	SearchEngineConsoleClient client = new SearchEngineConsoleClient(this);

	public void initSearch() {
		client.acceptUserInput();
	}

	public void performFileSearch(String fileToSearch, String[] drives) {
		if (SearchHistoryMgr.isHistoryAvailable(fileToSearch)) {
			List<String> list = SearchHistoryMgr.getSearchHistory(fileToSearch);
			client.displaySearchResult(list);
		} else {
			SearchMgr mgr = new SearchMgr();
			Map<String, SearchResult> map = mgr.searchForFileOnDrive(fileToSearch, drives);
			Set<String> keys = map.keySet();
			List<String> pathsToSave = new ArrayList<String>();
			for (String key : keys) {
				SearchResult sr = map.get(key);
				List<String> paths = sr.getFileFoundPath();
				pathsToSave.addAll(paths);
				client.displaySearchResult(key, sr);
			}
			SearchHistoryMgr.saveSearchToFile(pathsToSave, fileToSearch);

		}
	}

}
