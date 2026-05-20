package com.rikkeiedu.ss4.controller;

import com.rikkeiedu.ss4.entity.Product;
import com.rikkeiedu.ss4.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Valid
            @RequestBody Product product
    ){
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(201).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @Valid
            @RequestBody Product product
    ){
        if(!productRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        product.setId(id);
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
}
