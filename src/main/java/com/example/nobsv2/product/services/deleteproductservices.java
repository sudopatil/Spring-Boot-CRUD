package com.example.nobsv2.product.services;

import com.example.nobsv2.exceptions.ProductNotFound;
import com.example.nobsv2.product.Command;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class deleteproductservices implements Command< Integer, Void> {

private ProductRepository productRepository;

    public deleteproductservices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        // exception here latter;
        throw new ProductNotFound();
    }
}
