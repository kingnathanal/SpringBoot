package com.engineering.vision.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.vision.Repositories.SalesCodesRepository;
import com.engineering.vision.models.SalesCode;

@RestController
@RequestMapping("/salescodes")
public class SalesCodeController {
	
	@Autowired
	SalesCodesRepository codesRepo;
	
	
	@GetMapping(value = "/all")
	List<SalesCode> getAllSalesCodes() {
		
		return codesRepo.findAll(); 
	}
	
	@GetMapping(value = "/{code}")
	SalesCode getSalesCode(@PathVariable String code) {
		
		return codesRepo.findBySalesCode(code); 
	}
	
	@GetMapping(value = "/bydesc/{desc}")
	List<SalesCode> getSalesCodeByDesc(@PathVariable String desc) {
		return codesRepo.findByDescription(desc);
	}
	
	@PostMapping(value = "/add/{code}/{desc}")
	SalesCode addSalesCode(@PathVariable String code, @PathVariable String desc) throws Exception {
		
		if(codesRepo.findBySalesCode(code) != null)
			throw new Exception("Sales Code: " +code + " already exist!!");
			
		SalesCode salesCode = new SalesCode(code, desc);
		codesRepo.save(salesCode);
		return codesRepo.findOne(codesRepo.findBySalesCode(code).getSalesCodeId()); 

	}
	
	@PostMapping(value = "/update/{code}/{desc}")
	SalesCode updateSalesCode(@PathVariable String code, @PathVariable String desc) throws Exception {
		
		if(codesRepo.findBySalesCode(code) == null) 
			throw new Exception(code + " does not exist!!");
		
		SalesCode salesCode = codesRepo.findBySalesCode(code);
		salesCode.setSalesCodeDescription(desc);
		codesRepo.save(salesCode);
		return codesRepo.findOne(codesRepo.findBySalesCode(code).getSalesCodeId()); 
	}
	
	@DeleteMapping(value = "/remove/{code}")
	void removeSalesCode(@PathVariable String code) throws Exception {
		
		if(codesRepo.findBySalesCode(code) == null) 
			throw new Exception(code + " does not exist!!");
			
		codesRepo.delete(codesRepo.findBySalesCode(code).getSalesCodeId());
			
	}
	
	
	
}
