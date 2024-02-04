package org.example.web;

import lombok.AllArgsConstructor;
import org.example.entities.Product;
import org.example.repos.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ApiWeb {
    ProductRepo productRepo;

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    @PostMapping("products")
    public Product addProduct(@RequestBody Product p){
        return productRepo.save(p);
    }
    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepo.findById(id).get();
    }
}
