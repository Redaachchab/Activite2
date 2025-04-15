package com.ouahbi.jee_activite2.web;

import com.ouahbi.jee_activite2.entities.Product;
import com.ouahbi.jee_activite2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findProducts(@PathVariable long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }
}
