package shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.DTODomain.CustomerDTO;
import shop.service.CustomerFeignClient;

@RestController
public class WebShopCustomerClientController {

    @Autowired
    private CustomerFeignClient customerFeignClient;

    @RequestMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerFeignClient.addProduct(customerDTO), HttpStatus.CREATED);
    }

}
