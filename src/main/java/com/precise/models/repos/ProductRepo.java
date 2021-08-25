package com.precise.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.precise.models.entities.Product;
import com.precise.models.entities.Supplier;

public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findByNameContains(String name);
	
	@Query("SELECT p from Product p WHERE p.name= :name")
	public Product findProductByName(@PathParam("name") String name);
	
	@Query("SELECT p from Product p WHERE p.name like :name")
	public List<Product> findProductByNameLike(@PathParam("name") String name);
	
	@Query("select p from Product p where p.category.id = :categoryId")
	public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);
	
	@Query("select p from Product p where :supplier MEMBER of p.suppliers")
	public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);
}
