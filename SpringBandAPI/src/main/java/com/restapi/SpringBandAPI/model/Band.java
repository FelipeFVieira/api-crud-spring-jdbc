package com.restapi.SpringBandAPI.model;

public class Band {
	
	private Long id;
	
	private String name;
	
	private int release_year;
	
	private String status;

	
	public Band(){}
	
	public Band(Long id, String name, int release_year, String status) {
        this.id = id;
    	this.name = name;
        this.release_year = release_year;
        this.status = status;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}