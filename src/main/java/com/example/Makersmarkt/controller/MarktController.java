package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.Markt;
import com.example.Makersmarkt.service.MarktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Markt createMarkt(@RequestBody Markt markt) {
        return marktService.createMarkt(markt);
    }


    // andere endpoints
}
