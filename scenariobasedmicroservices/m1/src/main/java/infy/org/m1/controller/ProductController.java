package infy.org.m1.controller;

import infy.org.m1.dto.ProductDto;
import infy.org.m1.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductDto>> fetchFilteredProducts(@PathVariable String category, @RequestParam(defaultValue = "100") int limit) {
        log.info("M1 Controller : Fetching products for category: {} and limit: {}", category, limit);
        List<ProductDto> products = productServiceImpl.fetchFilteredProducts(category, limit);
        return ResponseEntity.ok(products);
    }
}
