package com.antitask.carpartshop.data;

import lombok.Data;
import com.antitask.carpartshop.model.Part;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PartDataSource {

    List<Part> parts = new ArrayList<>();

    public PartDataSource() {
        seed();
    }

    private void seed() {
        Part part = new Part(1L, false, "wheel", LocalDate.of(2020, 1, 1));
        Part part1 = new Part(2L, true, "roof", LocalDate.of(2021, 1, 1));
        Part part2 = new Part(3L, false, "clutch", LocalDate.of(2022, 1, 1));
        Part part3 = new Part(4L, true, "tire", LocalDate.of(2023, 1, 1));
        Part part4 = new Part(5L, false, "break", LocalDate.of(2024, 1, 1));
        parts.add(part);
        parts.add(part1);
        parts.add(part2);
        parts.add(part3);
        parts.add(part4);
    }

}
