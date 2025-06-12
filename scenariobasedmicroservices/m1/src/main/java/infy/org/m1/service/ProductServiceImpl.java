package infy.org.m1.service;

import infy.org.m1.dto.ProductDto;
import infy.org.m1.service.client.M2Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl {

    private final M2Client m2Client;

    public ProductServiceImpl(M2Client m2Client) {
        this.m2Client = m2Client;
    }

    @CircuitBreaker(name = "", fallbackMethod = "fetchFilteredProductFallBackMethod")
    public List<ProductDto> fetchFilteredProducts(String category, int limit) {
        log.info("M1 Service : Fetching products for category: {} and limit: {}", category, limit);
        return m2Client.getProductFromM2(category, limit);
    }

//    private List<ProductDto> fetchFilteredProductFallBackMethod(String category, int limit) {
//
//    }
}
