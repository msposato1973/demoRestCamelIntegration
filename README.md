# demoRestCamelIntegration
Camel integration with spring boot

- How to expose Rest API using Spring Boot with Apache Camel

- Dependencies we have to add for apache camel
.org.apache.camel 
.camel-spring-boot-starter 

## V. 2.24.0 
- org.apache.camel 
- camel-servlet-starter  
- org.apache.camel 
- camel-jackson

## Rest APIs

###Post method

 
	private static final String ADD = "/addOrder";
	private static final String ADD = "/addOrder";
	private static final String ORDER = "/camelOrder";
	private static final String ALL = "/getOrders";
	private static final String BY_ID = "/getOrderById/{id}";
	private static final String MSG = "Demo camel with spring boot";

	rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
			.route().process(processor).endRest();

			http://localhost:9090/addStudent


{
"name":"akshit",
"email":"akshit@gmail.com",
"course":"MCA"
}

# Get method
## it will return all orders list
http://localhost:9090/getOrders

