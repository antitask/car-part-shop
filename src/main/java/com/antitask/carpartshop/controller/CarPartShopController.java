package com.antitask.carpartshop.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import com.antitask.carpartshop.entities.Part;
import com.antitask.carpartshop.service.CarPartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CarPartShopController {

    @Autowired
    CarPartService carPartService;

    @GetMapping("/parts/{name}")
    public ResponseEntity<Part> getCarPart(@PathVariable String name){
        return ResponseEntity.ok().body(carPartService.partByName(name));
    }
}
