package com.example.searchengine.model.search;

import java.io.File;

public class FileSearcher extends Thread{
	private File drive;
	private String fileToSearch;
	private SearchResult result = new SearchResult();
	
	public FileSearcher(String root,String fileToSearch) {
		super();
		this.drive = new File(root);
		this.fileToSearch = fileToSearch;
	}
	
	public void run() {
		searchFile(drive);
	}
	
	public String getDrive() {
		return drive.getAbsolutePath();
	}
	
	private void searchFile(File folder) {
		// logic of searching a file
		
		File[] subFoldersandFiles = folder.listFiles();
		if(subFoldersandFiles != null) {
			for(File f : subFoldersandFiles) {
				if(f.isFile()) {
					if(f.getName().equalsIgnoreCase(fileToSearch)) {
						result.addFileFoundPath(f.getAbsolutePath());
					}
				}
				else {
					result.incrementFoldersScanned();
					searchFile(f);
				}
			}
		}
	}
	
	public SearchResult getSearchResult() {
		return result;
	}
}
