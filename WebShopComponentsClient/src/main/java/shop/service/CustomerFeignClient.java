package shop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.DTODomain.CustomerDTO;

@FeignClient("CustomerService")
public interface CustomerFeignClient {

    @RequestMapping("/customer")
    public CustomerDTO  addProduct(@RequestBody CustomerDTO customerDTO);

    @RequestMapping("/customer/{customerId}")
    public CustomerDTO getProduct(@PathVariable("customerId") String customerNumber);
}
