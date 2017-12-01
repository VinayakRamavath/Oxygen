package com.javainuse.service;


import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.javainuse.controller.CrawlerController;

/*
 * Service to retrieve xml page
 */
@Service
@EnableAsync
public class CrawlerServices {
	Logger  logger = Logger.getLogger(CrawlerServices.class.getName());

	@Async
	public Document PageContent(String url) throws  MalformedURLException, IOException {

		Document pageContent = Jsoup.connect(url).get();
		logger.info("Page Content return");
//		String pageContent = page.toString();
		return (pageContent);
	}
}