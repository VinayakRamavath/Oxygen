package com.stackroute.neo4j.service;

//{"url":"http://www.google.com/patents/US6782540","domain":"java","concept":"interface","title":"Patent US6782540 - COBOL/natural copybook to Java conversion ...","csmap":{"basicscore":13.20621873790721,"examplescore":25.973066229057086,"gsscore":1.4278445817149903,"trscore":28.629448353947808,"tsscore":9.540402447938316,"tutorialscore":21.223019649434598},"snipet":"www.google.com"}

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlFromGoogle;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.messenger.Listener;
import com.google.common.collect.Lists;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.IndexerModel;
import com.stackroute.neo4j.repository.SubconceptRepository;
import com.stackroute.neo4j.repository.UrlFromGoogleRepository;
import com.stackroute.neo4j.repository.UrlRelation1Repository;
import com.stackroute.neo4j.repository.UrlRelationRepository;
import com.stackroute.neo4j.repository.ConceptRepository;
import com.stackroute.neo4j.repository.ConceptRepository2;


@Service
public class UrlService {

	@Autowired
	ConceptRepository2 conceptRepository;
	
    @Autowired
    UrlFromGoogleRepository urlFromGoogleRepository;
    
    @Autowired
    UrlRelationRepository urlRelationRepository;

    @Autowired
    UrlRelation1Repository urlRelation1Repository;
    
    @Autowired
    Listener listener;

   List<UrlRelation> listt=new ArrayList<UrlRelation>();
//    
//    public List<UrlRelation> getListt() {
//		return listt;
//	}
//
//	public void setListt(List<UrlRelation> listt) {
//		this.listt = listt;
//	}
	
    @Transactional(readOnly = true)
    public  Iterable<UrlRelation>  graph_url() {
         Iterable<UrlRelation> result = urlRelationRepository.findAll();
        return result;
    }
    
    @Transactional(readOnly = true)
    public UrlRelation  parsenode(IndexerModel subconcept) {
    	System.out.println("aa");
    	System.out.println(subconcept.getCsmap());
    	System.out.println(subconcept.getCsmap().get("basicscore"));
    	System.out.println(subconcept.getCsmap().get("tutorialscore"));
    	System.out.println(subconcept.getCsmap().get("examplescore"));
    	System.out.println(subconcept.getCsmap().get("trscore"));
    	System.out.println(subconcept.getCsmap().get("tsscore"));
    	System.out.println(subconcept.getCsmap().get("gsscore"));
    	System.out.println(subconcept.getTitle());
    	System.out.println(subconcept.getSnipet());
    	
        UrlFromGoogle urlFromGoogle=new UrlFromGoogle(subconcept.getUrl(),subconcept.getTitle(),subconcept.getSnipet());
        Concept2 concept2=new Concept2(subconcept.getConcept(),"context","description");
        UrlRelation result =new UrlRelation(subconcept.getCsmap().get("basicscore"),
                subconcept.getCsmap().get("tutorialscore"),
                subconcept.getCsmap().get("examplescore"),
                subconcept.getCsmap().get("trscore"),
                subconcept.getCsmap().get("tsscore"),
                subconcept.getCsmap().get("gsscore"),
                urlFromGoogle,concept2,subconcept.getConcept());
        System.out.println(result.getBasicsscore());
        return result;
    }

    
    @Transactional(readOnly = true)
    public UrlRelation  postnode(UrlRelation subconcept) {

        UrlRelation result = urlRelationRepository.save(subconcept);
        return subconcept;
    }
    
    
    
    @Transactional(readOnly = true)
    public UrlFromGoogle  findlevelbyname(String name) {
        UrlFromGoogle result = urlFromGoogleRepository.findByName(name);
        return result;
    }

    @Transactional(readOnly = true)
	public Concept2  findconcept2byname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		return result;
	}
    
    
    public List<UrlRelation> getresults(String concept,String intent){
    	System.out.println("CONCEPT");
    	System.out.println(concept);
    	System.out.println("INTENT");
		System.out.println(intent);
		Iterable<UrlRelation> urlRelation = this.graph_url();
		List<UrlRelation> myList = Lists.newArrayList(urlRelation);
		List<UrlRelation> myList1 = new ArrayList<UrlRelation>();
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i).getConcept2().getName());
			if (myList.get(i).getConcept2().getName().equalsIgnoreCase(concept.trim())) {
				System.out.println("INSIDE IF");
				myList1.add(myList.get(i));
			}
		}
		if (intent.equals("Basic")) {
			Collections.sort(myList1, UrlRelation.BasicScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Tutorial")) {
			Collections.sort(myList1, UrlRelation.TutorialScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Getting Started")) {
			Collections.sort(myList1, UrlRelation.GettingStartedScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Example")) {
			Collections.sort(myList1, UrlRelation.ExamplesScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("TroubleShoot")) {
			Collections.sort(myList1, UrlRelation.TroubleShootingScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Complete Reference")) {
			Collections.sort(myList1, UrlRelation.CompleteReferenceComparator);
			Collections.reverse(myList1);
		}
		
//		System.out.println(myList);
		for(int i=0;i<myList.size();i++){
		    System.out.println(myList.get(i).getBasicsscore());
		} 
		listener.setFake(true);
//		setListt(myList1);
		
		this.listt= myList1;
		System.out.println("GETT");
		System.out.println(this.listt);
		return myList1;
    }

    public List<UrlRelation> get() throws InterruptedException{
    	List<UrlRelation> last=new ArrayList<UrlRelation>();
    	System.out.println("INSIDE FUNCTION");
//    	Thread.sleep(5000);
    	System.out.println(listener.isFake());
    	
    	while(!listener.isFake()) {
//    		System.out.println("GET");
//    		System.out.println(this.listt);
    		Thread.sleep(500);
    		get();
    	}

		last= this.listt;

		System.out.println("LAST");
		System.out.println(last);
		System.out.println(1);
		System.out.println("NULL REACHED");
		return last;
    }

    public List<UrlRelation> getresultsconcepts(String concept,String intent){
    	System.out.println("CONCEPT");
    	System.out.println(concept);
    	System.out.println("INTENT");
		System.out.println(intent);
		Iterable<UrlRelation> urlRelation = this.graph_url();
		List<UrlRelation> myList = Lists.newArrayList(urlRelation);
//		List<UrlRelation> myList1 = new ArrayList<UrlRelation>();
//		for (int i = 0; i < myList.size(); i++) {
//			System.out.println(myList.get(i).getConcept2().getName());
//			if (myList.get(i).getConcept2().getName().equalsIgnoreCase(concept.trim())) {
//				System.out.println("INSIDE IF");
//				myList1.add(myList.get(i));
//			}
//		}
		List<UrlRelation> myList1=urlRelation1Repository.findByName(concept.trim());
		if (intent.equals("Basic")) {
			Collections.sort(myList1, UrlRelation.BasicScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Tutorial")) {
			Collections.sort(myList1, UrlRelation.TutorialScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Getting Started")) {
			Collections.sort(myList1, UrlRelation.GettingStartedScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Example")) {
			Collections.sort(myList1, UrlRelation.ExamplesScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("TroubleShoot")) {
			Collections.sort(myList1, UrlRelation.TroubleShootingScoreComparator);
			Collections.reverse(myList1);
		}
		if (intent.equals("Complete Reference")) {
			Collections.sort(myList1, UrlRelation.CompleteReferenceComparator);
			Collections.reverse(myList1);
		}
		
//		System.out.println(myList);
		for(int i=0;i<myList.size();i++){
		    System.out.println(myList.get(i).getBasicsscore());
		} 
		listener.setFake(true);
//		setListt(myList1);
		
		this.listt= myList1;
		System.out.println("GETT");
		System.out.println(this.listt);
		return myList1;
    }
    
    
}
