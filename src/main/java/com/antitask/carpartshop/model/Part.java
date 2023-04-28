package com.antitask.carpartshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Part {
    Long id;
    boolean used;
    String name;
    LocalDate dateProduced;
}
