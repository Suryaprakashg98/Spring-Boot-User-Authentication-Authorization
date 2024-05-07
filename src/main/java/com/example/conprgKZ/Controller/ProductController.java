package com.example.conprgKZ.Controller;

import com.example.conprgKZ.Entity.Product;
import com.example.conprgKZ.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController { 
	 @Autowired
    private final ProductService productService; 
 
    
    public ProductController(ProductService productService) { 
        this.productService = productService; 
    } 
 
    @PostMapping 
    @CrossOrigin(origins = "http://localhost:3000") 
    public ResponseEntity<Product> createProduct(@RequestBody Product product) { 
        Product createdProduct = productService.createProduct(product); 
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED); 
    } 
    @GetMapping("/{productId}") 
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) { 
        Product product = productService.getProductById(productId); 
        if (product != null) { 
            return new ResponseEntity<>(product, HttpStatus.OK); 
        } else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        } 
    } 
 
    @GetMapping 
    public ResponseEntity<List<Product>> getAllProducts() { 
        List<Product> products = productService.getAllProducts(); 
        if (!products.isEmpty()) { 
            return new ResponseEntity<>(products, HttpStatus.OK); 
        } else { 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        } 
    } 
}
