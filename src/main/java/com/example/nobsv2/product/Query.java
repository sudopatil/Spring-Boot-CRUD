package com.example.nobsv2.product;

import org.springframework.http.ResponseEntity;

public interface Query < I, O>{

    default ResponseEntity<O> execute(I input) {
        return null;
    }
}
