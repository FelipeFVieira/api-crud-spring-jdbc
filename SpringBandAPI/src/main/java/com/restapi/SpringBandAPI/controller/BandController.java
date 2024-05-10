package com.restapi.SpringBandAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.IsNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.SpringBandAPI.model.Band;
import com.restapi.SpringBandAPI.repository.BandRepository;

import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping(path="/bands")
public class BandController {
	
	@Autowired
	private BandRepository bandRepository;
	
	
	@GetMapping(path="/all")
	public @ResponseBody ResponseEntity<Iterable<Band>> getAllBands() {
		   try {
		        Iterable<Band> allBands = bandRepository.selectAll();
		        return ResponseEntity.ok(allBands);
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ResponseEntity<Band> addNewBand (@RequestBody Band band) {
		if (band.getName() == null || band.getRelease_year() == null|| band.getStatus() == null) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
		
		try {
	        Band savedBand = bandRepository.Insert(band);
	        return ResponseEntity.ok(savedBand);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
	}
	
	@DeleteMapping(path="/del/{id}")
	public @ResponseBody ResponseEntity<Band> deleteBand (@PathVariable int id) {
		Band band = null;
		band = bandRepository.findById(id);
		if (band == null) {
			return ResponseEntity.notFound().build();
		} 
		bandRepository.Delete(id);
		return ResponseEntity.ok(band);
	}
	
	@PutMapping(path="/update/{id}")
	public @ResponseBody ResponseEntity<Band> updateBand(@PathVariable int id, @RequestBody Band updatedBand) {
		if (updatedBand.getName() == null || updatedBand.getRelease_year() == null|| updatedBand.getStatus() == null) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	    }
		
		Band band = null;
		band = bandRepository.findById(id);
		if (band == null) {
			return ResponseEntity.notFound().build();
		}
	  
		Band savedBand = bandRepository.Update(band, id);
	    return ResponseEntity.ok(savedBand);
		
	}
	
}
