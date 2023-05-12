package com.antitask.carpartshop.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarPartService {

    @Autowired
    CarPartRepository carPartRepository;

    public Part partByName(String name){
        return carPartRepository.findByName(name);
    }
}
