package com.antitask.carpartshop;

import java.util.ArrayList;
import java.util.List;
import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarPartShopApp implements ApplicationRunner {

    @Autowired
    CarPartRepository carPartRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarPartShopApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seed();
        //mnogo toga drugog
    }
    private void seed(){
        Part part = new Part();
        part.setName("break");
        Part part1 = new Part();
        part1.setName("wheel");
        List<Part> parts = List.of(part, part1);
        carPartRepository.saveAll(parts);
    }
}
