package com.engineering.vision.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="vins")
public class Vin {
	
	@Id
	private String vin;
	private String model;
	private String make;
	private String transmission;

	@ManyToMany(targetEntity = SalesCode.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "vincodes", joinColumns = {@JoinColumn(name = "vin")}, inverseJoinColumns = {@JoinColumn(name = "sales_code")})
	private Set<SalesCode> salesCodes;
	
	
	public Vin() {
		
	}
	
	public Vin(String vin) {
		this.vin = vin;
		this.model = "DD13";
		this.make = "Freight";
		this.transmission = "Yes";
	}
	
	public Vin(String vin, String model, String make, String transmission, Set<SalesCode> codes) {
		super();
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.transmission = transmission;
		this.salesCodes = codes; 
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getTransmission() {
		return transmission;
	}
	
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public Set<SalesCode> getSalesCodes() {
		return salesCodes;
	}

	public void setSalesCodes(Set<SalesCode> salesCodes) {
		this.salesCodes = salesCodes;
	}

}
