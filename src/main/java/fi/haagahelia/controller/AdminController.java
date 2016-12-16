package fi.haagahelia.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Inject
	private PalauteService palauteservice;

	@RequestMapping(value="/adminpage", method = RequestMethod.GET)
	public String adminMain(Model model) {
		return "admin/adminpage";
	}
	
    @RequestMapping(value="lisaaKysymys", method=RequestMethod.POST)
    @ResponseBody
    public Kysymys lisaaKysymys(@RequestBody Kysymys kysymys) {
    	palauteservice.lisaaKysymys(kysymys); 
    	System.out.println("kysymys_arvo:" +kysymys.getNimi() + ", tyyppi_id:"+kysymys.getTyyppiId()); 
    	
        return kysymys; 
    }
    
}
