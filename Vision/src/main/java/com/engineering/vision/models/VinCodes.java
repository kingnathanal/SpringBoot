package com.engineering.vision.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class VinCodes {
	
	private Vin vin; 
	private SalesCode salesCode;
	
	public VinCodes() {
		
	}
	
	public VinCodes(Vin vin, SalesCode salesCode) {
		this.vin = vin;
		this.salesCode = salesCode;
	}

	public Vin getVin() {
		return vin;
	}

	public void setVin(Vin vin) {
		this.vin = vin;
	}

	public SalesCode getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(SalesCode salesCode) {
		this.salesCode = salesCode;
	}


	
	

}
