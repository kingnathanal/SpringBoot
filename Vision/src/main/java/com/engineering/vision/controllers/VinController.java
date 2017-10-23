package com.engineering.vision.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.vision.Repositories.SalesCodesRepository;
import com.engineering.vision.Repositories.VinRepository;
import com.engineering.vision.models.SalesCode;
import com.engineering.vision.models.Vin;

@RestController
@RequestMapping("/vins")
public class VinController {
	
	@Autowired
	private VinRepository vinRepo;
	
	@Autowired
	private SalesCodesRepository codesRepo;

	@GetMapping(value = "/all")
	List<Vin> getAllVins() {
		return vinRepo.findAll(); 
	}
	
	@GetMapping(value = "/{vin}")
	Vin getVin(@PathVariable String vin) {
		return vinRepo.findOne(vin);
	}
	
	@DeleteMapping(value = "/remove/{vin}") 
	void removeVin(@PathVariable String vin) throws Exception {
		
		if(!vinRepo.exists(vin))
			throw new Exception("Vin: " +vin + " doesnt exist!!");
		
		vinRepo.delete(vin);
		
	}
	
	@PostMapping(value = "/add/{vin}")
	Vin addVin(@PathVariable String vin) throws Exception {
		
		if(vinRepo.exists(vin))
			throw new Exception("Vin: " + vin + "exist already!!");
		
		vinRepo.save(new Vin(vin));
		return vinRepo.findOne(vin);
	}
	
	@PostMapping(value = "/{vin}/addsalescode/{code}")
	Vin addSalesCodeToVin(@PathVariable String vin,@PathVariable String code) throws Exception {
		
		if(!vinRepo.exists(vin) || !codesRepo.exists(code))
			throw new Exception("Vin or Sales Code doesnt exist");
			
		Vin v = vinRepo.findOne(vin);
		SalesCode salesCode = codesRepo.findOne(code);
		v.getSalesCodes().add(salesCode);
		vinRepo.save(v);
		
		return vinRepo.findOne(vin);
	}
	
	@PostMapping(value = "/{vin}/removecode/{code}")
	Vin removeSalesCodeFromVin(@PathVariable String vin, @PathVariable String code) {
		
		Vin v = vinRepo.findOne(vin);
		v.getSalesCodes().removeIf(x -> x.getSalesCode().equals(code));
		vinRepo.save(v);
		return vinRepo.findOne(vin);
	}
	
	@PostMapping(value = "/{vin}/removecodes")
	Vin removeSalesCodeFromVin(@PathVariable String vin) {
		
		Vin v = vinRepo.findOne(vin);
		v.setSalesCodes(new ArrayList<>());
		vinRepo.save(v);
		return vinRepo.findOne(vin);
	}
	
	
	
}
