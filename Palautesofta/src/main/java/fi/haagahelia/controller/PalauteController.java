package fi.haagahelia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Vastaus;
import fi.haagahelia.dao.PalauteDao;

@Controller
@RequestMapping(value="*")
public class PalauteController {
	
	@Inject
	private PalauteDao palauteDao;

	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "mainpage";
	}
	
	
	

	
    @RequestMapping(value="lisaaVastaus", method=RequestMethod.POST)
    @ResponseBody
    public Vastaus lisaaVastaus(Vastaus vastaus) {
    	palauteDao.lisaaVastaus(vastaus); 
    	System.out.println("vastaus:" +vastaus.getNimi()); 
    	
        return vastaus;
    }
    
    @RequestMapping(value="kyselytsisalto.json", method=RequestMethod.GET)
    @ResponseBody
    public String listaaSisaltoJson() throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	String prettyList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaaKyselytSisalto());
    	
    	return prettyList; 
    }
    
    @RequestMapping(value="vastaukset.json", method=RequestMethod.GET)
    @ResponseBody
    public List<Kysymys> vastausSisalto() throws JsonProcessingException {
    	
    	
    	return palauteDao.listaaKysymykset(); 
    }
    
    
    public List<Kysely> listaaKyselytSisalto() {
    	
    	List<Vastaus> vastaukset = palauteDao.listaaVastaukset();
    	List<Kysymys> kysymykset = palauteDao.listaaKysymykset();
    	
    	for (Vastaus v : vastaukset) {
			for (Kysymys k : kysymykset) {
				if (v.getKysymys().getId() == k.getId()) {
					k.addToList(v); 
				}
			}
		}
    	List<Kysely> kyselyt = palauteDao.listaaKyselyt();
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
