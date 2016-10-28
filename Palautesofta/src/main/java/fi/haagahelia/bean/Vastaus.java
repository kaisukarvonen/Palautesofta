package fi.haagahelia.bean;

public class Vastaus {
	private String nimi;

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

}
