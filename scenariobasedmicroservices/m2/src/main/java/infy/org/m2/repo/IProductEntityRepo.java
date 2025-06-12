package infy.org.m2.repo;

import infy.org.m2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductEntityRepo extends JpaRepository<ProductEntity, Integer> {
}
