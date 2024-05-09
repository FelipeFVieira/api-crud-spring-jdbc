package com.restapi.SpringBandAPI.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.restapi.SpringBandAPI.model.Band;

public class BandRepository implements MyCrud {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Band> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Band buscaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int altera(Band band, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insere(Band band) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exclui(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
