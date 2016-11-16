package fi.haagahelia.bean;

import java.util.ArrayList;
import java.util.List;

public class Kysymys {
	private String nimi;
	private int id;
	private List<Vastaus> vastaukset = new ArrayList<Vastaus>();
	private Kysely kysely;
	

	public Kysymys() {
	super();
	}
	
	public Kysymys(int id) {
		this.id = id;
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
		return "kysely: "+this.getKysely().getId()+", kysymys: "+ this.getNimi()+ "\nvastaukset: "+this.getVastaukset();
	}
	
	
}
