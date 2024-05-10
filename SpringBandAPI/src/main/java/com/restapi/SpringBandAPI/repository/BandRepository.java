package com.restapi.SpringBandAPI.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restapi.SpringBandAPI.model.Band;

@Repository
public class BandRepository implements MyCrud {
	
	private String SQLSELECTALL = "SELECT * FROM bands";
	
	private String SQLSELECTBYID = "SELECT * FROM bands WHERE id = ?";
	
	private String SQLINSERT = "INSERT INTO bands VALUES(default, ? ,?, ?)";
	
	private String SQLUPDATE = "UPDATE bands SET name = ?, release_year = ?, status = ? WHERE id = ? ";
	
	private String SQLDELETE = "DELETE FROM bands WHERE id = ?";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Band> selectAll() {
		return jdbcTemplate.query(SQLSELECTALL, (rs, rowNum) -> { 
			return new Band(rs.getLong("id"), rs.getString("name"), rs.getInt("release_year"), rs.getString("status"));
		});
	}

	@Override
	public Band findById(int id) {
		Object[] params = {id};
		return jdbcTemplate.queryForObject(SQLSELECTBYID,params, (rs, rowNum) -> { 
			return new Band(rs.getLong("id"), rs.getString("name"), rs.getInt("release_year"), rs.getString("status"));
		});
	}

	@Override
	public int Update(Band band, int id) {
		Object[] params = {band.getName(), band.getRelease_year(), band.getStatus(), id};
		return jdbcTemplate.update(SQLUPDATE, params);
	}

	@Override
	public int Insert(Band band) {
		return 0;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
