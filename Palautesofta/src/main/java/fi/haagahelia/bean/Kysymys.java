package fi.haagahelia.bean;

public class Kysymys {
	private String nimi;

	public Kysymys() {
	super();
	}
	
	
	public Kysymys(String nimi) {
		this.nimi = nimi;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	
}
