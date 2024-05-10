package com.restapi.SpringBandAPI.repository;

import java.util.List;

import com.restapi.SpringBandAPI.model.Band;

public interface MyCrud {
	
	public List<Band> selectAll();
	
	public Band findById(int id);
	
	public int Update(Band band, int id);
	
	public int Insert(Band band);
	
	public boolean Delete(int id);

}
