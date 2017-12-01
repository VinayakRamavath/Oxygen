package com.stackroute.socket.messenger;


public class Concept2 {
	
    private Long id;
    private String name;
    
    private String context;
    private String description;
    public Concept2() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Concept2(String name, String context, String description) {
        super();
        this.name = name;
        this.context = context;
        this.description = description;
    }
    
    
}