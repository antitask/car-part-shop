package com.antitask.carpartshop.service;

import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class PartSeedService {
    private final CarPartRepository carPartRepository;

    public PartSeedService(CarPartRepository carPartRepository) {
        this.carPartRepository = carPartRepository;
    }

    public void seed() {
        Part part = new Part();
        part.setName("wheel");
        Part part1 = new Part();
        part1.setName("brake");
        Part part2 = new Part();
        part2.setName("clutch");
        Part part3 = new Part();
        part3.setName("battery");
        Part part4 = new Part();
        part4.setName("axle");
        Part part5 = new Part();
        part5.setName("bumper");
        Part part6 = new Part();
        part6.setName("suspension");
        Part part7 = new Part();
        part7.setName("engine");
        List<Part> parts = List.of(part, part1, part2, part3, part4, part5, part6, part7);
        carPartRepository.saveAll(parts);
    }
}