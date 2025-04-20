package com.example.productapi.controller;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return repository.findById(id)
                .map(p -> {
                    p.setName(updatedProduct.getName());
                    p.setPrice(updatedProduct.getPrice());
                    p.setStock(updatedProduct.getStock());
                    return repository.save(p);
                }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        repository.deleteById(id);
    }
}
