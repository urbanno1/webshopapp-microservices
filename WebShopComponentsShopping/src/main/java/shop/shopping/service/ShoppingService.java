package shop.shopping.service;

import shop.shopping.DTODomian.ShoppingCartDTO;

public interface ShoppingService {

	public void addToCart(String cartId, String productnumber, int quantity);
	
	public ShoppingCartDTO getCart(String cartId);

	public void checkout(String cartId);
}
