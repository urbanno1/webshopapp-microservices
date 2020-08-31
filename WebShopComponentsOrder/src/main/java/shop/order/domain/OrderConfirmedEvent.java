package shop.order.domain;

import shop.order.DTODomain.OrderDTO;

public class OrderConfirmedEvent {
	private OrderDTO orderDTO;

	public OrderConfirmedEvent(OrderDTO orderDTO) {
		super();
		this.orderDTO = orderDTO;
	}

	public OrderDTO getOrder() {
		return orderDTO;
	}
}
