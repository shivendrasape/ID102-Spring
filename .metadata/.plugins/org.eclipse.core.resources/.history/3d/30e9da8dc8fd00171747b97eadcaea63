package com.myapp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	@Autowired
    private ProductRepository products;


    @PostMapping(value = "/products/save", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        products.save(product);

        return new ResponseEntity<>(product, OK);
    }
    @GetMapping(value = "/products/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<Product>> saveProduct() {
        return new ResponseEntity<>(products.findAll(), OK);
    }

}
