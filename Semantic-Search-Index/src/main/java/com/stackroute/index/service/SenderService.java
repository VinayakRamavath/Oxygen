package com.stackroute.index.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class SenderService {
	
	//put data in neo4j database (content graph)
	public Map<String, Double> putdata(List<Double> list)
	{
		// Enter confidence scores into map
		Map<String, Double> SMap = new HashMap<String, Double>();
		SMap.put("basicscore", list.get(0));
		SMap.put("tutorialscore", list.get(1));
		SMap.put("examplescore", list.get(2));
		SMap.put("trscore", list.get(3));
		SMap.put("tsscore", list.get(4));
		SMap.put("gsscore", list.get(5));
		
		Map<String,Double> CSMap = new TreeMap<>(SMap);
		
		return CSMap;
	}

}
