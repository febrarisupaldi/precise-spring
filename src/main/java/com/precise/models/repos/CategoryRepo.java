package com.precise.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.precise.models.entities.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> {
	Page<Category> findByNameContains(String name, Pageable pageable);
}
