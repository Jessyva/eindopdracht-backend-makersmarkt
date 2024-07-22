package com.example.Makersmarkt.model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MarktOndernemer extends Ondernemer {
    private List<Markt> markten;
    private String website;

}
