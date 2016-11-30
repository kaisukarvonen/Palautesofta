package fi.haagahelia.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Vastaus;
import fi.haagahelia.dao.PalauteService;

@Controller
@RequestMapping(value="*")
public class PalauteController {
	
	@Inject
	private PalauteService palauteservice;

	//testi
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "mainpage";
	}
	
	@RequestMapping(value="kysymystyyppilista.json", method=RequestMethod.GET)
	@ResponseBody
	public String listaaKysymysTyypit() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
    	String prettyList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(palauteservice.listaaKysymysTyypit());
    	
    	return prettyList;
	} 
	
    @RequestMapping(value="lisaaVastaus", method=RequestMethod.POST)
    @ResponseBody
    public Vastaus lisaaVastaus(@RequestBody Vastaus vastaus) {
    	palauteservice.lisaaVastaus(vastaus); 
    	System.out.println("vastaus_arvo:" +vastaus.getNimi() + ", kysymys_id:"+vastaus.getKysymysId()); 
    	
        return vastaus;
    }
    
    @RequestMapping(value="lisaaMontaVastausta", method=RequestMethod.POST)
    @ResponseBody
    public List<Vastaus> lisaaMontaVastausta(@RequestBody List<Vastaus> lisatytVastaukset) {
    	palauteservice.lisaaMontaVastausta(lisatytVastaukset); 
    	
        return lisatytVastaukset;  
    }
    
    
    @RequestMapping(value="kyselytsisalto.json", method=RequestMethod.GET)
    @ResponseBody
    public String listaaSisaltoJson() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	String prettyList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaaKyselytSisalto());
    	
    	return prettyList;
    }
    
    @RequestMapping(value="kyselytsimple.json", method=RequestMethod.GET)
    @ResponseBody
    public List<Kysely> kysymysSisalto() throws JsonProcessingException {
    	return listaaKyselytSisalto();  
    }
    
    //testiä
    
    public List<Kysely> listaaKyselytSisalto() {
    	
    	List<Vastaus> vastaukset = palauteservice.listaaVastaukset();
    	List<Kysymys> kysymykset = palauteservice.listaaKysymykset();
    	
    	for (Vastaus v : vastaukset) {
			for (Kysymys k : kysymykset) {
				if (v.getKysymysId() == k.getId()) {
					k.addToList(v); 
				}
			}
		}
    	List<Kysely> kyselyt = palauteservice.listaaKyselyt();
    	for (Kysely kysely : kyselyt) {
			for (Kysymys k : kysymykset) {
				if (kysely.getId() == k.getKysely().getId()) {
					kysely.addToList(k); 
				}
			}
		}
    	return kyselyt;
    }

}
