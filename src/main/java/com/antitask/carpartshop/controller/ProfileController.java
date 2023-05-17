package com.antitask.carpartshop.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class ProfileController {
  @Value("${filepath}")
  String filepath;

  @PostMapping("/profile/logo")
  public ResponseEntity<String> getCarPart(@RequestParam("logo") MultipartFile logo) throws Exception {
    byte[] bytes = logo.getBytes();
    String filename = logo.getOriginalFilename();
    Path filePath = Paths.get(filepath + filename);
    Files.write(filePath, bytes);

    //    if there a file
//    file size
//    file extension
    System.out.println("filesize: " + logo.getSize());
    String extension = logo.getOriginalFilename().substring(logo.getOriginalFilename().length() - 3);
    System.out.println("extension: " + extension);
    scenarios:


    return ResponseEntity.ok().body("Profile logo uploaded!");
  }
}
