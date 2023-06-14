package org.demo.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoMicrosrvcMain {
    public static void main(String[] args) {
        SpringApplication.run(DemoMicrosrvcMain.class,args);

//        System.out.println("Hello world!");
    }
}