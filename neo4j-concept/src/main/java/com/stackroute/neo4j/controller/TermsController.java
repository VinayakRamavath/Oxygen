package com.stackroute.neo4j.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.service.RelatedService;
import com.stackroute.neo4j.service.SameService;
import com.stackroute.neo4j.service.SubconceptService;

/*
 Main Controller to populate concept graph

 */

@Controller
@RequestMapping("/v1.0/semantic/neo4jconceptservice")
public class TermsController {

	final SubconceptService subconceptService;

	final RelatedService relatedService;

	final SameService sameService;

	// constructor to set services by autowiring
	@Autowired
	public TermsController(SubconceptService subconceptService, RelatedService relatedService,
			SameService sameService) {
		this.subconceptService = subconceptService;
		this.relatedService = relatedService;
		this.sameService = sameService;

	}

	// fetch all the concepts of the graph
	@RequestMapping("/graphconcept/{name}")
	public Concept2 graph_concept(@PathVariable("name") String name) {
		try {
			return subconceptService.findlevelbyname(name);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// post relationship subconcept
	@CrossOrigin("*")
	@PostMapping("/postsubconcept")
	public @ResponseBody ResponseEntity<?> saveNewSubconcept(@RequestBody Subconcept subconcept) {
		try {
			System.out.println(subconcept.getName());
			return new ResponseEntity<Subconcept>(subconceptService.postnode(subconcept), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// post all subconcept relationships from csv
	@PostMapping("/postcsvsubconcept")
	public @ResponseBody ResponseEntity<String> savefromcsv(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			System.out.println("in try block");

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			// File file = new File(getClass().getResource("concepts.csv").getPath());
			f = new FileReader(basePath + "/concepts.csv");
			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(subconceptService, relatedService, sameService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();
			}
			String line2;
			while ((line2 = br.readLine()) != null) {
				String[] rows = line2.split(",");
				if (rows.length == 9) {
					if (rows[5].equals("subconcept of")) {
						System.out.println("in try block");

						String basePath1 = new File("").getAbsolutePath();
						System.out.println("base path : " + basePath1);

						// File file = new File(getClass().getResource("concepts.csv").getPath());
						fe = new FileReader(basePath1 + "/concepts.csv");

						BufferedReader bro = new BufferedReader(fe);
						Subconcept subconcept = new Subconcept();
						Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
						subconcept.setConcept1(concept1);

						String linee, levelname = "0", context = "0", description = "0";
						while ((linee = bro.readLine()) != null) {
							String[] rowss = linee.split(",");
							if (rowss[0].equals(rows[2])) {
								levelname = rowss[1];
								context = rowss[6];
								description = rowss[8];
								break;
							}
						}
						try {
							Concept2 concept2 = t.graph_concept(levelname);
							subconcept.setConcept2(concept2);
							subconcept.getConcept2().getName();
						} catch (NullPointerException e) {
							Concept2 concept2 = new Concept2(levelname, context, description);
							subconcept.setConcept2(concept2);
							subconcept.getConcept2().getName();
						}
						t.saveNewSubconcept(subconcept);
					}
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

	@PostMapping("/postsubconcept1")
	public @ResponseBody ResponseEntity<?> saveNewSubconcept1(@RequestBody Related related) {
		try {
			return new ResponseEntity<Related>(relatedService.postnode(related), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// post all subconcept relationships from csv
	@PostMapping("/postcsvsubconcept1")
	public @ResponseBody ResponseEntity<String> savefromcsv1(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			System.out.println("in try block");

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			// File file = new File(getClass().getResource("concepts.csv").getPath());
			f = new FileReader(basePath + "/concepts.csv");

			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(subconceptService, relatedService, sameService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();
			}
			String line2;
			while ((line2 = br.readLine()) != null) {
				String[] rows = line2.split(",");
				if (rows.length == 9) {
					if (rows[5].equals("related")) {
						System.out.println("in try block");

						String basePath1 = new File("").getAbsolutePath();
						System.out.println("base path : " + basePath1);

						// File file = new File(getClass().getResource("concepts.csv").getPath());
						fe = new FileReader(basePath1 + "/concepts.csv");
						BufferedReader bro = new BufferedReader(fe);
						Related related = new Related();
						Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
						related.setConcept1(concept1);

						String linee, levelname = "0", context = "0", description = "0";
						while ((linee = bro.readLine()) != null) {
							String[] rowss = linee.split(",");
							if (rowss[0].equals(rows[2])) {
								levelname = rowss[1];
								context = rowss[6];
								description = rowss[8];
								break;
							}
						}
						try {
							Concept2 concept2 = t.graph_concept(levelname);
							related.setConcept2(concept2);
							related.getConcept2().getName();
						} catch (NullPointerException e) {
							Concept2 concept2 = new Concept2(levelname, context, description);
							related.setConcept2(concept2);
							related.getConcept2().getName();
						}

						t.saveNewSubconcept1(related);
					}
				}
			}

		} catch (ArrayIndexOutOfBoundsException e1) {
			// TODO Auto-generated catch block
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch blockf = new
			// FileReader("/home/samadrita/Desktop/concepts.csv");
			e.printStackTrace();
		}
		return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);
	}

	@PostMapping("/postsubconcept2")
	public @ResponseBody ResponseEntity<?> saveNewSubconcept2(@RequestBody Same same) {
		try {
			return new ResponseEntity<Same>(sameService.postnode(same), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// post all subconcept relationships from csv
	@PostMapping("/postcsvsubconcept2")
	public @ResponseBody ResponseEntity<String> savefromcsv2(@RequestParam String csvname) {
		FileReader f, fe;
		try {
			System.out.println("in try block");

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			// File file = new File(getClass().getResource("concepts.csv").getPath());
			f = new FileReader(basePath + "/concepts.csv");

			BufferedReader br = new BufferedReader(f);
			TermsController t = new TermsController(subconceptService, relatedService, sameService);
			String header;

			header = br.readLine();
			String[] columnss = header.split(",");
			for (int i = 0; i < columnss.length; i++) {
				columnss[i] = columnss[i].trim();
			}
			String line2;
			while ((line2 = br.readLine()) != null) {
				String[] rows = line2.split(",");
				if (rows.length == 9) {
					if (rows[5].equals("same as")) {

						System.out.println("in try block");

						String basePath1 = new File("").getAbsolutePath();
						System.out.println("base path : " + basePath1);

						// File file = new File(getClass().getResource("concepts.csv").getPath());
						fe = new FileReader(basePath1 + "/concepts.csv");
						BufferedReader bro = new BufferedReader(fe);
						Same same = new Same();
						Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
						same.setConcept1(concept1);

						String linee, levelname = "0", context = "0", description = "0";
						while ((linee = bro.readLine()) != null) {
							String[] rowss = linee.split(",");
							if (rowss[0].equals(rows[2])) {
								levelname = rowss[1];
								context = rowss[6];
								description = rowss[8];
								break;
							}
						}
						try {
							Concept2 concept2 = t.graph_concept(levelname);
							same.setConcept2(concept2);
							same.getConcept2().getName();
						} catch (NullPointerException e) {
							Concept2 concept2 = new Concept2(levelname, context, description);
							same.setConcept2(concept2);
							same.getConcept2().getName();
						}

						t.saveNewSubconcept2(same);
					}
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
