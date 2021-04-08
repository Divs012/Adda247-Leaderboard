package com.divya.microservice.marks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class MarksServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarksServiceApplication.class, args);
    }

}
