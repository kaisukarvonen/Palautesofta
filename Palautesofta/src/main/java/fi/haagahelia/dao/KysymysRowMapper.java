package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Kysely;
import fi.haagahelia.bean.Kysymys;

public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int row) throws SQLException {
		Kysymys k = new Kysymys();
		k.setNimi(rs.getString("kysymys_nimi"));
		k.setId(rs.getInt("kysymys_id"));
		k.setKysely(new Kysely(rs.getInt("kysely_id"))); 
		
		return k;
	}

}
