package com.malefashionshop;

import com.malefashionshop.service.impl.ImagesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Application {
    @Resource
    ImagesStorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... arg) throws Exception {
//        storageService.init();
//    }
}
