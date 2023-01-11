package com.demo.spring.caml.api.service;

import java.util.List;
import java.util.Optional;

import com.demo.spring.caml.api.entity.Order;

public interface IOrderService {
	
	  Order addOrder(Order order) ;

	  List<Order> getOrders() ;
	  
	  Optional<Order> getOrderById(Integer id) ;
}
