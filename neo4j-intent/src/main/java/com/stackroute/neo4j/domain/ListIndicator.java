package com.stackroute.neo4j.domain;

import java.util.Collection;

public class ListIndicator {
	
	private Collection<Indicator> listindicator;

	public ListIndicator(Collection<Indicator> graphtermslist) {
		listindicator=graphtermslist;
	}

	public Collection<Indicator> getListindicator() {
		return listindicator;
	}

	public void setListindicator(Collection<Indicator> listindicator) {
		this.listindicator = listindicator;
	}
	
	

}
