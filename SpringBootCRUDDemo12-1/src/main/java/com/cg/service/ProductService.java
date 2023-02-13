package com.cg.service;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public String addProduct(Product product) {
		productRepository.saveAndFlush(product);
		return "Product Added Successfully";
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	public void delete(int id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(@RequestBody Product product) {
		if (!productRepository.existsById(product.getProductcode())) {
			throw new ProductNotFoundException("product not found");
		} else {
			Product prod = productRepository.findById(product.getProductcode()).get();
			// prod.setProductcode(product.getProductcode());
			prod.setProductname(product.getProductname());
			prod.setProductprice(product.getProductprice());
			prod.setProductstock(product.getProductstock());

			productRepository.save(prod);

			return prod;
		}
	}
}