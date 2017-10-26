package com.engineering.vision.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "salescodes")
public class SalesCode {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="salescodeid")
	private Long salesCodeId;
	@Column(name="salescode")
	private String salesCode;
	private String description;
	
	@ManyToMany(mappedBy = "salesCodes")
	private Set<Vin> vin;
	
	public SalesCode() {
		
	}
	
	public SalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public SalesCode(String salesCode, String salesCodeDescription) {
		this.salesCode = salesCode;
		this.description = salesCodeDescription;
	}

	public String getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(String salesCode) {
		this.salesCode = salesCode;
	}

	public String getSalesCodeDescription() {
		return description;
	}

	public void setSalesCodeDescription(String description) {
		this.description = description;
	}

	public Long getSalesCodeId() {
		return salesCodeId;
	}

	public void setSalesCodeId(Long salescodeid) {
		this.salesCodeId = salescodeid;
	}
		
	
	
}
