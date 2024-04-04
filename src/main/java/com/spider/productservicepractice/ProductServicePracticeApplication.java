package com.spider.productservicepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
@EnableJpaRepositories
public class ProductServicePracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServicePracticeApplication.class, args);
    }

}
