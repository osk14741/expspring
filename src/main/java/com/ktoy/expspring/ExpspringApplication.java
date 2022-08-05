package com.ktoy.expspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAspectJAutoProxy
@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class ExpspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpspringApplication.class, args);
    }

}
