package com.pratian.searchengine.model.roots;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class SystemRootFinder implements RootFinder {

	private List<String> allRoots = new ArrayList<String>();
	private int size;
	
	SystemRootFinder(){
		File[] roots = File.listRoots();
		for(File f : roots)
			allRoots.add(f.getAbsolutePath());
		size = allRoots.size();
	}
	
	@Override
	public List<String> getRoots() {
		return allRoots;
	}

	@Override
	public int getNumOfRoots() {
		return size;
	}

}
