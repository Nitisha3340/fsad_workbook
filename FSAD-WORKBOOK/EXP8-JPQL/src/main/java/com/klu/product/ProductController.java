package com.klu.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Insert sample products
    @PostMapping("/add")
    public String addProducts() {

        repo.save(new Product("Laptop","Electronics",65000));
        repo.save(new Product("Phone","Electronics",25000));
        repo.save(new Product("Shoes","Fashion",3000));
        repo.save(new Product("Watch","Fashion",7000));
        repo.save(new Product("TV","Electronics",55000));

        return "Products inserted";
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filterPrice(
            @RequestParam double min,
            @RequestParam double max) {

        return repo.findByPriceBetween(min, max);
    }

    // Sorted by price
    @GetMapping("/sorted")
    public List<Product> sortedProducts() {
        return repo.getProductsSortedByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
}