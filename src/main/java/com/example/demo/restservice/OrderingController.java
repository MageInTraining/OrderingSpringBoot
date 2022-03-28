package com.example.demo.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderingController {

	private static DB db = DB.getInstance();
	private static final String templateOrderCreated = "Order was created: %s!";

	//call example: http://localhost:8080/ordering/getOrder?id=1
	@GetMapping("/ordering/getOrder")
	public Order getOrder(@RequestParam(value = "id") int id) {
		Order order = db.getObject(id);
		return order;
	}
	
	//call example: http://localhost:8080/ordering/setOrder?id=1&customer=Honza&item=teddybear
	@GetMapping("/ordering/setOrder")
	public String setOrder(@RequestParam(value = "customer") String customer,
			@RequestParam(value = "item") String item) {
		Order order = new Order(db.getLastKey(), customer, item);
		db.addObject(order, order.getId());
		
		return String.format(templateOrderCreated, order.getId());
	}
}
