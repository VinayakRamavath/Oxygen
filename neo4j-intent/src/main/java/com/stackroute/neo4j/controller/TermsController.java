package com.stackroute.neo4j.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jcabi.aspects.Loggable;
import com.stackroute.neo4j.domain.CounterIndicator;
import com.stackroute.neo4j.domain.Heading;
import com.stackroute.neo4j.domain.Indicator;
import com.stackroute.neo4j.domain.Intent;
import com.stackroute.neo4j.domain.Level;
import com.stackroute.neo4j.domain.ListIndicator;
import com.stackroute.neo4j.domain.Terms;
import com.stackroute.neo4j.messenger.Sender;
import com.stackroute.neo4j.service.IndicatorService;
import com.stackroute.neo4j.service.IntentService;

@Controller()
@RequestMapping("/v1.0/semantic/neo4jintentservice")
public class TermsController {

	@Autowired
	Sender kafkaSender;

	final IndicatorService indicatorService;

	final IntentService intentService;

	@Autowired
	public TermsController(IndicatorService indicatorService, IntentService intentService) {
		this.indicatorService = indicatorService;
		this.intentService = intentService;
	}

	@RequestMapping("/parserandindexer")
	public @ResponseBody ResponseEntity<String> graph_terms() {
		int limit = 100;
		TermsController t = new TermsController(indicatorService, intentService);
		t.graph_terms();
		t.get_terms(limit);
		return new ResponseEntity<String>("done", HttpStatus.OK);

	}


	@CrossOrigin("*")
	@RequestMapping("/graphterms")
	public @ResponseBody ListIndicator graph_terms(
			@RequestParam(value = "limit", required = false) Integer limit) {
		Iterable<Indicator> graphterms = indicatorService.graph_terms(limit == null ? 100 : limit);

		Collection<Indicator> graphtermslist = IteratorUtils.toList(graphterms.iterator());
		
		

		ListIndicator listindicator = new ListIndicator(graphtermslist);

		kafkaSender.sendclass(listindicator);
		return listindicator;

	}

	@CrossOrigin("*")
	@RequestMapping("/getterms")
	public @ResponseBody ArrayList<String> get_terms(@RequestParam(value = "limit", required = false) Integer limit) {
		Collection<Terms> collection = indicatorService.listterms(limit == null ? 100 : limit);
		ArrayList<Terms> roles = new ArrayList<>();
		ArrayList<String> terms = new ArrayList<>();

		for (Terms i : collection) {
			roles.add(i);
		}
		for (int i = 0; i < roles.size(); i++) {
			terms.add(roles.get(i).getName());
		}
		String[] frnames = terms.toArray(new String[terms.size()]);
		String arr = Arrays.toString(frnames);
		System.out.println(arr);
		kafkaSender.sendclass(arr);
		return terms;
	}

	@RequestMapping("/graphlevel/{name}")
	public Level graph_level(@PathVariable("name") String name) {
		System.out.println("hi" + name);
		Level level = indicatorService.findlevelbyname(name);
		return level;
	}

	@RequestMapping("/graphheading/{name}")
	public Heading graph_heading(@PathVariable("name") String name) {
		return intentService.findlevelbyname(name);
	}

	@PostMapping("/postindicator")
	public @ResponseBody ResponseEntity<Indicator> saveNewIndicator(@RequestBody Indicator indicator) {

		return new ResponseEntity<Indicator>(indicatorService.postnode(indicator), HttpStatus.OK);

	}

	@PostMapping("/postcounter")
	public @ResponseBody ResponseEntity<String> saveNewCounterIndicator(
			@RequestBody CounterIndicator counterIndicator) {

		return new ResponseEntity<String>(indicatorService.postnodecounter(counterIndicator), HttpStatus.OK);

	}

	@PostMapping("/postintent")
	public @ResponseBody ResponseEntity<String> saveNewIntent(@RequestBody Intent intent) {

		return new ResponseEntity<String>(intentService.postnode(intent), HttpStatus.OK);

	}


	@CrossOrigin("*")
	@PostMapping("/postcsvindicator")
	public @ResponseBody ResponseEntity<String> savefromcsv(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);
			f = new FileReader(basePath + "/javaIntent.csv");
			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(indicatorService, intentService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();
			}
			String line2;
			int inte = 0;
			while ((line2 = br.readLine()) != null) {
				inte++;
				String[] rows = line2.split(",");
				System.out.println(inte);
				System.out.println(rows[5]);
				if (rows[5].equals("indicatorOf") || rows[5].equals("IndicatorOf")) {
					String basePath1 = new File("").getAbsolutePath();
					System.out.println("base path : " + basePath1);
					fe = new FileReader(basePath1 + "/javaIntent.csv");
					BufferedReader bro = new BufferedReader(fe);
					Indicator indicator = new Indicator();
					System.out.println("weight" + (Float.valueOf(rows[6].trim())));
					indicator.setWeight(Float.valueOf(rows[6].trim()));
					// indicator.setWeight((float) 2.0);
					Terms terms = new Terms(rows[1].trim());
					indicator.setTerms(terms);
					// System.out.println("samadrita");
					String linee, levelname = "0";
					while ((linee = bro.readLine()) != null) {
						String[] rowss = linee.split(",");
						if (rowss[0].equals(rows[2])) {
							// System.out.println("hi");
							levelname = rowss[1];
							break;
						}
					}
					try {

						Level level1 = t.graph_level(levelname);
						System.out.println("level1" + level1.getId());
						indicator.setLevel(level1);
					} catch (NullPointerException e) {

						Level level = new Level();
						level.setName(levelname);
						indicator.setLevel(level);
					}

					System.out.println("vinayak" + indicator.getTerms().getName());
					t.saveNewIndicator(indicator);
					System.out.println("samadrita");
				}

			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);
	}

	@PostMapping("/postcsvcounter")
	public @ResponseBody ResponseEntity<String> savefromcsvcounter(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);
			f = new FileReader(basePath + "/javaIntent.csv");
			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(indicatorService, intentService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();

			}
			String line2;
			while ((line2 = br.readLine()) != null) {

				String[] rows = line2.split(",");

				System.out.println(rows[5]);
				if (rows[5].equals("counterIndicatorOf")) {
					String basePath1 = new File("").getAbsolutePath();
					System.out.println("base path : " + basePath1);
					fe = new FileReader(basePath1 + "/javaIntent.csv");
					BufferedReader bro = new BufferedReader(fe);
					// System.out.println("ayush");
					CounterIndicator counterIndicator = new CounterIndicator();
					counterIndicator.setWeight(Float.valueOf(rows[6].trim()));
					// counterIndicator.setWeight((float) 2.0);
					Terms terms = new Terms(rows[1].trim());
					counterIndicator.setTerms(terms);

					String linee, levelname = "0";
					while ((linee = bro.readLine()) != null) {
						String[] rowss = linee.split(",");
						if (rowss[0].equals(rows[2])) {
							// System.out.println("hi");
							levelname = rowss[1];
							break;
						}
					}
					try {

						Level level1 = t.graph_level(levelname);
						System.out.println("level1" + level1.getId());
						counterIndicator.setLevel(level1);
					} catch (NullPointerException e) {

						Level level = new Level();
						level.setName(levelname);
						counterIndicator.setLevel(level);
					}

					// System.out.println("vinayak"+indicator.getTerms().getName());

					t.saveNewCounterIndicator(counterIndicator);
				}

			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("other exception");
			e.printStackTrace();
		}

		return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);

	}

	@PostMapping("/postcsvintent")
	public @ResponseBody ResponseEntity<String> savefromcsvintent(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);
			f = new FileReader(basePath + "/javaIntent.csv");
			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(indicatorService, intentService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();
			}
			String line2;
			while ((line2 = br.readLine()) != null) {
				String[] rows = line2.split(",");
				System.out.println(rows[5]);
				if (rows[5].equals("IntentOf")) {
					String basePath1 = new File("").getAbsolutePath();
					System.out.println("base path : " + basePath1);
					fe = new FileReader(basePath1 + "/javaIntent.csv");
					BufferedReader bro = new BufferedReader(fe);
					Intent intent = new Intent();
					Level level = new Level(rows[1].trim());
					intent.setLevel(level);

					String linee, levelname = "0";
					while ((linee = bro.readLine()) != null) {
						String[] rowss = linee.split(",");
						if (rowss[0].equals(rows[2])) {
							levelname = rowss[1];
							System.out.println("levelname" + levelname);
							break;
						}
					}
					try {

						Heading heading = t.graph_heading(levelname);
						System.out.println("heading" + heading.getId());
						intent.setHeading(heading);
					} catch (NullPointerException e) {
						System.out.println("enter catch");
						Heading heading = new Heading();
						heading.setName(levelname);
						intent.setHeading(heading);
					}

					// System.out.println("vinayak"+indicator.getTerms().getName());

					t.saveNewIntent(intent);
				}

			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);
	}

}
