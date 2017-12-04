//package com.stackroute.index.serviceTest;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.junit.Test;
//import com.stackroute.index.exception.TermNotFoundException;
//import com.stackroute.index.model.Indicator;
//import com.stackroute.index.model.Level;
//import com.stackroute.index.model.ListIndicator;
//import com.stackroute.index.model.Terms;
//import com.stackroute.index.service.ScoreService;
//
//public class ServiceTest {
//
//	ScoreService indexService = new ScoreService();
//	
////	@Autowired
//	ListIndicator listindicator;
//
//	@Test
//	public void testNotNull() {
//		try {
//			Level level = new Level((long) 1, "basics");
//
//			Terms terms = new Terms((long) 121, "beginner");
//
//			Indicator indicator = new Indicator((long) 12, (float)12.32, terms, level);
//
//			
//			
//			assertNotNull(indexService.findWeight("beginner", intentterms));
//		} catch (TermNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testToCheckCS() {
//
//		// String json
//		// ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
//		// Map<String, Integer> map = new Gson().fromJson(json, new
//		// TypeToken<Map<String, Integer>>(){}.getType());
//		List<Double> list = new ArrayList<Double>();
//		try {
//			Level level = new Level((long) 1, "basics");
//
//			Terms terms = new Terms((long) 121, "beginner");
//
//			Indicator indicator = new Indicator((long) 12, (float) 12.32, terms, level);
//
//			intentterms.add(indicator);
//			list = indexService.findWeight("beginner", intentterms);
//		} catch (TermNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Double> expectedList = new ArrayList<Double>();
//		expectedList.add(0.9);
//		expectedList.add(0.7);
//		expectedList.add(0.0);
//		expectedList.add(0.0);
//		expectedList.add(0.0);
//		expectedList.add(0.0);
//
//		assertEquals(expectedList, list);
//	}
//
//	@Test
//	public void testToCheckCSNegative() {
//
//		// String json
//		// ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
//		// Map<String, Integer> map = new Gson().fromJson(json, new
//		// TypeToken<Map<String, Integer>>(){}.getType());
//		List<Double> list = new ArrayList<Double>();
//		try {
//			Level level = new Level((long) 1, "basics");
//
//			Terms terms = new Terms((long) 121, "beginner");
//
//			Indicator temp = new Indicator((long) 12, (float) 12.32, terms, level);
//
//			// Indicator temp = intentterms.iterator().next();
//			System.out.println("indicator temp : " + temp);
//			System.out.println("indicator fields : \nweight : " + temp.getWeight());
//			System.out.println("indicator id : "+temp.getId());
//			//System.out.println("level name : " + temp.getLevel().getName());
//			//System.out.println("level id : " + temp.getLevel().getId());
//			System.out.println("term name : " + temp.getTerms().getName());
//			System.out.println("term id : " + temp.getTerms().getId());
//
//			try {
//				intentterms.add(temp);
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//			}
//
//			list = indexService.findWeight("beginner", intentterms);
//
//		} catch (TermNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<Double> expectedList = new ArrayList<Double>();
//		expectedList.add(0.0);
//		expectedList.add(0.6);
//		expectedList.add(0.0);
//
//		assertNotEquals(expectedList, list);
//	}
//
//}
