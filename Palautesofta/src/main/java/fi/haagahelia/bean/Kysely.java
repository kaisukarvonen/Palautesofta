package fi.haagahelia.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"kyselyn nimi", "kysymykset"})
public class Kysely {

	
	@JsonProperty("kyselyn nimi")
	private String nimi;
	
	@JsonIgnore
	private int id;
	private List<Kysymys> kysymykset = new ArrayList<Kysymys>();
	

	public Kysely(int id) {
		this.id = id;
	}
	
	
	public Kysely() {
	}
	
	
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	public void addToList(Kysymys k) {
		kysymykset.add(k);
	}
	
	public String toString() {
		return "kysely_nimi: "+this.getNimi()+ "\n"+this.getKysymykset();
	}
	

}
