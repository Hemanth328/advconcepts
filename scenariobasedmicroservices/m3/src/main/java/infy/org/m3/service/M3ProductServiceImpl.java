package infy.org.m3.service;

import infy.org.m3.dto.ProductDto;
import infy.org.m3.entity.Product;
import infy.org.m3.repo.IProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class M3ProductServiceImpl {

    private final IProductRepo productRepo;

    public M3ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductDto> fetchProducts(String category, int limit) {
        log.info("M3 Service : Fetching products for category: {} and limit: {}", category, limit);
//        List<Product> productList  = productRepo.findByCategory(category, PageRequest.of(0, limit));
        return new ArrayList<>();
    }
}
