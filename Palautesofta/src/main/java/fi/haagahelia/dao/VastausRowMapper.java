package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Kysymys;
import fi.haagahelia.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int row) throws SQLException {
		Vastaus v = new Vastaus();
		v.setNimi(rs.getString("vastaus_nimi"));
		v.setKysymys(new Kysymys(rs.getInt("kysymys_id"))); 
		return v;
	}

}
