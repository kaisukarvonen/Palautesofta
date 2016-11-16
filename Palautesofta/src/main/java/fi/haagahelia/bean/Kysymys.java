package fi.haagahelia.bean;

import java.util.ArrayList;
import java.util.List;

public class Kysymys {
	private String nimi;
	private List<Vastaus> vastaukset = new ArrayList<Vastaus>();
	

	public Kysymys() {
	super();
	}
	
	
	public Kysymys(String nimi, List<Vastaus> vastausLista) {
		this.nimi = nimi;
		this.vastaukset = vastausLista;
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}


	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	
}
