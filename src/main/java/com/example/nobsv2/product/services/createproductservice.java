package com.example.nobsv2.product.services;

import ch.qos.logback.core.util.StringUtil;
import com.example.nobsv2.exceptions.ProductNotValidException;
import com.example.nobsv2.product.Command;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.ProductRepository;
import com.example.nobsv2.validators.ProductValidator;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class createproductservice implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;

    public createproductservice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        //validate
        ProductValidator.execute(product);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(savedProduct));
    }


}
