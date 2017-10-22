package com.engineering.vision.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vin {
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private int vinId; 
	private String vin = "";
	private String model = "";
	private String make = "";
	private String transmission = "";

	@OneToMany
	private List<SalesCode> saleCodes = new ArrayList<>(); 
	
	public Vin() {
		
	}
	
	public Vin(String vin) {
		this.vin = vin;
		this.model = "DD13";
		this.make = "Freight";
		this.transmission = "Yes";
	}
	
	public Vin(String vin, String model, String make, String transmission, List<SalesCode> codes) {
		super();
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.transmission = transmission;
		this.saleCodes = codes; 
	}
	
	public void setVinId(int vinId) {
		this.vinId = vinId;
	}
	
	public int getVinId() {
		return vinId; 
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
	
	public List<SalesCode> getSaleCodes() {
		return saleCodes;
	}

	public void setSaleCodes(ArrayList<SalesCode> saleCodes) {
		this.saleCodes = saleCodes;
	}

}
