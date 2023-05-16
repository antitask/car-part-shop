package com.antitask.carpartshop;

import com.antitask.carpartshop.repository.CarPartRepository;
import com.antitask.carpartshop.service.PartSeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarPartShopApp implements ApplicationRunner {

    @Autowired
    CarPartRepository carPartRepository;
    @Autowired
    PartSeedService partSeedService;

    public static void main(String[] args) {
        SpringApplication.run(CarPartShopApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        partSeedService.seed();
    }

}
