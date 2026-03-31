package com.razib.productservice.controller;


import com.razib.productservice.dto.ProductRequest;
import com.razib.productservice.entity.Product;
import com.razib.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create Product
    @PostMapping(value = "/add")
    public Product createProduct(@RequestBody ProductRequest request) {
        return productService.createProduct(request);
    }

    // Get All Products
    @GetMapping(value = "/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Update Stock
    @PutMapping("/{id}/stock/update")
    public Product updateStock(@PathVariable Long id,
                               @RequestParam Integer stock) {
        return productService.updateStock(id, stock);
    }
}