package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;

import com.cg.service.ProductService;

@RestController
public class ProductController {
	@Autowired

	private ProductService productservice;

	@PostMapping("/addProduct")

	public String addProduct(@Valid @RequestBody Product product)

	{

		return productservice.addProduct(product);

	}

	@GetMapping("/getAll")

	public List<Product> getAll()

	{

		return productservice.getAllProducts();

	}

	@GetMapping("/getById/{id}")

	public Product getProduct(@PathVariable("id") int pid)

	{

		return productservice.getProductById(pid);

	}

	@DeleteMapping("/deleteById/{id}")

	public void deleteProduct(@PathVariable("id") int id)

	{

		productservice.delete(id);

	}

	@PutMapping("/update")

	public Product updateProduct(@Valid @RequestBody Product product)

	{

		return productservice.updateProduct(product);

	}

}
