package com.razib.productservice.controller;


import com.razib.productservice.component.AuthContext;
import com.razib.productservice.dto.ProductRequest;
import com.razib.productservice.entity.Product;
import com.razib.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @Autowired
    AuthContext authContext;

    // Create Product
    @PostMapping(value = "/add")
    public Product createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    // Get All Products
    @GetMapping(value = "/getAll")
    public List<Product> getAllProducts() {
        System.out.println("User: " + authContext.getUsername());
        System.out.println("Roles: " + authContext.getRoles());
        System.out.println("UserId: " + authContext.getUserId());
        return productService.getAllProducts();
    }

    // Update Stock
    @PutMapping("/{id}/stock/update")
    public Product updateStock(@PathVariable Long id,
                               @RequestParam Integer stock) {
        return productService.updateStock(id, stock);
    }

    @GetMapping(value = "/checkStock/{productId}")
    public Integer getStock(@PathVariable Integer productId) {
        return productService.checkStock(productId);
    }
}