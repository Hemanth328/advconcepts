package infy.org.m1.service.client;

import infy.org.m1.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "m3")
public interface M3Client {

    @GetMapping("/products/filter/{category}")
    List<ProductDto> getProductFromM2(@PathVariable String category, @RequestParam int limit);
}
