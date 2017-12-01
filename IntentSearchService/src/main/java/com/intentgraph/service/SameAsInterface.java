package com.intentgraph.service;

import org.springframework.stereotype.Service;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;
import com.intentgraph.domain.SameAs;
import com.intentgraph.domain.Terms;

public interface SameAsInterface {
	public  Iterable<IntentOf>  graph_node(int limit);
	public String  postnode(IntentOf intentOf);
	public String  postnode1(SameAs sameAs);
	public String  findquerybyname(String name);
	public Level  findlevelbyname(String name);
	public Terms  findtermsbyname(String name);


}
