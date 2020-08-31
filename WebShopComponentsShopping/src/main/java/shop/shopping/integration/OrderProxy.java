package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import shop.shopping.DTODomian.ShoppingCartDTO;

@Component
public class OrderProxy {
	@Autowired
	private RestOperations restTemplate;
	@Value("${ordersURL}")
	String ordersURL;

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {		
		restTemplate.postForLocation(ordersURL+"/order/create", shoppingCartDTO);		
	};
}
