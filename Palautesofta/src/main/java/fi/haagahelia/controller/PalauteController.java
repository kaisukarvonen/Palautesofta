package fi.haagahelia.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.bean.Vastaus;
import fi.haagahelia.dao.VastausDao;

@Controller
@RequestMapping(value="*")
public class PalauteController {
	
	@Inject
	private VastausDao vastausDao;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "mainpage";
	}
	
	@RequestMapping(value="vastaukset.json", method=RequestMethod.GET)
	public @ResponseBody List<Vastaus> listaaVastaukset() {

		List<Vastaus> vastaukset = vastausDao.listaaVastaukset();
		return vastaukset;
	}
	
    @RequestMapping(value="lisaaVastaus", method=RequestMethod.POST)
    @ResponseBody
    public Vastaus lisaaVastaus(Vastaus vastaus) {
    	vastausDao.lisaaVastaus(vastaus); 
    	System.out.println("vastaus:" +vastaus.getNimi()); 
        return vastaus;
    }
	

}
