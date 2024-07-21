package com.example.Makersmarkt.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Markt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private String locatie;
    private Date datum;
    private String website;

    @ManyToMany
    @JoinTable(
            name = "markt_ondernemers",
            joinColumns = @JoinColumn(name = "markt_id"),
            inverseJoinColumns = @JoinColumn(name = "ondernemer_id")
    )
    private List<ProductOndernemer> ondernemers;

    // Constructors
    public Markt() {}

    public Markt(String naam, String locatie, Date datum, String website, List<String> socialeMediaLinks) {
        this.naam = naam;
        this.locatie = locatie;
        this.datum = datum;
        this.website = website;
    }

    // Getters en Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<ProductOndernemer> getOndernemers() {
        return ondernemers;
    }

    public void setOndernemers(List<ProductOndernemer> ondernemers) {
        this.ondernemers = ondernemers;
    }
}
