package com.example.Makersmarkt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OndernemerDTO {
    private Long ondernemerID;
    private String name;
    private String place;
    private String email;

    public CharSequence getPassword() {
        return null;
    }

    public void setPassword(String encryptedPassword) {
    }
}
