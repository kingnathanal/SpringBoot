package com.engineering.vision.controllers;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.vision.models.SalesCode;
import com.engineering.vision.models.Vin;

@RestController
@RequestMapping("/salescodes")
public class SalesCodeController {
	
	Vin getCodesForVin() {
		
		List<SalesCode> codes = new ArrayList<>();
		codes.add(new SalesCode("12","Direct Drive"));
		codes.add(new SalesCode("13","Creep Mode"));
		codes.add(new SalesCode("15","12 Speed"));
		codes.add(new SalesCode("30","PasSmart"));
		
		Vin v = new Vin("123456","DD12","Western Star","DriveLine",codes); 
		return v;
	}
	
	@GetMapping(value = "/all")
	List<SalesCode> getAllSalesCodes() {
		
		List<SalesCode> codes = new ArrayList<>();
		codes.add(new SalesCode("12","Direct Drive"));
		codes.add(new SalesCode("13","Creep Mode"));
		codes.add(new SalesCode("15","12 Speed"));
		codes.add(new SalesCode("30","PasSmart"));
		
		return codes; 
	}
	
	@GetMapping(value = "/{code}")
	SalesCode getSalesCode(@PathVariable String code) {
		
		SalesCode salesCode = new SalesCode(code);
		return salesCode; 
	}
	
	@PostMapping(value = "/add/{code}/{desc}")
	SalesCode getSalesCode(@PathVariable String code, @PathVariable String desc) {
		
		SalesCode salesCode = new SalesCode(code, desc);
		return salesCode; 
	}
	
	@PostMapping(value = "/update/{code}/{desc}")
	SalesCode updateSalesCode(@PathVariable String code, @PathVariable String desc) {
		SalesCode salesCode = new SalesCode(code, desc);
		return salesCode; 
	}
	
	@DeleteMapping(value = "/ remove/{code}")
	String removeSalesCode(@PathVariable String code) {
		
		return "Sales Code: " + code + "Removed!"; 
	}
	
	
	
}
