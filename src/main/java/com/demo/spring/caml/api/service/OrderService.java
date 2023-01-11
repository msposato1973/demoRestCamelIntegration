package com.demo.spring.caml.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.caml.api.entity.Order;
import com.demo.spring.caml.api.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{
	 
	@Autowired
	private OrderRepository repository;
  
	@Override
	public Order addOrder(Order order) {
		this.repository.save(order);
		return order;
	}

	@Override
	public List<Order> getOrders() {
		return repository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Integer id) {
	 
		return repository.findById(id);
	}


}
