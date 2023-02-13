package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productcode;
	@Column(name = "productname")
	@NotBlank(message = "name cannot be blank")
	private String productname;
	@Column(name = "productstock")
	@NotNull(message = "stock cannot be null")
	@Min(value = 20, message = "cannot be less than 20")
	private int productstock;
	@Column(name = "productprice")
	@Min(value = 5, message = "price cannot be less than 5")
	private double productprice;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productcode, String productname, int productstock, double productprice) {
		super();
		this.productcode = productcode;
		this.productname = productname;
		this.productstock = productstock;
		this.productprice = productprice;
	}

	public int getProductcode() {
		return productcode;
	}

	public void setProductcode(int productcode) {
		this.productcode = productcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductstock() {
		return productstock;
	}

	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	@Override
	public String toString() {
		return "Product [productcode=" + productcode + ", productname=" + productname + ", productstock=" + productstock
				+ ", productprice=" + productprice + "]";
	}
}