package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int line) throws SQLException {
		Vastaus v = new Vastaus();
		v.setNimi(rs.getString("vastaus_nimi"));
		v.setKysymys(rs.getString("kysymys_nimi"));
		return v;
	}

}
