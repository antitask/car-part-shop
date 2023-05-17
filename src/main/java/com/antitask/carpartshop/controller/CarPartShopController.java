package com.antitask.carpartshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.antitask.carpartshop.dto.PartDTO;
import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.service.CarPartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CarPartShopController {

    @Autowired
    CarPartService carPartService;

    @GetMapping("/parts")
    public ResponseEntity<List<Part>> getCarParts(@Nullable @RequestParam String limit) throws Exception {
        return ResponseEntity.ok().body(carPartService.partsLimited(limit));
    }

    @GetMapping("/parts/{name}")
    public ResponseEntity<Part> getCarPart(@PathVariable String name) throws Exception {
        return ResponseEntity.ok().body(carPartService.partByName(name));
    }
    @PostMapping("/parts")
    public ResponseEntity<Part> postCarPart(@RequestBody PartDTO partDTO){
        return ResponseEntity.ok().body(carPartService.savePart(partDTO));
    }


}
