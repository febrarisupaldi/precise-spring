package com.precise.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.precise.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

}
