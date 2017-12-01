package com.stackroute.neo4j.domain;

//{"id":1,"basicsscore":1,"tutorialscore":1,"examplescore":1,"completereferencesscore":1,"troubleshootingsscore":1,"gettingstartedscore":1,"urlname":"hi","title":"title","Snippet":"sn"}

public class IndexerDomain {

	private int id;
	
	private int basicsscore;
	
	private int tutorialscore;
	
	private int examplescore;
	
	private int completereferencesscore;

	private int troubleshootingsscore;
	
	private int gettingstartedscore;

	private String urlname;
	private String title;
	private String snippet;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBasicsscore() {
		return basicsscore;
	}

	public void setBasicsscore(int basicsscore) {
		this.basicsscore = basicsscore;
	}

	public int getTutorialscore() {
		return tutorialscore;
	}

	public void setTutorialscore(int tutorialscore) {
		this.tutorialscore = tutorialscore;
	}

	public int getExamplescore() {
		return examplescore;
	}

	public void setExamplescore(int examplescore) {
		this.examplescore = examplescore;
	}

	public int getCompletereferencesscore() {
		return completereferencesscore;
	}

	public void setCompletereferencesscore(int completereferencesscore) {
		this.completereferencesscore = completereferencesscore;
	}

	public int getTroubleshootingsscore() {
		return troubleshootingsscore;
	}

	public void setTroubleshootingsscore(int troubleshootingsscore) {
		this.troubleshootingsscore = troubleshootingsscore;
	}

	public int getGettingstartedscore(){
		return gettingstartedscore;
	}

	public void setGettingstartedscore(int gettingstartedscore) {
		this.gettingstartedscore = gettingstartedscore;
	}

	public String getUrlname() {
		return urlname;
	}

	public void setUrlname(String urlname) {
		this.urlname = urlname;
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

	public IndexerDomain(int id, int basicsscore, int tutorialscore, int examplescore, int completereferencesscore,
			int troubleshootingsscore, int gettingstartedscore, String urlname, String title, String snippet) {
		super();
		this.id = id;
		this.basicsscore = basicsscore;
		this.tutorialscore = tutorialscore;
		this.examplescore = examplescore;
		this.completereferencesscore = completereferencesscore;
		this.troubleshootingsscore = troubleshootingsscore;
		this.gettingstartedscore = gettingstartedscore;
		this.urlname = urlname;
		this.title = title;
		this.snippet = snippet;
	}

	

	
	
	
}
