package com.diksha.spellcheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diksha.spellcheck.config.Sender;
import com.diksha.spellcheck.domain.SpellCheckSuggestions;
import com.diksha.spellcheck.service.SpellCheckService;

@RestController
@RequestMapping("/spellcheck")
public class SpellCheckController {
	@Autowired
	SpellCheckService spellcheckService;

	@CrossOrigin("*")

	// @RequestMapping(value="/query")
	@PostMapping("/query")
	public ResponseEntity<?> method(@RequestParam String query) {
		// public ResponseEntity<?> method( ){

		String[] wordsArray = query.split(" ");

		spellcheckService.getSpellcheckSuggestions(wordsArray);

		return new ResponseEntity<String>("done", HttpStatus.OK);
	}

}
