package com.example.Makersmarkt.service;

import com.example.Makersmarkt.model.ProductOndernemer;
import com.example.Makersmarkt.repository.ProductOndernemerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOndernemerService {

    @Autowired
    private ProductOndernemerRepository productOndernemerRepository;

    public List<ProductOndernemer> getAllProductOndernemers() {
        return productOndernemerRepository.findAll();
    }

    public ProductOndernemer createProductOndernemer(ProductOndernemer productOndernemer) {
        return productOndernemerRepository.save(productOndernemer);
    }
}
