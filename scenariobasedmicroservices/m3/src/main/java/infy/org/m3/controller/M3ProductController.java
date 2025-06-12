package infy.org.m3.controller;

import infy.org.m3.dto.ProductDto;
import infy.org.m3.service.M3ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class M3ProductController {

    private final M3ProductServiceImpl m3ProductService;

    public M3ProductController(M3ProductServiceImpl m3ProductService) {
        this.m3ProductService = m3ProductService;
    }

    @GetMapping("/products/filter/{category}")
    public List<ProductDto> fetchProducts(@PathVariable String category, @RequestParam int limit) {
        log.info("M3 Controller : Fetching products for category: {} and limit: {}", category, limit);
        return m3ProductService.fetchProducts(category, limit);
    }
}
