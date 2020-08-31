package shop.products.service;

import shop.products.DTODomian.ProductDTO;
import shop.products.domain.Stock;

public interface ProductCatalogService {

    public void addProduct(String productnumber, String description, double price);
    public ProductDTO getProduct(String productnumber);
    public void setStock(String productnumber, int quantity, String locationcode);
    public Stock getStock(String productnumber);
    public void updateStock(String productnumber, int quantity);

}
