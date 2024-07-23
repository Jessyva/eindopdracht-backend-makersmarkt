package com.example.Makersmarkt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductondernemerDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Place is mandatory")
    private String place;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    private List<String> socialMediaLinks; // Lijst van sociale mediakoppelingen

    private List<String> productPhotos; // Lijst van URLs van productfoto's

    public void setPassword(String encode) {

    }

    public CharSequence getPassword() {
        return null;
    }
}
