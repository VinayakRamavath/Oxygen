package com.stackroute.github.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.stackroute.github.domain.DomainConcept;
import com.stackroute.github.domain.Result;
import com.stackroute.github.domain.SearchResultsModel;
//import com.stackroute.github.repository.ApiRepository;
import com.stackroute.github.repository.ApiRepository;

import org.apache.kafka.common.network.SaslChannelBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//Service implementation
@Service
// @EnableAsync
public class ApiServiceImpl implements ApiService {

	@Autowired
	ApiRepository userRepository;

	DomainConcept dc = new DomainConcept();

	public SearchResultsModel callAPI(String apikey, int startIndex)
			throws UnsupportedEncodingException, IOException, ParseException {
		randomSleep(3000, TimeUnit.MILLISECONDS);
		// getting domain and concept value
		String concept = dc.getConcept();
		String domain = dc.getDomain();

		// modified

		String a = concept;
		char[] b = a.toCharArray();
		String c = "";
		for (int i = 0; i < b.length; i++) {
			if (b[i] == ' ') {
				// .charAt(i)=="%20";
				c = c + "%20";

			} else {
				c = c + b[i];
			}
		}

		System.out.println(c.toString());

		// modified closed

		// Calling Google Api
		String google;
		String charset = "UTF-8";
		URL url;
		Reader reader;
		// arraylist of results of all diffrent objects returend by unique api keys

		google = "https://www.googleapis.com/customsearch/v1?key=" + apikey + "&cx=004616343863470620550:arwd3_bijlo&q="
				+ domain + "%20" + c + "&start=" + startIndex;
		System.out.println(google);
		url = new URL(google);
		reader = new InputStreamReader(url.openStream(), charset);
		SearchResultsModel results = new Gson().fromJson(reader, SearchResultsModel.class);

		// userRepository.save(dc);
		results.setConcept(concept);
		results.setDomain(domain);
		System.out.println(results.getItems().get(0).getSnippet());

		// System.out.println(results.);
		// System.out.println(listofFinalresults.get(2).toString());
		return results;

	}

	public static void randomSleep(int duration, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(ThreadLocalRandom.current().nextInt(duration));
		} catch (InterruptedException e) {
			Throwables.propagate(e);
		}
	}

	public Iterable<DomainConcept> fetchresults() throws Exception {

		Iterable<DomainConcept> results = userRepository.findAll();

		return results;
	}

	// public String getDomain() {
	//
	//
	// return null;
	//
	// }

	public void setDomconc(String domain, String concept) {

		dc.setConcept(concept);
		dc.setDomain(domain);

	}

	// public void saveDC(DomainConcept record) {
	// userRepository.save(record);
	// }

}
