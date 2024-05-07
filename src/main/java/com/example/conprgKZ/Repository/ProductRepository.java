package com.example.conprgKZ.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.conprgKZ.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional custom query methods can be declared here if needed
}
