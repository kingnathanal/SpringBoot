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
	private String transmissionTypeSalesCode;
	@Column(name="drivetype")
	private String transmissionTypeDesc;
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
		this.salesCodes = new HashSet<>();
		fillInTheDetails("343-001");
	}
	
	public Vin(String vin,String transmissionTypeSalesCode) {
		this.vin = vin;
		this.model = "DD15";
		fillInTheDetails(transmissionTypeSalesCode);
	}
	
	public Vin(String vin, String model, String make, String transmissionTypeSalesCode, Set<SalesCode> codes) {
		super();
		this.vin = vin;
		this.model = model;
		this.make = make;
		this.transmissionTypeSalesCode = transmissionTypeSalesCode;
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
	
	public String getTransmissionTypeSalesCode() {
		return transmissionTypeSalesCode;
	}
	
	public void setTransmissionTypeSalesCode(String transmissionTypeSalesCode) {
		this.transmissionTypeSalesCode = transmissionTypeSalesCode;
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

	public String getTransmissionTypeDesc() {
		return transmissionTypeDesc;
	}

	public void setTransmissionTypeDesc(String transmissionTypeDesc) {
		this.transmissionTypeDesc = transmissionTypeDesc;
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
	
	public void fillInTheDetails(String value) {
		
		switch (value) {
		case "343-001":
			this.driveType = "Direct";
			this.dryWeight = "786 lbs";
			this.gcwLimit = "80,000lbs";
			this.gearRatio = "14.93-1";
			this.overallRatio = "14.93";
			this.transmissionTypeDesc = "DT12-DA";
			this.transmissionTypeSalesCode = "343-001";
			break;
		case "343-002":
			this.driveType = "Direct";
			this.dryWeight = "786 lbs";
			this.gcwLimit = "80,000lbs";
			this.gearRatio = "14.93-1";
			this.overallRatio = "14.93";
			this.transmissionTypeDesc = "DT12-DB";
			this.transmissionTypeSalesCode = "343-002";
			break;
		case "343-003":
			this.driveType = "Overdrive";
			this.dryWeight = "786 lbs";
			this.gcwLimit = "80,000lbs";
			this.gearRatio = "11.67-0.78";
			this.overallRatio = "14.96";
			this.transmissionTypeDesc = "DT12-OA";
			this.transmissionTypeSalesCode = "343-003";
			break;
		case "343-004":
			this.driveType = "Overdrive";
			this.dryWeight = "786 lbs";
			this.gcwLimit = "80,000lbs";
			this.gearRatio = "11.67-0.78";
			this.overallRatio = "14.96";
			this.transmissionTypeDesc = "DT12-OB";
			this.transmissionTypeSalesCode = "343-004";
			break;
		default:
			this.driveType = "Unknown";
			this.dryWeight = "Unknown";
			this.gcwLimit = "Unknown";
			this.gearRatio = "Unknown";
			this.overallRatio = "Unknown";
			this.transmissionTypeDesc = "Unknown";
			this.transmissionTypeSalesCode = "Unknown";
			break;
		}
	}

}
