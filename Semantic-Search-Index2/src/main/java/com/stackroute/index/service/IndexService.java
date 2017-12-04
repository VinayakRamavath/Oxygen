package com.stackroute.index.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stackroute.index.model.Indicator;

@Service
@Component
public class IndexService {
	
	SenderService senderService = new SenderService();
	ScoreService scoreservice = new ScoreService();

	public Map<String, Double> getScore( Map<String, Integer> terms, Collection<Indicator> termweight) {
		
		return senderService.putdata(scoreservice.searchTerm(terms,termweight));
	}

	
}
