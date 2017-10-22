package com.engineering.vision.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.vision.models.SalesCode;
import com.engineering.vision.models.Vin;

@RestController
@RequestMapping("/vins")
public class VinController {

	@GetMapping(value = "/all")
	List<Vin> getAllVins() {
		
		List<Vin> vins = new ArrayList<>();
		vins.add(new Vin("123456"));
		vins.add(new Vin("098765"));
		vins.add(new Vin("222222"));
		vins.add(new Vin("444444"));
		return vins; 
	}
	
	@GetMapping(value = "/{vin}")
	Vin getVin(@PathVariable String vin) throws Exception {
		
		if(vin.equalsIgnoreCase("123456")) {
			Vin v = new Vin(vin);
			return v;
		} else{
		    throw new Exception("Vin "+vin+" does not exists");
		}
	}
	
	@DeleteMapping(value = "/remove/{vin}") 
	String removeVin(@PathVariable String vin) {
		
		System.out.println("Removing Vin: " + vin );
		return "Removing Vin: " + vin; 
	}
	
	@PostMapping(value = "/add/{vin}")
	String addVin(@PathVariable String vin) {
		
		return "Adding new Vin: " + vin;
	}
	
	@PostMapping(value = "/addsalescode/{vin}/{code}")
	Vin addSalesCodeToVin(@PathVariable String vin,@PathVariable String code) {
		
		Vin v = new Vin(vin);
		SalesCode salesCode = new SalesCode(code);
		v.getSaleCodes().add(salesCode);
		
		return v;
	}
	
	
	
}
