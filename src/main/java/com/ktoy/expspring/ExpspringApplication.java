package com.ktoy.expspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class ExpspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpspringApplication.class, args);
    }

}
