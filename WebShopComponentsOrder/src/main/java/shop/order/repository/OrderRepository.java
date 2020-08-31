package shop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import shop.order.domain.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

}
