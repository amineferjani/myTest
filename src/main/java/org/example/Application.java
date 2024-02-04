package org.example;

import org.example.entities.Product;
import org.example.repos.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.example.controller.PingController;

import java.rmi.server.UID;
import java.util.UUID;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "org.example.controller")
@Import({ PingController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepo productRepo){
        return args -> {
            productRepo.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Television")
                    .qte(20)
                    .prix(1200)
                    .build());
            productRepo.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Unité centrale")
                    .qte(215)
                    .prix(256)
                    .build());
            productRepo.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Play Station 5")
                    .qte(16)
                    .prix(1100)
                    .build());
        };
    }
}
