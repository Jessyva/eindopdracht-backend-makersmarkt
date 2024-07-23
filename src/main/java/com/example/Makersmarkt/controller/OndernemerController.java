package com.example.Makersmarkt.controller;

import com.example.Makersmarkt.dto.MarktOndernemerDTO;
import com.example.Makersmarkt.dto.OndernemerDTO;
import com.example.Makersmarkt.dto.ProductondernemerDTO;
import com.example.Makersmarkt.service.OndernemerService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class OndernemerController {

    private final com.example.Makersmarkt.service.OndernemerService OndernemerService;
    private final PasswordEncoder passwordEncoder;

    public OndernemerController(OndernemerService OndernemerService, PasswordEncoder passwordEncoder) {
        this.OndernemerService = OndernemerService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<OndernemerDTO>> getUsers() {
        List<OndernemerDTO> userDtos = OndernemerService.getOndernemers();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<OndernemerDTO> getUser(@PathVariable("username") String username) {
        OndernemerDTO optionalUser = OndernemerService.getOndernemer(username);
        return ResponseEntity.ok().body(optionalUser);
    }

    @PostMapping(value = "/marktondernemer")
    public ResponseEntity<OndernemerDTO> createMarktOndernemer(@RequestBody MarktOndernemerDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        String newUsername = OndernemerService.createOndernemer(dto);
        OndernemerService.addAuthority(newUsername, "ROLE_MARKT_ONDERNEMER");
        String location;
        Object UriBuilderUtil = null;
        location = UriBuilderUtil.toString();

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PostMapping(value = "/productondernemer")
    public ResponseEntity<OndernemerDTO> createProductOndernemer(@RequestBody ProductondernemerDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        String newUsername = OndernemerService.createUser(dto);
        OndernemerService.addAuthority(newUsername, "ROLE_PRODUCT_ONDERNEMER");
        Object UriBuilderUtil = null;
        URI location = URI.create(UriBuilderUtil.toString());

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<OndernemerDTO> updateUserPassword(@PathVariable("username") String username, @RequestBody OndernemerDTO dto) throws UnauthorizedAccessException {
        String currentUsername = OndernemerService.getCurrentLoggedInUsername();
        if (!currentUsername.equals(username)) {
            throw new UnauthorizedAccessExceptionBuilder().createUnauthorizedAccessException();
        }
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());
            dto.setPassword(encryptedPassword);
        }

        OndernemerService.updateOndernemerPassword(username, DTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        OndernemerService.deleteOndernemer(username);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(OndernemerService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) throws BadRequestException {
        try {
            String authorityName = (String) fields.get("authority");
            OndernemerService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        OndernemerService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }
}
