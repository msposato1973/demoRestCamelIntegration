package com.demo.spring.caml.api.resource;


import static org.apache.camel.Exchange.HTTP_RESPONSE_CODE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Optional;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultMessage;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.demo.spring.caml.api.entity.Order;
import com.demo.spring.caml.api.processor.OrderProcessor;
import com.demo.spring.caml.api.service.IOrderService;
 

@Component
public class ApplicationResource extends RouteBuilder {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationResource.class);

	@Autowired
	private IOrderService service;

	@BeanInject
	private OrderProcessor processor;
	
	private static final String ADD = "/addOrder";
	private static final String ORDER = "/camelOrder";
	private static final String ALL = "/getOrders";
	private static final String BY_ID = "/getOrderById/{id}";
	private static final String MSG = "Demo camel with spring boot";
	
	public ApplicationResource() {
		
	}
	
	@Override
	public void configure() throws Exception {
		
		logger.info("configure");
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);
		
		rest().get(ORDER).produces(MediaType.APPLICATION_JSON_VALUE).route()
		.setBody(constant(MSG)).endRest();
		

		rest().get(ALL).produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getOrders())
		.endRest();
		
		
		rest().post(ADD).consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
		.route().process(processor).endRest();
		
		rest()
			.consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
			.get(BY_ID).outType(Order.class).route()
			.process(this::getOrderById);

	}
	
	private void getOrderById(Exchange exchange) {
		 logger.info("getOrderById");
		 Integer id = exchange.getMessage().getHeader("id", Integer.class);
			
		 Optional<Order> currenctOrder = service.getOrderById(id);
		 
		 if(currenctOrder.isPresent()) {
			 Message message = new DefaultMessage(exchange.getContext());
			 message.setBody(currenctOrder.get());
			 exchange.setMessage(message);
		 } else {
		     exchange.getMessage().setHeader(HTTP_RESPONSE_CODE, NOT_FOUND.getClass());	
		 }
	 
	}
	
	

}
