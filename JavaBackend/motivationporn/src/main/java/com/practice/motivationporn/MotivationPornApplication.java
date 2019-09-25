package com.practice.motivationporn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author haoyue
 */
@SpringBootApplication
@EnableCaching
public class MotivationPornApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotivationPornApplication.class, args);
    }

}
