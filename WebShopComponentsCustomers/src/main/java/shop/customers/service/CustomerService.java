package shop.customers.service;

import shop.customers.DTODomain.CustomerDTO;
import shop.customers.DTODomain.OrderCustomerDTO;

public interface CustomerService  {
    public void addCustomer(CustomerDTO customer);
    public CustomerDTO getCustomer(String customerNumber);
    public OrderCustomerDTO getOrderCustomer(String customerNumber);
}
