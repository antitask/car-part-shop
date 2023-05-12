package com.antitask.carpartshop.repository;


import com.antitask.carpartshop.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartRepository extends JpaRepository<Part, Integer> {
  Part findByName(String name);
}
