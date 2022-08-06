package com.goldenshoe.ecommerceservice.controllers;

import com.goldenshoe.ecommerceservice.repositories.ProductRepository;
import com.goldenshoe.ecommerceservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity getProduct(@PathVariable Long id){
        return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
    }
}
