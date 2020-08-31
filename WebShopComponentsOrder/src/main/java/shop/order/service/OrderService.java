package shop.order.service;

import shop.order.DTODomain.OrderDTO;
import shop.order.DTODomain.ShoppingCartDTO;

public interface OrderService {

    public OrderDTO getOrder(String orderNumber);

    public void createOrder(ShoppingCartDTO shoppingCartDTO);

    public void confirm(String orderNumber);

    public void setCustomer(String orderNumber, String customerNumber);

}
