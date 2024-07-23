package com.example.Makersmarkt.service;

import com.example.Makersmarkt.model.Markt;
import java.util.ArrayList;
import java.util.List;

public class MarktService {
    private Object id;
    private Object name;
    private Object description;

    public List<Markt> getAllMarkt() {
        List<Markt> markt = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.description = description;
        return markt;
    }

    public Markt createMarkt(Markt markt) {
        return null;
    }
}
