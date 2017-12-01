package com.stackroute.domainexpert.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONObject;																																																																																																																								
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.domainexpert.messenger.Sender;
import com.stackroute.domainexpert.model.DomainExpertModel;
@RequestMapping("/domainexpert")
@RestController
public class DomainExpertController {
    
    @Autowired
    Sender sender;
    
    ArrayList<String> javasuggestionarray = new ArrayList<String>();
    ArrayList<String> financesuggestionarray = new ArrayList<String>();
    
    @CrossOrigin("*")
    @RequestMapping("/java")
    public ResponseEntity<?> getjava(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("java.Json"));
            return new ResponseEntity<Object>(obj, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.OK);
        }
    }
    
    @CrossOrigin("*")
    @RequestMapping("/finance")
    public ResponseEntity<?> getfinance(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("finance.Json"));
            return new ResponseEntity<Object>(obj, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin("*")
    @RequestMapping("/clear")
    public ResponseEntity<?> getclear(){
        File f=new File("java.Json");
        File f1=new File("finance.Json");
        if(f.delete()&&f1.delete())
        {
            try {
                f.createNewFile();
                f1.createNewFile();
                return new ResponseEntity<String>("new file created", HttpStatus.OK);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                return new ResponseEntity<String>("err", HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<String>("unable to delete file", HttpStatus.OK);
        }
    }
    
    @CrossOrigin("*")
    @PostMapping("/{domain}/{concepts}")
    public ResponseEntity<?> add(@PathVariable String concepts ,@PathVariable String domain) throws InterruptedException, IOException {
        
        String[] conceptarray= concepts.split(",");
        int conceptlen = conceptarray.length;
        
        for(int i=0; i<conceptlen;i++) {
            DomainExpertModel domainmodel= new DomainExpertModel();
            domainmodel.setDomain(domain);
            domainmodel.setConcept(conceptarray[i]);
            System.out.println(domainmodel.getDomain());
            System.out.println(domainmodel.getConcept());
          sender.send(domainmodel);
          Thread.sleep(3000);
            }
        
        if(domain.equalsIgnoreCase("java")) {
            FileWriter java = new FileWriter("java.Json");
            
            List<String> newList = Arrays.asList(conceptarray);
            System.out.println("inside java loop");
            javasuggestionarray.addAll(newList);
            int len= javasuggestionarray.size();
            java.write("[");
            System.out.println(len);
            
            for(int i=0; i<len;i++) {
                 JSONObject obj = new JSONObject();              
                obj.put("name",javasuggestionarray.get(i));
                System.out.println(javasuggestionarray.get(i));
                java.write(obj.toJSONString());
                        if((i==len-1) || (len==1) ) {
                            System.out.println("1=len-1");
                            break;
                                 
                        }
                        else {
                            System.out.println("else");
                            java.write(",");  
                        }
                    } 
            java.write("]");
            java.flush();
            return new ResponseEntity<String>("Undergoing java Concept Population...            (E.T : 15 mins)", HttpStatus.OK);
            
        }
        
        else if(domain.equalsIgnoreCase("finance")) {
            FileWriter finance = new FileWriter("finance.Json");
                List<String> newList1 = Arrays.asList(conceptarray);
            financesuggestionarray.addAll(newList1);
            int len=financesuggestionarray.size();
            finance.write("[");
            for(int i=0; i<len;i++) {
                 JSONObject obj1 = new JSONObject();
                 
                obj1.put("name",financesuggestionarray.get(i));
                finance.write(obj1.toJSONString());
  
                if((i==len-1) || (len==1)) {
                    System.out.println("1=len-1");
                    break;
                         
                }
                else {
                    System.out.println("else");
                    finance.write(",");   
                }
            } 
                     
            finance.write("]");
            finance.flush();
            return new ResponseEntity<String>("Undergoing finance Concept Population...            (E.T : 15 mins)", HttpStatus.OK);
            
        }
        
        return new ResponseEntity<String>("Undergoing Concept Population...            (E.T : 15 mins)", HttpStatus.OK);
        
    }
}
