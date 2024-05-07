package com.example.conprgKZ.Service;

import com.example.conprgKZ.Entity.Product;
import com.example.conprgKZ.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService { 
	 
     private final ProductRepository productRepository; 
 
    @Autowired 
    public ProductService(ProductRepository productRepository) { 
        this.productRepository = productRepository; 
    } 
 
    public Product createProduct(Product product) { 
        // Add any business logic/validation here if needed 
        return productRepository.save(product); 
    } 
    public Product getProductById(Long productId) { 
        return productRepository.findById(productId).orElse(null); 
    } 
 
    public List<Product> getAllProducts() { 
        return productRepository.findAll(); 
    } 
}