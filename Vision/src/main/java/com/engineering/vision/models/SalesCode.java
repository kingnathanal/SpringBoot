package com.engineering.vision.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SalesCode {
	
	@Id
	@JsonIgnore
	private int salesCodeId; 
	
	private String salesCode = "";
	
	private String salesCodeDescription = "";
	
	@ManyToMany
	List<Vin> vins = new ArrayList<>();
	
	public SalesCode() {
		
	}
	
	public SalesCode(String salesCode) {
		this.salesCode = salesCode;
		this.salesCodeDescription = "Default";
	}

	public SalesCode(String salesCode, String salesCodeDescription) {
		this.salesCode = salesCode;
		this.salesCodeDescription = salesCodeDescription;
	}

	public int getSalesCodeId() {
		return salesCodeId;
	}

	public void setSalesCodeId(int salesCodeId) {
		this.salesCodeId = salesCodeId;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public String getSalesCodeDescription() {
		return salesCodeDescription;
	}

	public void setSalesCodeDescription(String salesCodeDescription) {
		this.salesCodeDescription = salesCodeDescription;
	} 
	
	

	

	
	
	
}
