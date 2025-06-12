package infy.org.m1.service.client;

import infy.org.m1.dto.ProductDto;
import infy.org.m1.service.ClientImpl.M2ClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name = "m2", fallback = M2ClientFallback.class)
public interface M2Client {

    @GetMapping("/products/filter/{category}")
    List<ProductDto> getProductFromM2(@PathVariable String category, @RequestParam int limit);
}
