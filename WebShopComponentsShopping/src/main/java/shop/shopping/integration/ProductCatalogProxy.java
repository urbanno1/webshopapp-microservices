package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import shop.shopping.DTODomian.ProductDTO;

@Component
public class ProductCatalogProxy {
	@Autowired
	private RestOperations restTemplate;
	@Value("${productsURL}")
	String productsURL;
	
	public ProductDTO getProduct(String productnumber) {
		ProductDTO product = restTemplate.getForObject(productsURL+"/product/A33", ProductDTO.class);
		return product;
	};
}
