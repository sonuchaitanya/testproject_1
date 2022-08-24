package com.capstone.shopforhome.service;

import java.util.List;

import com.capstone.shopforhome.dto.ProductDTO;
import com.capstone.shopforhome.entity.Product;

public interface IProductService {
	public Product addProduct(ProductDTO dto);
	public void deleteProduct(Long pid);
	public Product updateProduct(ProductDTO dto,Long pid);
	public List<Product> getProduct();
}
