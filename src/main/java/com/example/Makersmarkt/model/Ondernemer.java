package com.example.Makersmarkt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ondernemer")
public class Ondernemer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ondernemer_id")
    private Long entrepreneurId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false, unique = true)
    private String email;
}
