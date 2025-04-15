package com.ouahbi.jee_activite2.repository;

import com.ouahbi.jee_activite2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);


    @Query("select p FROM Product p where p.name like :x")
    List<Product> search(@Param("x") String mc);
    @Query("select p FROM Product p where p.price > :x")
    List<Product> searchPrice(@Param("x") double price);
}
