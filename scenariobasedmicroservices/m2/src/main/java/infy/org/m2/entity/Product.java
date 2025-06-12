package infy.org.m2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private Long productId;

    private String category;
}
