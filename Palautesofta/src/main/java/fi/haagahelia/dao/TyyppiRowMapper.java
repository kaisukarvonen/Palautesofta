package fi.haagahelia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.haagahelia.bean.Tyyppi;

public class TyyppiRowMapper implements RowMapper<Tyyppi> {

	public Tyyppi mapRow(ResultSet rs, int row) throws SQLException {
		Tyyppi t = new Tyyppi();
		t.setId(rs.getInt("tyyppi_id"));
		t.setNimi(rs.getString("tyyppi_nimi"));  
		return t;
	}
	
	/*CREATE TABLE kysymys_tyyppi (
		tyyppi_id integer NOT NULL
		,tyyppi_nimi varchar(255) NOT NULL
		,PRIMARY KEY(tyyppi_id)
		)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 * 
	 * 
	 */

}
