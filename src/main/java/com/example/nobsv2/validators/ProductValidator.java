package com.example.nobsv2.validators;

import com.example.nobsv2.exceptions.ProductNotValidException;
import com.example.nobsv2.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {
    private ProductValidator() {

    }

    public static void execute(Product product){
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductNotValidException("Name is required");
        }

        if(product.getDescription().length()<20){
            throw new ProductNotValidException("Description must be more than 20 words");
        }

        if(product.getPrice() == null || product.getPrice()<0.00){
            throw new ProductNotValidException("Price cannot be negative");
        }
    }

}
