package com.example.nobsv2.product;

import com.example.nobsv2.exceptions.ProductNotFound;
import com.example.nobsv2.product.model.ErrorResponse;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.UpdateProductCommand;
import com.example.nobsv2.product.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final createproductservice createproductservice;
    private final getproductsservice getproductsservice;
    private final putproductservice putproductservice;
    private final deleteproductservices deleteproductservices;
    private final GetProductService getProductService;



    public ProductController(com.example.nobsv2.product.services.createproductservice createproductservice,
                             getproductsservice getproductsservice,
                             com.example.nobsv2.product.services.putproductservice putproductservice,
                             com.example.nobsv2.product.services.deleteproductservices deleteproductservices,
                             GetProductService getProductService, GetProductService getProductService1)
    {
        this.createproductservice = createproductservice;
        this.getproductsservice = getproductsservice;
        this.putproductservice = putproductservice;
        this.deleteproductservices = deleteproductservices;
        this.getProductService = getProductService1;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product)
    {
       return createproductservice.execute(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getproducts(){
        return getproductsservice.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateptoduct(@PathVariable Integer id, @RequestBody Product product){

        //we ned to pass 2 things in execute method but we cant so create new class to hod new product
        return putproductservice.execute( new UpdateProductCommand(id, product));
    }
    @DeleteMapping("/product/{id}") //id here must match
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return deleteproductservices.execute(id);
    }



}