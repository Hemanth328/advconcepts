package infy.org.m2.service;

import infy.org.m2.dto.ProductDto;
import infy.org.m2.entity.Product;
import infy.org.m2.repo.IProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class M2ProductServiceImpl {

    private final IProductRepo productRepo;

    public M2ProductServiceImpl(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

     public List<ProductDto> fetchFilteredProducts(String category, int limit) {
         log.info("M2 Service : Fetching products for category: {} and limit: {}", category, limit);
//         List<Product> products = productRepo.findByCategory(category, PageRequest.of(0, limit));
         return new ArrayList<>();
     }
}
