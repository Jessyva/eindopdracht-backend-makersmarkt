package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.model.MarktOndernemer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/marktondernemers")
public class MarktOndernemerController {

    @Autowired
    private MarktOndernemerService marktOndernemerService;

    @GetMapping
    public List<MarktOndernemer> getAllMarktOndernemers() {
        return marktOndernemerService.getAllMarktOndernemers();
    }

    @PostMapping
    public MarktOndernemer createMarktOndernemer(@RequestBody MarktOndernemer marktOndernemer) {
        return marktOndernemerService.createMarktOndernemer(marktOndernemer);
    }

    // andere endpoints
}
