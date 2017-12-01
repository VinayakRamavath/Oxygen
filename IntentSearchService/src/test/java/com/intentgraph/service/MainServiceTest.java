package com.intentgraph.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MainServiceTest {

	@Autowired
	MainService mainService;
	
	
	@Test(expected=NullPointerException.class)
	public void test() {
		String[] query= {"what", "is","interface"};
		mainService.graph_concept(query);
		assertNotNull(mainService);
	}

}
