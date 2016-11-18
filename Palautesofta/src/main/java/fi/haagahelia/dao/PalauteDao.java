package fi.haagahelia.dao;

import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Vastaus;

@Repository
public class PalauteDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public List<Vastaus> listaaVastaukset() {
		String searchSql = "SELECT vastaus_nimi, kysymys_id FROM vastaus";
		RowMapper<Vastaus> mapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(searchSql, mapper);
		return vastaukset;
	}
	
	public List<Kysymys> listaaKysymykset() {
		String searchSql = "SELECT kysymys_id, kysymys_nimi, kysely_id FROM kysymys";
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(searchSql, mapper);
		return kysymykset;
	}
	
	
	public List<Kysely> listaaKyselyt() {
		String searchSql = "SELECT kysely_id, kysely_nimi FROM kysely";
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(searchSql, mapper);
		return kyselyt;
	}
	

	
	
	public void lisaaVastaus(Vastaus vastaus) {
		String addSql = "INSERT INTO vastaus (vastaus_nimi,kysymys_id) VALUES (?,?)";
		Object[] params = new Object[] {vastaus.getNimi(), 3}; //kysymys_id nyt siis aina 2
		try {
		jdbcTemplate.update(addSql, params);
		} catch (Exception e) {
			System.out.println("tietokantaan lis‰‰minen ep‰onnistui");
		}
	}
}
