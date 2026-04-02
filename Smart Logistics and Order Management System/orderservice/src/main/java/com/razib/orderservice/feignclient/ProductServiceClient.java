package com.razib.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productservice", url = "http://localhost:9010")
public interface ProductServiceClient {

    @GetMapping("/products/checkStock/{productId}")
    Integer checkStock(@PathVariable("productId") Integer productId);
}