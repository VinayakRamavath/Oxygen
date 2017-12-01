package com.stackroute.neo4j.domain;



import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
public class UrlFromGoogle {

	public UrlFromGoogle() {
		super();
	}

	@GraphId
	private Long id;

	@Property(name="name")
	private String name;
	
	private String title;
	
	private String snippet;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public UrlFromGoogle(String name, String title, String snippet) {
		super();
		this.name = name;
		this.title = title;
		this.snippet = snippet;
	}

}
