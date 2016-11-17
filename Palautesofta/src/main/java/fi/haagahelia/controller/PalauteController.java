package fi.haagahelia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="vastaukset.json", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> listaaVastaukset() {

		List<Vastaus> vastaukset = null;
		return vastaukset;
	}
	
    @RequestMapping(value="lisaaVastaus", method=RequestMethod.POST)
    @ResponseBody
    public Vastaus lisaaVastaus(Vastaus vastaus) {
    	palauteDao.lisaaVastaus(vastaus); 
    	System.out.println("vastaus:" +vastaus.getNimi()); 
        return vastaus;
    }
    
    @RequestMapping(value="kysymykset.json", method=RequestMethod.GET)
    @ResponseBody
    public List<Kysymys> listaaKyselytSisalto() {
    	List<Vastaus> vastaukset = palauteDao.listaaVastaukset();
    	List<Kysymys> kysymykset = palauteDao.listaaKysymykset();
    	//List<Kysymys> uusiKysymysLista = new ArrayList<Kysymys>();
    	
    	for (Vastaus v : vastaukset) {
			for (Kysymys k : kysymykset) {
				if (v.getKysymys().getId() == k.getId()) {
					k.addToList(v); 
				}
			}
		}
    	
    	
    	return kysymykset;
    }
	

}
