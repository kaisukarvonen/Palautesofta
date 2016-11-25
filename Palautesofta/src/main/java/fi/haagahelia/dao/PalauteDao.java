package fi.haagahelia.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Tyyppi;
import fi.haagahelia.bean.Vastaus;

@Repository
public class PalauteDao implements PalauteService {
	
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
	
	public List<Tyyppi> listaaKysymysTyypit() {
		String searchSql = "SELECT tyyppi_id, tyyppi_nimi FROM kysymys_tyyppi";
		RowMapper<Tyyppi> mapper = new TyyppiRowMapper();
		List<Tyyppi> tyypit = jdbcTemplate.query(searchSql, mapper);
		return tyypit;
	}
	
	public List<Kysymys> listaaKysymykset() {
		String searchSql = "SELECT kysymys_id, kysymys_nimi, kysely_id, tyyppi_id FROM kysymys ORDER BY kysymys_nimi";
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
	

	public void lisaaMontaVastausta(List<Vastaus> vastaukset) {
		for (Vastaus vastaus : vastaukset) {
			lisaaVastaus(vastaus);
		}
	}
	
	public Boolean lisaaVastaus(final Vastaus vastaus) { 
		String addSql = "INSERT INTO vastaus (vastaus_nimi,kysymys_id) VALUES (?,?)";
	    return jdbcTemplate.execute(addSql, new PreparedStatementCallback<Boolean>(){   
	        public Boolean doInPreparedStatement(PreparedStatement ps)  
	                throws SQLException, DataAccessException {  
	            ps.setString(1, vastaus.getNimi());      
	            ps.setInt(2,vastaus.getKysymys().getId());    
	            return ps.execute();        
	        }
	    });
	}
}
