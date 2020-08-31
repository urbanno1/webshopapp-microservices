package shop.products.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.products.DTODomian.ProductDTO;
import shop.products.domain.Product;
import shop.products.domain.Stock;
import shop.products.repository.ProductRepository;
import shop.products.DTOAdapter.ProductAdapter;
import shop.products.service.ProductCatalogService;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public void addProduct(String productnumber, String description, double price) {
		Product product = new Product(productnumber, description,  price);
		productRepository.save(product);
		
	}

	@Override
	public ProductDTO getProduct(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent())
		  return ProductAdapter.getProductDTO(result.get());
		else
			return null;
	}

	@Override
	public void setStock(String productnumber, int quantity, String locationcode) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, locationcode);
			product.setStock(stock);
			productRepository.save(product);
		}		
	}

	@Override
	public Stock getStock(String productnumber) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = product.getStock();
			return stock;
		}
		return null;
	}

	@Override
	public void updateStock(String productnumber, int quantity) {
		Optional<Product> result = productRepository.findById(productnumber);
		if (result.isPresent()) {
			Product product = result.get();
			Stock stock = new Stock(quantity, product.getStock().getLocationcode());
			product.setStock(stock);
			productRepository.save(product);
		}		
	}
}
