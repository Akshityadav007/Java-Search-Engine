package com.pratian.searchengine.model.roots;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ActiveRootFinder implements RootFinder {

	private List<String> allRoots = new ArrayList<String>();
	private int size;
	
	ActiveRootFinder(){
		File[] roots = File.listRoots();
		for(File f : roots)
			if(f.canRead())
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
