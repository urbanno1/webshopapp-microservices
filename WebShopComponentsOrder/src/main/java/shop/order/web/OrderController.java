package shop.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shop.order.DTODomain.OrderDTO;
import shop.order.service.OrderService;
import shop.order.DTODomain.ShoppingCartDTO;


@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/order/{orderNumber}")
	public ResponseEntity<?> getCart(@PathVariable String orderNumber) {
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@PostMapping("/order/{orderNumber}")
	public void confirm(@PathVariable String orderNumber) {
		orderService.confirm(orderNumber);
	}
	
	@PostMapping("/order/setCustomer/{orderNumber}/{customerNumber}")
	public ResponseEntity<?> SetCustomer(@PathVariable String orderNumber,@PathVariable String customerNumber) {
		orderService.setCustomer(orderNumber,customerNumber);
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@PostMapping("/order/create")
	public void createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO) {	
		orderService.createOrder(shoppingCartDTO);
	}
	
}
