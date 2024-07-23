package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.ProductOndernemer;
import com.example.Makersmarkt.service.OndernemerService;
import com.example.Makersmarkt.service.ProductOndernemerService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/productondernemers")
@CrossOrigin(origins = "http://localhost:3000") // Pas dit aan indien nodig
public class ProductOndernemerController {

    @Autowired
    private ProductOndernemerService productOndernemerService;

    @GetMapping
    public ResponseEntity<List<ProductOndernemer>> getAllProductOndernemers() {
        List<ProductOndernemer> ProductOndernemers = productOndernemerService.getAllProductOndernemers();
        if (ProductOndernemers.isEmpty()) {
            return ResponseEntity.noContent().build(); // Geeft 204 No Content terug als er geen gegevens zijn
        }
        return ResponseEntity.ok(ProductOndernemers);
    }

    @PostMapping
    public ResponseEntity<ProductOndernemer> createProductOndernemer(@RequestBody ProductOndernemer productOndernemer) {
        ProductOndernemer createdProductOndernemer = productOndernemerService.createProductOndernemer(productOndernemer);
        if (createdProductOndernemer == null) {
            return ResponseEntity.badRequest().build(); // Geeft 400 Bad Request terug als de creatie mislukt
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductOndernemer);
    }

    private static final String UPLOADED_FOLDER = "uploaded/";

    @PostMapping
    public ResponseEntity<String> createProfile(@RequestParam("file") MultipartFile file,
                                                @RequestParam("name") String name,
                                                @RequestParam("description") String description) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            // Opslaan van het bestand
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, file.getBytes());

            // Opslaan van profielgegevens
            ProductOndernemerController profile = new ProductOndernemerController();
            profile.setName(name);
            profile.setDescription(description);
            profile.setPhotoPath(file.getOriginalFilename());
            Object userProfileService;
            OndernemerService.saveProfile(profile);

            return ResponseEntity.ok("Profile created successfully with photo: " + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    private void setPhotoPath(String originalFilename) {

    }

    private void setDescription(String description) {

    }

    private void setName(String name) {
    }

    @GetMapping("/photos/{filename}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String filename) throws MalformedURLException {
        Path file = Paths.get(UPLOADED_FOLDER).resolve(filename);
        Resource resource = (Resource) new UrlResource(file.toUri());
        return ResponseEntity.ok().body(resource);
    }
}
