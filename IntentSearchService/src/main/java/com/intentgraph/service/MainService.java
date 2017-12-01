package com.intentgraph.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intentgraph.domain.IntentOf;
import com.intentgraph.domain.Level;
import com.intentgraph.domain.Query;
import com.intentgraph.domain.SameAs;
import com.intentgraph.domain.Terms;

@Service
public class MainService implements MainInterface {
	// String[] query = {"ways","define","how","explain"};

	@Autowired
	SameAsInterface sameAsInterface;

	@Autowired
	IntentInterface intentInterface;

	public Level graph_level(String name) {
		return sameAsInterface.findlevelbyname(name);

	}

	public Level graph_level1(String name) {
		return intentInterface.findlevelbyname(name);

	}

	public ResponseEntity<String> saveNewIndicator(SameAs sameAs) {

		return new ResponseEntity<String>(sameAsInterface.postnode1(sameAs), HttpStatus.OK);

	}

	public ResponseEntity<String> saveNewIntent(IntentOf intentOf) {

		return new ResponseEntity<String>(intentInterface.postnode(intentOf), HttpStatus.OK);

	}

	public Query graph_heading(String name) {
		return intentInterface.findquerybyname(name);

	}

	public void graph_concept(String[] query) {

		// for (String word:query)
		// System.out.println(word);
		try {
			for (String word : query) {

				System.out.println(word);

				Level level = sameAsInterface.findlevelbyname(word);

				System.out.println(level + "   found in level");
				// System.out.println("found in level");

				if (isNull(level)) {

					Terms terms = sameAsInterface.findtermsbyname(word);

					System.out.println(terms.getName() + " found in terms");

				} else
					continue;

			}

		} catch (Exception e) {
			e.getMessage();

		}
	}

	public void graph_parent(String query) {
	}

	private boolean isNull(Object obj) {
		return obj == null;
	}

	public void saveNewSubconcept() {
		FileReader file;
		try {

			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			file = new FileReader(basePath + "/intentcsv.csv");

			BufferedReader br = new BufferedReader(file);
			// IntentController ic=new IntentController(sameAsService,intentService);
			System.out.println("hi");
			String header;

			header = br.readLine();
			String[] columns = header.split(",");
			for (int i = 0; i < columns.length; i++) {
				columns[i] = columns[i].trim();
			}

			String line2;
			int count = 0;
			while ((line2 = br.readLine()) != null) {
				String[] rows = line2.split(",");
				for (int i = 0; i < rows.length; i++) {
					System.out.print(i);
					System.out.println("   " + rows[i]);
				}
				if (rows[4].equals("sameas")) {
					SameAs sameas = new SameAs();
					System.out.println(rows[1]);
					Terms terms = new Terms(rows[1]);

					System.out.println(rows[1]);
					sameas.setName(rows[1]);
					sameas.setTerms(terms);
					String levelname = rows[3];
					try {
						Level level1 = graph_level(levelname);
						System.out.println("level " + level1.getId());
						sameas.setLevel(level1);
					} catch (NullPointerException e) {

						Level level = new Level(levelname);
						sameas.setLevel(level);
					}

					saveNewIndicator(sameas);
				}
			}

		}

		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveNewSubconcept1() {
		FileReader f, fe;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println("base path : " + basePath);

			f = new FileReader(basePath + "/searchIntent.csv");
			BufferedReader br = new BufferedReader(f);
			// IntentController ic=new IntentController(sameAsService,intentService);
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
					fe = new FileReader("searchIntent.csv");
					BufferedReader bro = new BufferedReader(fe);
					IntentOf intent = new IntentOf();
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

						Query query = graph_heading(levelname);
						// Query query = intentService.findlevelbyname(name);
						System.out.println("heading" + query.getId());
						intent.setQuery(query);
					} catch (NullPointerException e) {
						System.out.println("enter catch");
						Query query = new Query();
						query.setName(levelname);
						intent.setQuery(query);
					}

					saveNewIntent(intent);
				}

			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
