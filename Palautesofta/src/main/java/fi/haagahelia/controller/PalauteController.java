package fi.haagahelia.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
@RequestMapping(value="*")
public class PalauteController {
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String main() {
		return "mainpage";
	}

}
