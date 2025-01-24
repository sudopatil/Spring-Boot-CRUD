package com.example.nobsv2.product.services;

import com.example.nobsv2.exceptions.ProductNotFound;
import com.example.nobsv2.product.Command;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.ProductRepository;
import com.example.nobsv2.product.model.UpdateProductCommand;
import com.example.nobsv2.validators.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class putproductservice implements Command<UpdateProductCommand, ProductDTO> {

    private ProductRepository productRepository;

    public putproductservice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());

        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            ProductValidator.execute(product);
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        throw new ProductNotFound();
    }
}
