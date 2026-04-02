package com.razib.productservice.repository;

import com.razib.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select stock from products where id = ?1",nativeQuery = true)
    Integer getStock(Integer productId);
}