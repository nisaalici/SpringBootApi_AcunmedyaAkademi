package com.example.productapi.config;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository repository;

    public DataLoader(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            repository.save(new Product("Laptop", 14500.5, 10));
            repository.save(new Product("Mouse", 250.0, 100));
            repository.save(new Product("Klavye", 475.0, 50));
            repository.save(new Product("Monitor", 3250.0, 25));
            System.out.println("Örnek veriler yüklendi.");
        }
    }
}
