package com.example.Makersmarkt.service;

import com.example.Makersmarkt.model.Markt;
import java.util.List;
import java.util.Optional;

public interface MarktService {
    List<Markt> getAllMarkten();
    Optional<Markt> getMarktById(Long id);
    Markt createMarkt(Markt markt);
    Markt updateMarkt(Long id, Markt markt);
    void deleteMarkt(Long id);

    List<Markt> getAllMarkt();
}
