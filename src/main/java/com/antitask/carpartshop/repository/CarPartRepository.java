package com.antitask.carpartshop.repository;


import java.util.List;
import com.antitask.carpartshop.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartRepository extends JpaRepository<Part, Integer> {
  Part findByName(String name);
  @Query(value = "select * from parts limit :limit", nativeQuery = true)
  List<Part> findByLimit(String limit);
}
