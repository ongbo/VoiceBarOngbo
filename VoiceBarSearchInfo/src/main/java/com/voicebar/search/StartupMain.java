package com.voicebar.search;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableAutoConfiguration
//@EnableAutoConfiguration
public class StartupMain {
    public static void main(String[] args) {
        SpringApplication.run(StartupMain.class, args);
    }
}
