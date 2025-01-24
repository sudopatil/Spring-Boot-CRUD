package com.example.nobsv2.product.services;

import com.example.nobsv2.exceptions.ProductNotFound;
import com.example.nobsv2.product.Query;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer,ProductDTO>
{
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input){
        Optional<Product> productOptional = productRepository.findById(input);

        if(productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        //throw execption

        throw new ProductNotFound();
    }
}
