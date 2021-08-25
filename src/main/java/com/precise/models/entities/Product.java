package com.precise.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required")
	@Column(name="product_name", length=100)
	private String name;
	
	@NotEmpty(message="description is required")
	@Column(name="product_description", length=50)
	private String desc;
	
	private double price;
	
	@ManyToOne
	private Category category;
	
	@ManyToMany
	@JoinTable(
			name="product_supplier", 
			joinColumns = @JoinColumn(name="product_id"), 
			inverseJoinColumns = @JoinColumn(name="supplier_id")
	)
	//@JsonManagedReference
	private Set<Supplier> suppliers;
	
	public Product() {
		
	}
	
	public Product(Long id, String name, String desc, double price) {
		this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
	}

	public Set<Supplier> getSupplier() {
		return suppliers;
	}

	public void setSupplier(Set<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
