package com.example.Makersmarkt.controller;


public class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String message) {
        super(message); // Roep de constructor van Exception aan
    }
}
