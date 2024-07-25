package com.example.Makersmarkt.Exception;

public class UnauthorizedAccessExceptionBuilder {

    public UnauthorizedAccessException createUnauthorizedAccessException() {
        return new UnauthorizedAccessException("Toegang is niet toegestaan.");
    }
}
