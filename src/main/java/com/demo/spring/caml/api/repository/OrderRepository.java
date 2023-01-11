package com.demo.spring.caml.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.caml.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	 

}
