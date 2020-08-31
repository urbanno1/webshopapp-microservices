package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;


@Component
public class ProductCatalogProxy {
	@Autowired
	private RestOperations restTemplate;
	@Value("${productsURL}")
	String productsURL;
	
	public void updateStock(String productNumber, int quantity) {
		restTemplate.postForLocation(productsURL+"/updateStock/"+productNumber+"/"+quantity, null);
	};
}
