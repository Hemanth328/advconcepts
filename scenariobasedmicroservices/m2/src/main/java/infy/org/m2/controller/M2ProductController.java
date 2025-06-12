package infy.org.m2.controller;

import infy.org.m2.dto.ProductDto;
import infy.org.m2.service.M2ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class M2ProductController {

    private M2ProductServiceImpl m2ProductService;

    public M2ProductController(M2ProductServiceImpl m2ProductService) {
        this.m2ProductService = m2ProductService;
    }

    @GetMapping("/products/filter/{category}")
    public ResponseEntity<List<ProductDto>> fetchFilteredProducts(@PathVariable String category, @RequestParam int limit) {
        log.info("M2 Controller : Fetching products for category: {} and limit: {}", category, limit);
        return ResponseEntity.ok(m2ProductService.fetchFilteredProducts(category, limit));
    }

//    @GetMapping("/productsentity/{id}")
//    public MappingJacksonValue fetchProductsEntity(@PathVariable int id, @RequestParam(required = false) ) {
//        log.info("M2 Controller : Fetching products entity for id: {}", id);
//    }
}
