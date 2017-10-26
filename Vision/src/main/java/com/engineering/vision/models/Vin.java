package com.engineering.vision.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="vins")
public class Vin {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="vinid")
	private Long vinid;
	private String vin;
	private String model;
	private String make;
	@Column(name="transmission")
	private String transmissionModel;
	@Column(name="drivetype")
	private String transmissionModeDesc;
	@Column(name="drivetypedesc")
	private String driveType;
	@Column(name="gearratio")
	private String gearRatio;
	@Column(name="overallratio")
	private String overallRatio;
	@Column(name="gcwlimit")
	private String gcwLimit;
	@Column(name="dryweight")
	private String dryWeight;

	@ManyToMany(targetEntity = SalesCode.class, cascade = { CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "vincodes", joinColumns = {@JoinColumn(name = "vinid")}, inverseJoinColumns = {@JoinColumn(name = "salescodeid")})
	private Set<SalesCode> salesCodes;
	
	
	public Vin() {
		
	}
	
	public Vin(String vin) {
		this.vin = vin;
		this.model = "DD13";
		this.make = "Freight";
		this.transmissionModel = "Yes";
		this.salesCodes = new HashSet<>();
	}
	
	public Vin(String vin, String model, String make, String transmission, Set<SalesCode> codes) {
		super();
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.transmissionModel = transmission;
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
	
	public String getTransmissionModel() {
		return transmissionModel;
	}
	
	public void setTransmissionModel(String transmission) {
		this.transmissionModel = transmission;
	}
	
	public Set<SalesCode> getSalesCodes() {
		return salesCodes;
	}

	public void setSalesCodes(Set<SalesCode> salesCodes) {
		this.salesCodes = salesCodes;
	}

	public Long getVinid() {
		return vinid;
	}

	public void setVinid(Long vinid) {
		this.vinid = vinid;
	}

	public String getTransmissionModeDesc() {
		return transmissionModeDesc;
	}

	public void setTransmissionModeDesc(String transmissionModeDesc) {
		this.transmissionModeDesc = transmissionModeDesc;
	}

	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public String getGearRatio() {
		return gearRatio;
	}

	public void setGearRatio(String gearRatio) {
		this.gearRatio = gearRatio;
	}

	public String getOverallRatio() {
		return overallRatio;
	}

	public void setOverallRatio(String overallRatio) {
		this.overallRatio = overallRatio;
	}

	public String getGcwLimit() {
		return gcwLimit;
	}

	public void setGcwLimit(String gcwLimit) {
		this.gcwLimit = gcwLimit;
	}

	public String getDryWeight() {
		return dryWeight;
	}

	public void setDryWeight(String dryWeight) {
		this.dryWeight = dryWeight;
	}

}
