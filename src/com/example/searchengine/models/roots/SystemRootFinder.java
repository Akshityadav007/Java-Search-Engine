package com.example.searchengine.models.roots;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SystemRootFinder implements RootFinder{
	private List<String> allRoots = new ArrayList<String>();
	private int size;
	
	SystemRootFinder(){
		File[] roots = File.listRoots();
		for(File f : roots) {
			if(f.canRead()) {
				allRoots.add(f.getAbsolutePath());
			}
			size = allRoots.size();
		}
	}
	
	@Override
	public List<String> getRoots(){
		return allRoots;
	}
	
	@Override
	public int getNumOfRoots() {
		return size;
	}
}
