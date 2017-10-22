package com.engineering.vision.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engineering.vision.models.SalesCode;

@Repository
public interface SalesCodesRepository extends JpaRepository<SalesCode, String> {

	List<SalesCode> findByDescription(String description);
}
