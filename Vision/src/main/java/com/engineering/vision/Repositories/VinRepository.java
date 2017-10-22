package com.engineering.vision.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engineering.vision.models.Vin;

@Repository
public interface VinRepository extends JpaRepository<Vin, String> {
	
	//Vin findByVin(String vin);
	List<Vin> findByModel(String model);
}
