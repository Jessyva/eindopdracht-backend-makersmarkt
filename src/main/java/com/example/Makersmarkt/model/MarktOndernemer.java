package com.example.Makersmarkt.model;

import java.util.List;

public class MarktOndernemer extends Gebruiker {
    private List<Markt> markten;
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Markt> getMarkten() {
        return markten;
    }

    public void setMarkten(List<Markt> markten) {
        this.markten = markten;
    }

    // getters en setters
}
