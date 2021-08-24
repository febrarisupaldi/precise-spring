package com.precise.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.precise.models.entities.Category;
import com.precise.models.repos.CategoryRepo;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category findOne(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(!category.isPresent()) {
			return null;
		}
		return category.get();
	}
	
	public Iterable<Category> findAll(){
		return categoryRepo.findAll();
	}
	
	public void removeOne(Long id) {
		categoryRepo.deleteById(id);
	}
	
//	public List<Category> findByName(String name){
//		return categoryRepo.findByNameContains(name);
//	}
}
