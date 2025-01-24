package com.example.nobsv2.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity //maps java class to mysql
@Data
@Table(name="product")
public class Product {

    @Id //for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generation

    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;
}
