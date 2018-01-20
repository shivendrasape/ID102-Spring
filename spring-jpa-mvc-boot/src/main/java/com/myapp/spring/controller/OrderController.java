package com.myapp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.hibernate.model.Order;
import com.myapp.spring.repository.OrderRepository;

@RestController // for jSON data
public class OrderController {

	@Autowired
	private OrderRepository orderService;

	@RequestMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<String> placeAnOrder(@RequestBody Order order) {
		orderService.save(order);
		return new ResponseEntity<String>("Order Save", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAnOrder( @RequestBody Order order) {
		orderService.save(order);
		return new ResponseEntity<String>("Order Updated", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAnOrder(@PathVariable("id") long id) {
		orderService.delete(id);
		return new ResponseEntity<String>("Order deleted", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findAnOrder(@PathVariable("id") long id) {

		return new ResponseEntity<Order>(orderService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/orders/find", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> findByOrderNo(@RequestParam("orderNumber") String orderNumber) {

		return new ResponseEntity<List<Order>>((List<Order>) orderService.findByOrderNumber(orderNumber),
				HttpStatus.OK);
	}
}
