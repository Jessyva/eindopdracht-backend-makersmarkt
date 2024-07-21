package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.ProductOndernemer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/productondernemers")
public class ProductOndernemerController {

    @Autowired
    private ProductOndernemerService productOndernemerService;

    @GetMapping
    public List<ProductOndernemer> getAllProductOndernemers() {
        return productOndernemerService.getAllProductOndernemers();
    }

    @PostMapping
    public ProductOndernemer createProductOndernemer(@RequestBody ProductOndernemer productOndernemer) {
        return productOndernemerService.createProductOndernemer(productOndernemer);
    }

    // andere endpoints
}
