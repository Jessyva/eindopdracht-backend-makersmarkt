package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.Markt;
import com.example.Makersmarkt.model.ProductOndernemer;
import com.example.Makersmarkt.service.MarktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/markt")
public class MarktController {

    @Autowired
    private MarktService marktService;

    @GetMapping
    public List<Markt> getAllMarkt() {
        return marktService.getAllMarkt();
    }

    @PostMapping
    public ProductOndernemer createMarkt(@RequestBody Markt markt) {
        return marktService.getClass(markt);
    }

    // andere endpoints
}
