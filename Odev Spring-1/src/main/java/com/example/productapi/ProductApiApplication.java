package com.example.productapi;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProductApiApplication {
    public static void main (String[] args){
        SpringApplication.run(ProductApiApplication.class, args);
    }
}

