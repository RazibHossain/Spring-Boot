package com.razib.orderservice.feignclient;

import com.razib.orderservice.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", fallback = ProductClientFallback.class)
public interface ProductServiceClient {

    @GetMapping("/products/checkStock/{productId}")
    Integer checkStock(@PathVariable("productId") Integer productId);
}