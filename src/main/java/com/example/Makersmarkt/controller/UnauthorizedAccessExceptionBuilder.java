package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.dto.OndernemerDTO;
import com.example.Makersmarkt.service.OndernemerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public class UnauthorizedAccessExceptionBuilder {
    @PutMapping(value = "/{username}")
    public ResponseEntity<OndernemerDTO> updateUserPassword(@PathVariable("username") String username, @RequestBody UserDto dto) throws UnauthorizedAccessException {
        String currentUsername = OndernemerService.getCurrentLoggedInUsername();
        if (!currentUsername.equals(username)) {
            throw new UnauthorizedAccessException("You are not authorized to update this user.");
        }
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());
            dto.setPassword(encryptedPassword);
        }
        OndernemerService.updateUserPassword(username, dto);
        return ResponseEntity.noContent().build();

    }

    public UnauthorizedAccessException createUnauthorizedAccessException() {
        return new UnauthorizedAccessException("You are not authorized to update this user.");
    }
}

