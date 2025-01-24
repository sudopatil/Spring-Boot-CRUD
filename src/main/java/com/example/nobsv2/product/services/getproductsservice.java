package com.example.nobsv2.product.services;

import com.example.nobsv2.product.Query;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getproductsservice implements Query<Void,List<ProductDTO>> {


    private final ProductRepository productRepository;

    public getproductsservice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {

        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
