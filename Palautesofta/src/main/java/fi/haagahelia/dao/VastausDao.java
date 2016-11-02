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
		String searchSql = "select vastaus_nimi from vastaus";
		RowMapper<Vastaus> rowmapper = new VastausRowMapper();
		List<Vastaus> vastaukset = jdbcTemplate.query(searchSql, rowmapper);
		return vastaukset;
	}

}
