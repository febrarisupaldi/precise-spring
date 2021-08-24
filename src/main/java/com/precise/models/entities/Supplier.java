package com.precise.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="supplier")
public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Name is required")
	@Column(length=100, nullable = false)
	private String name;
	
	@NotEmpty(message="Address is required")
	@Column(length=150, nullable = false)
	private String address;
	
	@NotEmpty(message="Email is required")
	@Column(length=100, nullable = false, unique=true)
	private String email;
	
	@ManyToMany(mappedBy = "suppliers")
	private Set<Product> products;

	public Set<Product> getProduct() {
		return products;
	}

	public void setProduct(Set<Product> products) {
		this.products = products;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
