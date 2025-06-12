package infy.org.m2.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@JsonFilter("ProductFilter")
@Entity
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private String description;

}
