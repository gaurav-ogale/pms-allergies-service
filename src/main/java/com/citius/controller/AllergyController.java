package com.citius.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citius.exception.AllergyException;
import com.citius.model.Allergy;
import com.citius.services.AllergyService;

@RestController
public class AllergyController {
	
	@Autowired
	private AllergyService allergyService;
	
	@GetMapping("/getAllergyById/{allergyId}")
	public ResponseEntity<List<Allergy>> getAllergyById(@PathVariable String allergyId) throws AllergyException {
		
		List<Allergy> list = new ArrayList<>();
		try {
		System.out.println("Inside Controller");
		list= allergyService.getAllergyById(allergyId);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Allergy>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllergyByType/{allergyType}")
	public ResponseEntity<List<Allergy>> getAllergyByType(@PathVariable String allergyType) throws AllergyException {
		
		List<Allergy> list = new ArrayList<>();
		try {
		System.out.println("Inside Controller");
		list= allergyService.getAllergyByType(allergyType);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Allergy>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("getAllergies")
	public ResponseEntity<List<Allergy>> getAllergies() {
		
		List<Allergy> list = new ArrayList<>();
		try {
		System.out.println("Inside Controller");
		list= allergyService.getAllergies();
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Allergy>>(list, HttpStatus.OK);
		
	}	
	
	@PostMapping("/newAllergy")
	public ResponseEntity<?> enterNewAllergy(@RequestBody Allergy allergy) {
		
		try{
			allergyService.enterNewAllergy(allergy);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
