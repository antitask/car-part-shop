package com.antitask.carpartshop.entities;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.Data;


@Entity
@Table(name = "parts")
@Data
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
