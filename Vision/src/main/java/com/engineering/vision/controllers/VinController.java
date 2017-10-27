package com.engineering.vision.controllers;

import java.util.ArrayList;
import java.util.HashSet;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/vins")
@ApiResponses(
		value = { 
				@ApiResponse(code = 200, message = "Successful Vin Data Transaction"),
				@ApiResponse(code = 500, message = "Unsuccessful Vin Data Tranascation, Check Message")
		}
)
@Api(value = "Vin Rest API Service Endpoints", description = "Shows Rest Endpoints & Data for Vins")
public class VinController {
	
	@Autowired
	private VinRepository vinRepo;
	
	@Autowired
	private SalesCodesRepository codesRepo;

	@GetMapping(value = "/all")
	@ApiOperation(value = "Return a list of all avialable Vins")
	List<Vin> getAllVins() {
		return vinRepo.findAll(); 
	}
	
	@GetMapping(value = "/{vin}")
	@ApiOperation(value = "Return data for a single Vin")
	Vin getVin(@PathVariable String vin) {
		
		return vinRepo.findByVin(vin);
	}
	
	@GetMapping(value = "/{vin}/getsalescodes")
	@ApiOperation(value = "Return a list of sales codes for Vin")
	List<String> getSalesCodesForVin(@PathVariable String vin) throws Exception {
		
		if(vinRepo.findByVin(vin)== null)
			throw new Exception("Vin: " +vin + " doesnt exist!!");
		
		List<String> codes = new ArrayList<>();
		
		vinRepo.findByVin(vin).getSalesCodes().forEach(x -> codes.add(x.getSalesCode()));
		
		return codes;
	}
	
	@DeleteMapping(value = "/remove/{vin}") 
	@ApiOperation(value = "Remove a Vin from the database")
	void removeVin(@PathVariable String vin) throws Exception {
		
		if(vinRepo.findByVin(vin) == null)
			throw new Exception("Vin: " +vin + " doesnt exist!!");
		
		vinRepo.delete(vinRepo.findByVin(vin).getVinid());
		
	}
	
	@PostMapping(value = "/add/{vin}")
	@ApiOperation(value = "Add a new Vin to the database")
	Vin addVin(@PathVariable String vin) throws Exception {
		
		if(vinRepo.findByVin(vin) != null)
			throw new Exception("Vin: " + vin + "exist already!!");
		
		vinRepo.save(new Vin(vin));
		return vinRepo.findByVin(vin);
	}
	
	@PostMapping(value = "/add/{vin}/transmissiontypecode/{transCode}")
	@ApiOperation(value = "Add Or Update the transmission type sales code, ex 343-001 or 343-003")
	Vin addOrUpdateVinTransTypeCode(@PathVariable String vin, @PathVariable String transCode) {
		Vin v;
		
		if(vinRepo.findByVin(vin) != null) {
			v = vinRepo.findByVin(vin);
			v.fillInTheDetails(transCode);
		} else {
			v = new Vin(vin, transCode);
		}
		
		vinRepo.save(v);
		return vinRepo.findByVin(vin);
	}
	
	@PostMapping(value = "/{vin}/addsalescode/{code}")
	@ApiOperation(value = "Add a Sales Code to a Vin")
	Vin addSalesCodeToVin(@PathVariable String vin,@PathVariable String code) throws Exception {
		
		if(vinRepo.findByVin(vin) == null || codesRepo.findBySalesCode(code) == null)
			throw new Exception("Vin or Sales Code doesnt exist");
			
		Vin v = vinRepo.findByVin(vin);
		SalesCode salesCode = codesRepo.findBySalesCode(code);
		v.getSalesCodes().add(salesCode);
		vinRepo.save(v);
		
		return vinRepo.findByVin(vin);
	}
	
	@PostMapping(value = "/{vin}/removecode/{code}")
	@ApiOperation(value = "Remove a Sales Code from a Vin")
	Vin removeSalesCodeFromVin(@PathVariable String vin, @PathVariable String code) {
		
		Vin v = vinRepo.findByVin(vin);
		v.getSalesCodes().removeIf(x -> x.getSalesCode().equals(code));
		vinRepo.save(v);
		return vinRepo.findByVin(vin);
	}
	
	@PostMapping(value = "/{vin}/removecodes")
	@ApiOperation(value = "Remove all Sales Codes from a Vin")
	Vin removeSalesCodesFromVin(@PathVariable String vin) {
		
		Vin v = vinRepo.findByVin(vin);
		v.setSalesCodes(new HashSet<>());
		vinRepo.save(v);
		return vinRepo.findByVin(vin);
	}
	
	
	
}
