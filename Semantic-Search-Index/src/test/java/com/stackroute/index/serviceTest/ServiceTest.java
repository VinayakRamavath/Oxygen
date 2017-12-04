package com.stackroute.index.serviceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.stackroute.index.exception.NANException;
import com.stackroute.index.exception.TermNotFoundException;
import com.stackroute.index.model.Indicator;
import com.stackroute.index.model.Level;
import com.stackroute.index.model.ListIndicator;
import com.stackroute.index.model.Terms;
import com.stackroute.index.service.ScoreService;

public class ServiceTest {

	ScoreService indexService = new ScoreService();

	// @Autowired
	ListIndicator listindicator;

	@Test
	public void testNotNull() {
		try {
			Level level = new Level((long) 1, "basics");

			Terms terms = new Terms((long) 121, "beginner");

			Indicator indicator = new Indicator((long) 12, (float) 12.32, terms, level);

			Collection<Indicator> intentterms = new LinkedList<>();

			intentterms.add(indicator);

			assertNotNull(indexService.findWeight("beginner", intentterms));
		} catch (TermNotFoundException e) {
			e.printStackTrace();
		}
	}

	//
	@Test
	public void testToCheckCS() {

		// String json
		// ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
		// Map<String, Integer> map = new Gson().fromJson(json, new
		// TypeToken<Map<String, Integer>>(){}.getType());
		List<Double> list = new ArrayList<Double>();
		try {
			Level level = new Level((long) 1, "basics");

			Terms terms = new Terms((long) 121, "beginner");

			Indicator indicator = new Indicator((long) 12, (float) 12.32, terms, level);

			Collection<Indicator> intentterms = new LinkedList<>();

			intentterms.add(indicator);
			list = indexService.findWeight("beginner", intentterms);
		} catch (TermNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Double> expectedList = new ArrayList<Double>();
		expectedList.add(12.32);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);

		assertEquals(expectedList, list);
	}

	//
	@Test
	public void testToCheckCSNegative() {

		// String json
		// ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
		// Map<String, Integer> map = new Gson().fromJson(json, new
		// TypeToken<Map<String, Integer>>(){}.getType());
		List<Double> list = new ArrayList<Double>();
		try {
			Level level = new Level((long) 1, "basics");

			Terms terms = new Terms((long) 121, "beginner");

			Indicator temp = new Indicator((long) 12, (float) 12.32, terms, level);

			Collection<Indicator> intentterms = new LinkedList<>();

			intentterms.add(temp);

			list = indexService.findWeight("beginner", intentterms);

		} catch (TermNotFoundException e) {
			e.printStackTrace();
		}
		List<Double> expectedList = new ArrayList<Double>();
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);

		System.out.println("expected list : " + expectedList);

		assertNotEquals(expectedList, list);
	}

	@Test
	public void testToCheckTermScore() {
		
		Collection<Indicator> intentterms = new LinkedList<>();

		Level level = new Level((long) 1, "basics");

		Terms terms = new Terms((long) 121, "beginner");

		Indicator temp = new Indicator((long) 12, (float) 12.43, terms, level);

		intentterms.add(temp);
		
		level = new Level((long) 2, "example");
		
		terms = new Terms((long) 122, "code");
		
		temp = new Indicator((long) 22, (float) 10.45, terms, level);
		
		intentterms.add(temp);
		
		Map<String,Integer> map = new HashMap<>();
		
		map.put("beginner", 32);
		map.put("code", 84);
		
		try {
			List<Double> list = indexService.searchTerm(map, intentterms);
			
			List<Double> expectedList = new LinkedList<>();
			expectedList.add(3118.32);
			expectedList.add(0.0);
			expectedList.add(6881.68);
			expectedList.add(0.0);
			expectedList.add(0.0);
			expectedList.add(0.0);
			
			assertEquals(expectedList,list);
			
		} catch (NANException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
