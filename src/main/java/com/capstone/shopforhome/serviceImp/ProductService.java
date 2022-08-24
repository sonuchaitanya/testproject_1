package com.capstone.shopforhome.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.dto.ProductDTO;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.repository.ProductRepository;
import com.capstone.shopforhome.service.IProductService;


@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product addProduct(ProductDTO dto) {
		Product product = new Product();
		product.setPid(dto.getPid());
		product.setProductName(dto.getProductName());
		product.setProductCategory(dto.getProductCategory());
		product.setProductDescription(dto.getProductDescription());
		product.setProductStock(dto.getProductStock());
		product.setProductPrice(dto.getProductPrice());
		product.setProductImage(dto.getProductImage());
		return repo.save(product);
	}

	@Override
	public void deleteProduct(Long pid) {
		repo.deleteById(pid);

	}

	@Override
	public Product updateProduct(ProductDTO dto, Long pid) {
		Product product = repo.findById(pid).get();
		product.setProductName(dto.getProductName());
		product.setProductCategory(dto.getProductCategory());
		product.setProductDescription(dto.getProductDescription());
		product.setProductStock(dto.getProductStock());
		product.setProductPrice(dto.getProductPrice());
		product.setProductImage(dto.getProductImage());
		return repo.save(product);
	}

	@Override
	public List<Product> getProduct() {
		return repo.findAll();
	}

}
