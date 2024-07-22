package com.example.Makersmarkt.model;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private String beschrijving;
    private String fotoUrl;

    @ManyToOne
    @JoinColumn(name = "product_ondernemer_id")
    private ProductOndernemer productOndernemer;

    // Constructors
    public Product() {
    }

    public Product(String naam, String beschrijving, String fotoUrl) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.fotoUrl = fotoUrl;
    }
}