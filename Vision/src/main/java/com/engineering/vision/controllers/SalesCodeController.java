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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/salescodes")
@ApiResponses(
		value = { 
				@ApiResponse(code = 200, message = "Successful Sales Code Data Transaction"),
				@ApiResponse(code = 500, message = "Unsuccessful Sales Code Data Tranascation, Check Message")
		}
)
@Api(value = "Sales Codes Rest API Service Endpoints", description = "Shows Rest Endpoints & Data for Sales Codes")
public class SalesCodeController {
	
	@Autowired
	SalesCodesRepository codesRepo;
	
	
	@GetMapping(value = "/all")
	@ApiOperation(value = "Return a list of all Sales Codes")
	List<SalesCode> getAllSalesCodes() {
		
		return codesRepo.findAll(); 
	}
	
	@GetMapping(value = "/{code}")
	@ApiOperation(value = "Return data for a Sales Code")
	SalesCode getSalesCode(@PathVariable String code) {
		
		return codesRepo.findBySalesCode(code); 
	}
	
	@GetMapping(value = "/bydesc/{desc}")
	@ApiOperation(value = "Return a list of Sales Codes by Description")
	List<SalesCode> getSalesCodeByDesc(@PathVariable String desc) {
		return codesRepo.findByDescription(desc);
	}
	
	@PostMapping(value = "/add/{code}/{desc}")
	@ApiOperation(value = "Add new Sales Code to Database, add Sales Code Description")
	SalesCode addSalesCode(@PathVariable String code, @PathVariable String desc) throws Exception {
		
		if(codesRepo.findBySalesCode(code) != null)
			throw new Exception("Sales Code: " +code + " already exist!!");
			
		SalesCode salesCode = new SalesCode(code, desc);
		codesRepo.save(salesCode);
		return codesRepo.findOne(codesRepo.findBySalesCode(code).getSalesCodeId()); 

	}
	
	@PostMapping(value = "/update/{code}/{desc}")
	@ApiOperation(value = "Update Sales Code with new Description")
	SalesCode updateSalesCode(@PathVariable String code, @PathVariable String desc) throws Exception {
		
		if(codesRepo.findBySalesCode(code) == null) 
			throw new Exception(code + " does not exist!!");
		
		SalesCode salesCode = codesRepo.findBySalesCode(code);
		salesCode.setSalesCodeDescription(desc);
		codesRepo.save(salesCode);
		return codesRepo.findOne(codesRepo.findBySalesCode(code).getSalesCodeId()); 
	}
	
	@DeleteMapping(value = "/remove/{code}")
	@ApiOperation(value = "Remove Sales Code from Database")
	void removeSalesCode(@PathVariable String code) throws Exception {
		
		if(codesRepo.findBySalesCode(code) == null) 
			throw new Exception(code + " does not exist!!");
			
		codesRepo.delete(codesRepo.findBySalesCode(code).getSalesCodeId());
			
	}
	
	
	
}
