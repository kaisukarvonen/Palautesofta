package fi.haagahelia.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Tyyppi;
import fi.haagahelia.bean.Vastaus;

@Service
public interface PalauteService {
	
	public List<Vastaus> listaaVastaukset();
	
	public List<Kysymys> listaaKysymykset();
	
	public List<Kysely> listaaKyselyt();
	
	public void lisaaMontaVastausta(List<Vastaus> vastaukset);
	
	public Boolean lisaaVastaus(final Vastaus vastaus);
	
	public Boolean lisaaKysymys(final Kysymys kysymys);
	
	public List<Tyyppi> listaaKysymysTyypit();
	
	
}
