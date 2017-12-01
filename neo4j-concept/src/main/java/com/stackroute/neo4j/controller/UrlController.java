package com.stackroute.neo4j.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.jcabi.aspects.Loggable;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlFromGoogle;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.messenger.Listener;
import com.stackroute.neo4j.messenger.Sender;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.IndexerModel;
import com.stackroute.neo4j.domain.IntentSearchResult;
import com.stackroute.neo4j.domain.ListUrls;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.service.RelatedService;
import com.stackroute.neo4j.service.SameService;
import com.stackroute.neo4j.service.SubconceptService;
import com.stackroute.neo4j.service.UrlService;

//url controller class

@RestController
@RequestMapping("/v1.0/semantic/neo4jconceptservice")
public class UrlController {

	@Autowired
	UrlService urlService;

	@Autowired
	Listener listen;

	@Autowired
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}

	@CrossOrigin("*")
	@RequestMapping("/geturl")
	public Iterable<UrlRelation> graph_ur() {
		return urlService.graph_url();
	}

	// post relationship from domain users

	@Autowired
	Sender sender;

	@CrossOrigin("*")
	@RequestMapping("/getresults")
	public List<UrlRelation> giveresults() throws InterruptedException {
		// List<UrlRelation> resultss=;
		System.out.println("FINAL LIST");
		List<UrlRelation> resultss = urlService.get();
		System.out.println(resultss);
		System.out.println("DONE");
		return resultss;
	}

	// @CrossOrigin("*")
	// @RequestMapping("/geturl/{concept}")
	// public List<UrlRelation> graph_url(@PathVariable("concept") String concept) {
	// // return urlService.graph_url();
	// System.out.println(concept);
	// Iterable<UrlRelation> urlRelation = urlService.graph_url();
	// List<UrlRelation> myList = Lists.newArrayList(urlRelation);
	// List<UrlRelation> myList1 = new ArrayList<UrlRelation>();
	// for (int i = 0; i < myList.size(); i++) {
	// System.out.println(myList.get(i).getConcept2().getName());
	// if (myList.get(i).getConcept2().getName().equals(concept)) {
	// myList1.add(myList.get(i));
	// }
	// }
	// return myList1;
	// }
	//
	// @CrossOrigin("*")
	// @RequestMapping("/geturlintent/{concept}/{intent}")
	// public List<UrlRelation> graph_url_intent(@PathVariable("concept") String
	// concept,
	// @PathVariable("intent") String intent) {
	// // return urlService.graph_url();
	// System.out.println(concept);
	// System.out.println(intent);
	// Iterable<UrlRelation> urlRelation = urlService.graph_url();
	// List<UrlRelation> myList = Lists.newArrayList(urlRelation);
	// List<UrlRelation> myList1 = new ArrayList<UrlRelation>();
	// for (int i = 0; i < myList.size(); i++) {
	// System.out.println(myList.get(i).getConcept2().getName());
	// if (myList.get(i).getConcept2().getName().equals(concept)) {
	// myList1.add(myList.get(i));
	// }
	// }
	// if (intent.equals("basics")) {
	// Collections.sort(myList1, UrlRelation.BasicScoreComparator);
	// Collections.reverse(myList1);
	// }
	// if (intent.equals("tutorials")) {
	// Collections.sort(myList1, UrlRelation.TutorialScoreComparator);
	// Collections.reverse(myList1);
	// }
	// if (intent.equals("gettingstarted")) {
	// Collections.sort(myList1, UrlRelation.GettingStartedScoreComparator);
	// Collections.reverse(myList1);
	// }
	// if (intent.equals("examples")) {
	// Collections.sort(myList1, UrlRelation.ExamplesScoreComparator);
	// Collections.reverse(myList1);
	// }
	// if (intent.equals("troubleshooting")) {
	// Collections.sort(myList1, UrlRelation.TroubleShootingScoreComparator);
	// Collections.reverse(myList1);
	// }
	// if (intent.equals("completereference")) {
	// Collections.sort(myList1, UrlRelation.CompleteReferenceComparator);
	// Collections.reverse(myList1);
	// }
	// return myList1;
	// }

	@RequestMapping("/graphurl/{name}")
	public UrlFromGoogle graph_concept(@PathVariable("name") String name) {
		try {
			return urlService.findlevelbyname(name);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	@PostMapping("/posturl")
	public @ResponseBody ResponseEntity<UrlRelation> saveNewSubconcept(@RequestBody UrlRelation indexerModel) {
		try {
			UrlRelation urlRelation = urlService.postnode(indexerModel);
			return new ResponseEntity<UrlRelation>(urlService.postnode(urlRelation), HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	@PostMapping("/posturls")
	public @ResponseBody ResponseEntity<?> sendNewSubconcept(@RequestBody ListUrls result) {
		sender.send(result);
		return new ResponseEntity<String>("done", HttpStatus.OK);
	}

}
