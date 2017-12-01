package com.stackroute.github.messenger;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.github.domain.DomainConcept;
import com.stackroute.github.domain.SearchResultsModel;
import com.stackroute.github.repository.ApiRepository;
import com.stackroute.github.services.ApiService;

public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@Autowired
	Sender kafkaSender;

	@Autowired
	ApiRepository domainrepository;

	DomainConcept dc;
	
	@Autowired
	ApiService service;

	@KafkaListener(topics = "concept")
	public void listen(DomainConcept record) {

		System.out.println("domain : " + record.getDomain() + " concept : " + record.getConcept());

		service.setDomconc(record.getDomain(), record.getConcept());
		// domainrepository.save(savedc);
		// service.saveDC(record);

		try {

			JSONParser parser = new JSONParser();
			
//			URL url = getClass().getResource("apikeys.json");
//			System.out.println("before file");
//			File file = new File(url.getPath());
//			System.out.println("after file");
			
			String basePath = new File("").getAbsolutePath();
		    System.out.println("base path : "+basePath);
			
			
//			@Autowired
//		    public Listener(ResourceLoader resourceLoader) {
//		        this.resourceLoader = resourceLoader;
//		    }

			
//			URL url = getClass().getResource("");
//			System.out.println("url : "+ url);
//			String path = url.getPath()+"../../../../apikeys.json";
			
//			Resource resource = resourceLoader.getResource("classpath:apikeys.json");
//            File jsonFile = resource.getFile();
			
			
			Object object = parser.parse(new FileReader(basePath+"/apikeys.json"));
			System.out.println("can parse");

			JSONObject jsonobject = (JSONObject) object;
			List<String> list = new ArrayList<>();
			JSONArray apikeys = (JSONArray) jsonobject.get("apikeys");
			System.out.println(record.getDomain());
			System.out.println(record.getConcept());

			for (Object apik : apikeys) {
				// System.out.println(apik.toString());
				list.add(apik.toString());
			}

			int startIndex = 1;
			for (int j = 0; j < 6; j++) {
				String apikey = list.get(j);
				System.out.println(apikey);
				SearchResultsModel a = service.callAPI(apikey, startIndex);

				kafkaSender.send(a);

				System.out.println("google link : "+a.getItems().get(0).getDisplayLink());
				startIndex = startIndex + 10;

				// userRepository.save(results);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		countDownLatch1.countDown();
	}
}
