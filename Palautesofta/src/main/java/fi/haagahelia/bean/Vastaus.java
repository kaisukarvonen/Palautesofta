package fi.haagahelia.bean;

public class Vastaus {
	private String nimi;
	private Kysymys kysymys;

	public Vastaus() {
		super();
	}

	public Vastaus(String nimi) {
			this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	
	
	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys k) {
		this.kysymys = k; 
	}

	public String toString() {
		return "vastaus: " +this.getNimi();
	}

}
