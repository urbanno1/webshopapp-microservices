package shop.customers.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.customers.DTOAdapter.CustomerAdapter;
import shop.customers.DTOAdapter.OrderCustomerAdapter;
import shop.customers.DTODomain.CustomerDTO;
import shop.customers.DTODomain.OrderCustomerDTO;
import shop.customers.domain.Customer;
import shop.customers.repository.CustomerRepository;
import shop.customers.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void addCustomer(CustomerDTO customer) {
		customerRepository.save(CustomerAdapter.getCustomer(customer));
	}

	@Override
	public CustomerDTO getCustomer(String customerNumber) {
	  Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
	  if (customerOptional.isPresent()) {
		  Customer customer = customerOptional.get();
		  return CustomerAdapter.getCustomerDTO(customer);
	  }
	  else
		  return null;
  }

	@Override
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		  Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
		  if (customerOptional.isPresent()) {
			  Customer customer = customerOptional.get();
			  return OrderCustomerAdapter.getOrderCustomerDTO(customer);
		  }
		  else
			  return null;
	}
}
