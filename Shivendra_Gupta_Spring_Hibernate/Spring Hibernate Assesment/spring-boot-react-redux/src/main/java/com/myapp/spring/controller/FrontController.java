package com.myapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
public class FrontController {
	
	@Autowired
	ProductRepository sr;
	
	@RequestMapping(value="/products")
	public ResponseEntity<List<Product>> getAll(){
		return new ResponseEntity<List<Product>>(sr.findAll(),HttpStatus.OK);
	}
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public ResponseEntity<Product> saveAFlight(@RequestBody Product product){
		sr.save(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	} 
	
	@RequestMapping(value="/products",method=RequestMethod.PUT)
	public ResponseEntity<Product> updateAProduct(@RequestBody Product product){
		Product s1=sr.findOne(product.getId());
	
		product=product.newProduct(s1);
		sr.save(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/products/{name}",method=RequestMethod.GET)
	public ResponseEntity<Product> findByName(@PathVariable String name){
		System.out.println(sr.findByName(name));
		return new ResponseEntity<Product>(sr.findByName(name),HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable int id){
		sr.delete(id);
		return new ResponseEntity<String>("Product deleted",HttpStatus.OK);
	}
}
