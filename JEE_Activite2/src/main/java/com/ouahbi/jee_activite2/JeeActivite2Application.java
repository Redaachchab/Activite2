package com.ouahbi.jee_activite2;

import com.ouahbi.jee_activite2.entities.Product;
import com.ouahbi.jee_activite2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JeeActivite2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(JeeActivite2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //productRepository.save(new Product(null, "pomme", 12,100));
        //productRepository.save(new Product(null, "banane", 4,120));
        //productRepository.save(new Product(null, "orange", 8,80));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{System.out.println(p.toString());});
        System.out.println("---------------------------------");
        List<Product> productList = productRepository.findByNameContains("o");
        productList.forEach(p->{System.out.println(p.toString());});
        System.out.println("---------------------------------");
        List<Product> productList2 = productRepository.search("%a%");
        productList2.forEach(p->{System.out.println(p.toString());});
        System.out.println("---------------------------------");
        List<Product> productList3 = productRepository.findByPriceGreaterThan(10);
        productList3.forEach(p->{System.out.println(p.toString());});
        System.out.println("---------------------------------");
        List<Product> productList4 = productRepository.searchPrice(7);
        productList4.forEach(p->{System.out.println(p.toString());});
    }
}
