package fi.haagahelia.dao;

import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.haagahelia.bean.Vastaus;

@Repository
public class VastausDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public List<Vastaus> listaaVastaukset() {
		String searchSql = "SELECT vastaus_nimi, ky.kysymys_nimi FROM vastaus JOIN kysymys ky "
				+ "ON vastaus.kysymys_id = ky.kysymys_id";
		RowMapper<Vastaus> rowmapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(searchSql, rowmapper);
		
		for (Vastaus vastaus : vastaukset) {
			//kysymysten mukaan listataan vastauksen (kysymys(nimi, vastausLista))
		}
		
		return vastaukset;
	}
	
	public List<Kysymys> listaaKysymykset() {
		String searchSql = "SELECT "
	}
	
	public void lisaaVastaus(Vastaus vastaus) {
		String addSql = "INSERT INTO vastaus (vastaus_nimi,kysymys_id) VALUES (?,?)";
		Object[] params = new Object[] {vastaus.getNimi(), 2};
		try {
		jdbcTemplate.update(addSql, params);
		} catch (Exception e) {
			System.out.println("tietokantaan lis‰‰minen ep‰onnistui");
		}
	}

}
