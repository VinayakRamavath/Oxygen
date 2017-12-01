package com.stackroute.Parser.DataStore;



import java.util.HashMap;
import java.util.Map;

public class DataStore {
	
	//HashMap<String, HashMap<String, List<Integer>>()> scoreMap=new HashMap<String, HashMap<String, List<Integer>>()>();
//	HashMap<String, HashMap<String,Integer>> termScores=new HashMap <String, HashMap<String, Integer>>();
//	
	Map<String, Integer> termScores = new HashMap<String, Integer>();
	
	public int getTermScores(String term) {
		
		return termScores.get(term);
	}
	
	public Map<String, Integer> getMap()
	{
		return termScores;
	}

	public void setTermScores( final String term, final int count) {
//		termScores.put(serial,new HashMap<String, List<Integer>>.put(term, count)); 

//			termScores.put(serial, new HashMap(){{put(term,count);}});
		
		termScores.put(term,count);
		

	}

	public void clearTable() {
		termScores.clear();
	}
}
