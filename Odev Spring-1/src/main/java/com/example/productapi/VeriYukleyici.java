package com.example.productapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.productapi.repository.ProductRepository;
import com.example.productapi.entity.Product;

@Component
public class VeriYukleyici implements CommandLineRunner {

    private final ProductRepository productRepository;

    public VeriYukleyici(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public void run( String... args)throws Exception{
        if (productRepository.count()==0){
            Product urun1=new Product();

            urun1.setName("MacBook Pro");
            urun1.setPrice(75999.00);
            urun1.setStock(24);

            productRepository.save(urun1);

            Product urun2 = new Product();

            urun2.setName("Iphone 15");
            urun2.setPrice(57000.00);
            urun2.setStock(27);

            productRepository.save(urun2);
        }
    }

}


