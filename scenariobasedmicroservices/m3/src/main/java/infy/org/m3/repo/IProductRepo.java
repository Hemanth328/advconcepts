package infy.org.m3.repo;

import infy.org.m3.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category, PageRequest pageRequest);
}
