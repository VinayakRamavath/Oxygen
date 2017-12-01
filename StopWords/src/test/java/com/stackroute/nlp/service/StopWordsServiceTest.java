//package com.stackroute.nlp.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class StopWordsServiceTest {
//
//	@Autowired
//	StopWordsService stopWordsService;
//
//	@Test(expected = NullPointerException.class)
//	public void testNotNull() {
//		String[] words = new String[] { "interface" };
//		String[] pos = new String[] { "NN" };
//		String result = stopWordsService.removeStopwords(words, pos);
//		assertNotNull(result);
//
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void test() {
//		String[] words = new String[] { "interface" };
//		String[] pos = new String[] { "NN" };
//		String result = stopWordsService.removeStopwords(words, pos);
//
//		String actual = "done";
//		assertEquals(result, actual);
//
//	}
//
//	@Test(expected = NullPointerException.class)
//	public void testNegative() {
//		String[] words = new String[] { "interface" };
//		String[] pos = new String[] { "NN" };
//		String result = stopWordsService.removeStopwords(words, pos);
//
//		String actual = "done ";
//		assertNotEquals(result, actual);
//
//	}
//
//}
