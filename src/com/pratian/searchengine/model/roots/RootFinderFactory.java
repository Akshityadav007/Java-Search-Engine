package com.pratian.searchengine.model.roots;

public class RootFinderFactory {
	public RootFinder create(Roots rootType){
		RootFinder finder = null;
		switch(rootType){
			case ACTIVE_ROOTS : finder = new ActiveRootFinder();
				 break;
			default : finder = new SystemRootFinder();
		}
		return finder;
	}
}
