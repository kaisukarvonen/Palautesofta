package fi.haagahelia.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"arvo", "vastaukset"})
public class Kysymys {
	@JsonProperty("arvo")
	private String nimi;
	
	@JsonIgnore
	private int id;
	
	private List<Vastaus> vastaukset = new ArrayList<Vastaus>();
	
	@JsonIgnore
	private Kysely kysely;
	

	public Kysymys() {
	super();
	}
	
	public Kysymys(int id) {
		this.id = id;
	}
	
	public Kysymys(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}


	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public void addToList(Vastaus v) {
		vastaukset.add(v);
	}


	public String getNimi() {
		return nimi;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public Kysely getKysely() {
		return kysely;
	}


	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}


	public String toString() {
		return "kysymys: "+ this.getNimi();
	}
	
	
}
