package com.diksha.spellcheck.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.diksha.spellcheck.config.Sender;
import com.diksha.spellcheck.domain.SpellCheckResult;
import com.diksha.spellcheck.domain.SpellCheckSuggestion;
import com.diksha.spellcheck.domain.SpellCheckSuggestions;

import ch.qos.logback.core.net.SyslogOutputStream;
import dk.dren.hunspell.Hunspell;
import redis.clients.jedis.Jedis;

@Service
public class SpellCheckService implements SpellCheckInterface {
	private final static Logger LOGGER = LoggerFactory.getLogger(SpellCheckService.class);

    private String dictionaries;

    private String rootDictDirectory;

    private List<Hunspell.Dictionary> loadedDictionaries;
    
//    @Autowired
//    SpellCheckSuggestions suggestions;
    
    SpellCheckResult spellCheckResult=new SpellCheckResult();

    @Autowired
    public SpellCheckService(@Value("${spellcheck.dictionaries}") String dictionaries,
                             @Value("${spellcheck.rootdir}") String rootDictDirectory) {

    	String basePath = new File("").getAbsolutePath();
		System.out.println("base path : " + basePath);

		System.out.println("dict directory : " + rootDictDirectory);

		this.dictionaries = dictionaries;
		this.rootDictDirectory = basePath+"/";

        loadedDictionaries = new ArrayList<Hunspell.Dictionary>();
        loadDictionaries();
        jedis();
       
    }

   public void loadDictionaries() {
        List<String> dictList = getDictionariesAsList();
        loadedDictionaries.clear();

        for (String dict : dictList) {
            try {
            	Directory directory = null;
				
                loadedDictionaries.add(Hunspell.getInstance().getDictionary(getDictionaryPath(dict)));
                //String search = "java clss";
                final int suggestionNumber = 4;
                
      LOGGER.info("Loaded dictionary successfully: " + dict);
            } catch(Exception e) {
            	LOGGER.error("Error instantiating dictionary: " + dict+ e);
               
            }
        }
    }

   @Autowired
   Sender sender;
    public SpellCheckSuggestions getSpellcheckSuggestions(String[] wordsToCheck) {
    	
    	String query="";
    	for (String word:wordsToCheck)
    		query+=word+" ";
    	
    	String spellcheck = "";
    	
    	String[] result=new String[wordsToCheck.length];
   	SpellCheckSuggestions suggestions = new SpellCheckSuggestions();

   	int i=0;
        for (String s : wordsToCheck) {
        	System.out.println(i);
            boolean misspelled = true;
            List<String> allSuggestionsForThisWord = new ArrayList<String>();

            for (Hunspell.Dictionary dict : loadedDictionaries) {
                if(misspelled && !dict.misspelled(s)) {
                    misspelled = false;
                    result[i]=wordsToCheck[i];
                }
                if(misspelled) {
                   allSuggestionsForThisWord.addAll(dict.suggest(s));
                 
                   
                  s=allSuggestionsForThisWord.get(0);
                   System.out.println(s);
                   result[i]=s;
                	
                }
                i++;
            }
            
            
            SpellCheckSuggestion suggestion = new SpellCheckSuggestion();
            suggestion.setWord(s);
            suggestion.setMisspelled(misspelled);
            suggestion.setSuggestions(allSuggestionsForThisWord);
            suggestions.add(suggestion);
           
           
       

           
        }
       // spellcheck=result.toString();
        
        for (String res:result)
        	spellcheck+=res+" ";
        System.out.println("SPELLCHECK");
        System.out.println(spellcheck);
        
        
        spellCheckResult.setSpellcheckresult(spellcheck);
        System.out.println(spellCheckResult.getSpellcheckresult().toString());
        		
        spellCheckResult.setQuery(query);
        System.out.println("INSIDE SERVICE QUERY: "+query);
        sender.send(spellCheckResult);
        
      
      //  System.out.println("return");
		return suggestions;
        
//        for (String s1 : result)
//        	System.out.println(s1);

//        return spellcheck;
    }

    public List<String> getDictionariesAsList() {
        List<String> dictList = new ArrayList<String>();
        String[] dictArray = dictionaries.split(",");
        for (String s : dictArray) {
            dictList.add(s.trim());
        }
        return dictList;
    }

    public List<Hunspell.Dictionary> getLoadedDictionaries() {
        return loadedDictionaries;
    }

    private String getDictionaryPath(String dict) {
        return rootDictDirectory + dict;
    }
   public void jedis() { 
    	   
    	      //Connecting to Redis server on localhost 
//    	      Jedis jedis = new Jedis("localhost"); 
//    	     
//    	      System.out.println("Connection to server sucessfully"); 
//    	      //check whether server is running or not 
//    	      System.out.println("Server is running: "+jedis.ping()); 
//    	   
////    	      jedis.set("tutorialname", "Redis tutorial"); 
////    	      System.out.println("Stored string in redis:: "+ jedis.get("tutorialname"));
//    	      
//    	      jedis.lpush("tutorial-list", "class"); 
//    	      jedis.lpush("tutorial-list", "interface"); 
//    	      jedis.lpush("tutorial-list", "encapsulation"); 
//    	      jedis.lpush("tutorial-list", "abstraction"); 
//    	      jedis.lpush("tutorial-list", "polymorphism"); 
//    	      // Get the stored data and print it 
//    	      List<String> list = jedis.lrange("tutorial-list", 0, 4 ); 
//    	      
//    	      for(int i = 0; i<list.size(); i++) { 
//    	         System.out.println("Stored string in redis:: "+list.get(i)); 
//    	      } 
    	   } 
}
