package com.antitask.carpartshop.service;

import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        List<Part> parts = List.of(part, part1, part2);
        carPartRepository.saveAll(parts);
    }
}