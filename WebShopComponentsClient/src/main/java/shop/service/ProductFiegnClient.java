package shop.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ProductService")
public interface ProductFiegnClient {

}
