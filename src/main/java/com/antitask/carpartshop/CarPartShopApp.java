package com.antitask.carpartshop;

import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
    }
    private void seed(){
        Part part = new Part();
        part.setName("wheel");
        Part part1 = new Part();
        part1.setName("break");
        Part part2 = new Part();
        part2.setName("clutch");
        List<Part> parts = List.of(part, part1, part2);
        carPartRepository.saveAll(parts);
    }
}
