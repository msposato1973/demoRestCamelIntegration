package com.demo.spring.caml.api.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.spring.caml.api.entity.Order;
import com.demo.spring.caml.api.service.IOrderService;

@Component
public class OrderProcessor implements Processor {

	@Autowired
	private IOrderService service;

	@Override
	public void process(Exchange exchange) throws Exception {
		service.addOrder(exchange.getIn().getBody(Order.class));

	}

}
