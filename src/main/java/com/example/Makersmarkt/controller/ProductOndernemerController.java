package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.ProductOndernemer;
import com.example.Makersmarkt.service.ProductOndernemerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Andere endpoints
}
