package com.antitask.carpartshop.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import com.antitask.carpartshop.dto.PartDTO;
import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPartService {

    @Autowired
    CarPartRepository carPartRepository;

    public Part partByName(String name) throws Exception {
        Part part = carPartRepository.findByName(name);
        if(part == null){
            throw new Exception("no part found!!!");
        }else {
            return part;
        }
    }

    public Part savePart(PartDTO partDTO){
        Part part = new Part();
        part.setName(partDTO.getName());
        return carPartRepository.save(part);
    }
    public List<Part> allParts () throws Exception{
        List <Part> parts = carPartRepository.findAll();
        if (parts.size() == 0) {
            throw new Exception("Nemamo nista");
        } else {
            return parts;
        }
    }

    public List<Part> partsLimited(String limit){
        return carPartRepository.findByLimit(limit);
    }

}
