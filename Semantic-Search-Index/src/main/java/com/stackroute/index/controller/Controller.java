package com.stackroute.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.index.messenger.Listener;
import com.stackroute.index.messenger.Sender;
import com.stackroute.index.model.IndexerModel;
import com.stackroute.index.service.IndexService;
import com.stackroute.index.service.ScoreService;
import com.stackroute.index.service.SenderService;

/*
 * Controller for Indexer
 */
//@EnableSwagger2
@RestController
@RequestMapping("/v1/semanticsearch/indexservice")
public class Controller {
//	
//	IndexService indexservice = new IndexService();
//	
//	@Autowired
//	Listener listener;
	
	
	//Give the result of indexer service
//	@RequestMapping()
//	public ResponseEntity<IndexerModel> getCS() {
//		
//
//		IndexerModel indexermodel = listener.getIndexermodel();
//		
//		
//		return new ResponseEntity<IndexerModel>(indexermodel, HttpStatus.OK);
//	}
}
