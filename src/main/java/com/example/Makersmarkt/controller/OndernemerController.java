package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.Exception.UnauthorizedAccessExceptionBuilder;
import com.example.Makersmarkt.dto.OndernemerDTO;
import com.example.Makersmarkt.service.OndernemerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class OndernemerController {

    private final OndernemerService ondernemerService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public OndernemerController(OndernemerService ondernemerService, PasswordEncoder passwordEncoder) {
        this.ondernemerService = ondernemerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping("/{username}")
    public ResponseEntity<Void> updateUserPassword(@PathVariable("username") String username, @RequestBody OndernemerDTO dto) {
        String currentUsername = ondernemerService.getCurrentLoggedInUsername();
        if (!currentUsername.equals(username)) {
            throw new UnauthorizedAccessExceptionBuilder().createUnauthorizedAccessException();
        }
        if (dto.getPassword() != null) {
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());
            dto.setPassword(encryptedPassword);
        }
        ondernemerService.updateUserPassword(username, dto);
        return ResponseEntity.noContent().build();
    }
}
