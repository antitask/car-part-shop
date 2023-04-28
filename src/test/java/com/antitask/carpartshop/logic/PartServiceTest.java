package com.antitask.carpartshop.logic;

import com.antitask.carpartshop.data.PartDataSource;
import com.antitask.carpartshop.model.Part;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartServiceTest {
    private PartService partService;

    @BeforeEach
    void setUp() {
        partService = new PartService(new PartDataSource().getParts());
    }

    @Test
    void getPartsById() throws Exception {
        List<Part> partsById = partService.getPartsById(1);
        assertEquals(1, partsById.size());
    }

    @Test
    void getPartsByName() throws Exception {

        List<Part> partsByName = partService.getPartsByName("roof");
        assertEquals(1, partsByName.size());

    }

    @Test
    void getPartsByUsage() throws Exception {
        List<Part> partsByUsage = partService.getPartsByUsage(true);
        assertEquals(2, partsByUsage.size());
    }

    @Test
    void getPartsByDateProduced() throws Exception {
        List<Part> partsById = partService.getPartsByDateProduced(LocalDate.of(2020, 1, 1));
        assertEquals(1, partsById.size());
    }

    @Test
    void getPartsAfterDatesProduced() throws Exception {
        LocalDate datum = LocalDate.of(2021, 1, 1);
        List<Part> partsAfterDatesProduced = partService.getPartsAfterDatesProduced(datum);
        assertEquals(3, partsAfterDatesProduced.size());
    }

    @Test
    void getPartsBeforeDatesProduced() throws Exception {
        LocalDate datum = LocalDate.of(2021, 1, 1);
        List<Part> partsBeforeDatesProduces = partService.getPartsBeforeDatesProduced(datum);
        assertEquals(1, partsBeforeDatesProduces.size());
    }

    @Test
    void getPartsBetweenDatesProduced() throws Exception {
        List<Part> partsByBetweenDatesProduced = partService.getPartsBetweenDatesProduced(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1));
        assertEquals(2, partsByBetweenDatesProduced.size());
    }
}