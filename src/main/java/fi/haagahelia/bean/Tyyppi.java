package fi.haagahelia.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tyyppi {
	
	@JsonProperty("tyyppi_id")
	private int id;
	
	@JsonProperty("tyyppi_nimi")
	private String nimi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	

}
