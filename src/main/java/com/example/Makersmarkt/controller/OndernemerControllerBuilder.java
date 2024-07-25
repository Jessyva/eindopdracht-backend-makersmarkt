package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.service.OndernemerService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class OndernemerControllerBuilder {
    private OndernemerService ondernemerService;
    private PasswordEncoder passwordEncoder;

    public OndernemerControllerBuilder setOndernemerService(OndernemerService ondernemerService) {
        this.ondernemerService = ondernemerService;
        return this;
    }

    public OndernemerControllerBuilder setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        return this;
    }

    public OndernemerController createOndernemerController() {
        return new OndernemerController(ondernemerService, passwordEncoder);
    }
}