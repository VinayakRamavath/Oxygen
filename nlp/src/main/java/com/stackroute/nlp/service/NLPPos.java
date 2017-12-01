package com.stackroute.nlp.service;

import com.stackroute.nlp.domain.PosModel;

public interface NLPPos {
			
	public PosModel findPos(String sentence);
}
