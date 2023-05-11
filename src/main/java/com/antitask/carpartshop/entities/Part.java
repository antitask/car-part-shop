package com.antitask.carpartshop.entities;

import javax.persistence.*;
import java.time.LocalDate;


public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDate year;
    private boolean used;
}
