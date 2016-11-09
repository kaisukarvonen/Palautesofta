package fi.haagahelia.bean;

public class Vastaus {
	private String nimi;
	private String kysymys;

	public Vastaus() {
		super();
	}
	
	public Vastaus(String nimi) {
		this.nimi = nimi;
	}
	

	public Vastaus(String nimi, String kysymys) {
			this.nimi = nimi;
			this.kysymys = kysymys;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	
	public String toString() {
		return "vastaus: " +this.getNimi() + ", kysymys: "+this.getKysymys();
	}

}
