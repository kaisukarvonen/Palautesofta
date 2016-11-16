package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Kysely;

public class KyselyRowMapper implements RowMapper<Kysely>{

	public Kysely mapRow(ResultSet rs, int row) throws SQLException {
		Kysely k = new Kysely();
		k.setId(rs.getInt("kysely_id"));
		k.setNimi(rs.getString("kysely_nimi"));
		return k;
	}

}
