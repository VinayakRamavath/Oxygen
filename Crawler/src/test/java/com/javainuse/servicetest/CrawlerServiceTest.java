package com.javainuse.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Spy;

import com.javainuse.service.CrawlerServices;

public class CrawlerServiceTest {

	@Spy
	private CrawlerServices crawlerServices;

	//test to check that the correct xml file is being retrieved
	@Test(expected = NullPointerException.class)
	public void shouldVerifyThatDocumentIsRetrieved() throws MalformedURLException, IOException {

		String url = "https://sourceforge.net/";
		// Act
		Document result = crawlerServices.PageContent(url);

		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldVerifyCorrectDocument() throws MalformedURLException, IOException {
		
		String url = "https://sourceforge.net/";
		Document result=crawlerServices.PageContent(url);
		Document actual = Jsoup.connect(url).get();
		assertEquals(result, actual);
	}

}
