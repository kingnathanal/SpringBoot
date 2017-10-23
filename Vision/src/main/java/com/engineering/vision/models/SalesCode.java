package com.engineering.vision.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salescodes")
public class SalesCode {
	
	@Id
	@Column(name = "sales_code")
	private String salesCode = "";
	private String description = "";
	
	@ManyToMany(mappedBy = "salesCodes")
	List<Vin> vin;
	
	public SalesCode() {
		
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
	
	

	

	
	
	
}
