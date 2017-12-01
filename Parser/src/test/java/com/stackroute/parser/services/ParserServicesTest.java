//package com.stackroute.parser.services;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.io.IOException;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.google.common.util.concurrent.Service.Listener;
//import com.stackroute.Parser.Services.ParserServices;
//import com.stackroute.Parser.model.ParserModel;
//
////import com.javainuse.controller.ApacheKafkaWebController;
//
//public class ParserServicesTest {
//	@SuppressWarnings("unused")
//	private String createURLWithPort() {
//        return "http://localhost:8060";
//    }
//	
//	@Autowired
//	Listener listen;
//	
//	@Test
//	public void shouldGiveJson() throws IOException{
//		
//		String url = "https://sourceforge.net/";
//		String[] keywords = { "angular-cli","angular","install" };
//		String domain="asdf";
//		String concept="asdfgh";
//		//Act
//		ParserServices ps= new ParserServices();
//		 Document doc = Jsoup.connect(url).get();
//		ParserModel result= ps.score(url,doc,keywords,domain,concept);
//		//Assert
//		assertNotNull(result);
//		
//	}
//	
//	
//	
//}
