package com.precise.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.precise.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
	Supplier findByEmail(String email);
	
	List<Supplier> findByNameContainsOrderByIdDesc(String name);
	
	List<Supplier> findByNameStartingWith(String prefixName);
	
	List<Supplier> findByNameContainsOrEmailContains(String name, String eamil);
}
