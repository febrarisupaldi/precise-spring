package com.precise.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.precise.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

}
