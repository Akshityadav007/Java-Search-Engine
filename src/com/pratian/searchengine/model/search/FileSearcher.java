package com.pratian.searchengine.model.search;

import java.io.File;

public class FileSearcher extends Thread {
	private File drive;
	private String fileToSearch;
	private SearchResult result = new SearchResult();
	
	public FileSearcher(String root, String fileToSearch) {
		super();
		this.drive = new File(root);
		this.fileToSearch = fileToSearch;
	}
	
	public void run(){
		searchFile(drive);
	}

	public String getDrive(){
		return drive.getAbsolutePath();
	}
	private void searchFile(File folder){
		// Write the logic of searching for a file 
		// in a specific drive
		
		File[] subFoldersAndFiles = folder.listFiles();
		if(subFoldersAndFiles != null)
			for(File f : subFoldersAndFiles){
				if(f.isFile()) {
					if(f.getName().equalsIgnoreCase(fileToSearch))
						//System.out.println(f.getAbsolutePath());
						result.addFilesFoundPath(f.getAbsolutePath());
				}
				else {
					result.incrementFoldersScanned();
					searchFile(f);
				}
			}
	}
	
	public SearchResult getSearchResult(){
		return result;
	}
}
