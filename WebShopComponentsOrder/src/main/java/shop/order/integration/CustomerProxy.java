package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import shop.order.DTODomain.OrderCustomerDTO;



@Component
public class CustomerProxy {
	@Autowired
	private RestOperations restTemplate;
	@Value("${customersURL}")
	String customersURL;
	
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		OrderCustomerDTO customer = restTemplate.getForObject(customersURL+"/ordercustomer/"+customerNumber, OrderCustomerDTO.class);
		return customer;
	};
}



